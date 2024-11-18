package pl.pwr.ite.bd2.client.security;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import pl.pwr.ite.bd2.security.AuthenticatedUser;
import pl.pwr.ite.bd2.security.ClaimsAuthenticatedUserTokenConverter;
import pl.pwr.ite.bd2.service.JwtService;
import pl.pwr.ite.bd2.service.UserService;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.io.IOException;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final ClaimsAuthenticatedUserTokenConverter tokenConverter;
    private final HandlerExceptionResolver handlerExceptionResolver;
    private final UserService userService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String accessToken = resolveToken(request);
        if(accessToken == null || accessToken.equals("null")) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            var userEmail = jwtService.extractUsername(accessToken);
            var authentication = SecurityContextHolder.getContext().getAuthentication();

            if(userEmail != null && authentication == null) {
                var authenticatedUser = (AuthenticatedUser) userService.loadUserByUsername(userEmail);
                if(jwtService.isTokenValid(accessToken, authenticatedUser)) {
                    var user = userService.findByEmail(userEmail);
                    var authorities = new HashSet<GrantedAuthority>();
                    userService.collectAuthorities(user, authorities);
                    var authToken = new UsernamePasswordAuthenticationToken(authenticatedUser, null, authorities);
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
            filterChain.doFilter(request, response);
        } catch (JwtException ex) {
            handlerExceptionResolver.resolveException(request, response, null, new ApplicationException(ApplicationError.InvalidJwtToken));
        } catch (Exception ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }

    private String resolveToken(HttpServletRequest request) {
        var resolver = new CustomBearerTokenResolver("authorization-token", "authorization");
        return resolver.resolve(request);
    }
}
