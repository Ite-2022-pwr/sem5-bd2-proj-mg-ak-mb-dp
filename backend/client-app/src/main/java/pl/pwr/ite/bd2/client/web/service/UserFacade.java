package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.CredentialsDto;
import pl.pwr.ite.bd2.client.web.dto.JwtDto;
import pl.pwr.ite.bd2.client.web.dto.UserDto;
import pl.pwr.ite.bd2.client.web.mapper.UserMapper;
import pl.pwr.ite.bd2.model.entity.User;
import pl.pwr.ite.bd2.model.filter.UserFilter;
import pl.pwr.ite.bd2.security.AuthenticatedUser;
import pl.pwr.ite.bd2.service.JwtService;
import pl.pwr.ite.bd2.service.UserService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class UserFacade extends EntityServiceFacade<User, UserFilter, UserService, UserDto, UserDto.Properties, UserMapper> {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserFacade(UserService service, UserMapper mapper, SecurityFacade securityFacade, JwtService jwtService, AuthenticationManager authenticationManager) {
        super(service, mapper, securityFacade);
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public JwtDto authenticate(CredentialsDto dto) {
        try {
            var token = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
            var auth = (UsernamePasswordAuthenticationToken) authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);

            var accessToken = jwtService.generateToken((AuthenticatedUser) auth.getPrincipal());
            var jwtDto = new JwtDto();
            jwtDto.setToken(accessToken);
            jwtDto.setExpiresIn(jwtService.getExpirationTime());
            return jwtDto;
        } catch (AuthenticationException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
