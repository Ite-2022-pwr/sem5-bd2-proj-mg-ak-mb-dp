package pl.pwr.ite.bd2.client.security;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.security.AuthenticatedUser;
import pl.pwr.ite.bd2.service.UserService;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class UserAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication instanceof UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
            return authenticate(usernamePasswordAuthenticationToken);
        }
        return null;
    }

    public Authentication authenticate(UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        var email = authentication.getPrincipal().toString();
        var user = userService.findByEmail(email);
        if(user == null) {
            throw new ApplicationException(ApplicationError.UserNotFound);
        }
        var passwordHash = user.getPasswordHash();
        if(passwordHash == null) {
            throw new ApplicationException(ApplicationError.PasswordHashNotPresent);
        }
        var presentedPassword = authentication.getCredentials().toString();
        if(!passwordEncoder.matches(presentedPassword, passwordHash)) {
            throw new ApplicationException(ApplicationError.WrongPassword);
        }

        var principal = AuthenticatedUser.builder().userId(user.getId()).email(email)./*userType(user.getType()).*/build();
        var authorities = new HashSet<GrantedAuthority>();
        userService.collectAuthorities(user, authorities);
        return new UsernamePasswordAuthenticationToken(principal, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
