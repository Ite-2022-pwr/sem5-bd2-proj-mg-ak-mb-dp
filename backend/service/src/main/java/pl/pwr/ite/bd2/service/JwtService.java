package pl.pwr.ite.bd2.service;

import pl.pwr.ite.bd2.security.AuthenticatedUser;

public interface JwtService {

    String extractUsername(String token);

    String generateToken(AuthenticatedUser authenticatedUser);

    boolean isTokenValid(String token, AuthenticatedUser authenticatedUser);

    boolean isTokenExpired(String token);

    long getExpirationTime();
}
