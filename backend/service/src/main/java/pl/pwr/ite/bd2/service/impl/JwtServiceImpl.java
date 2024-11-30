package pl.pwr.ite.bd2.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.properties.AuthProperties;
import pl.pwr.ite.bd2.security.AuthenticatedUser;
import pl.pwr.ite.bd2.security.JwtGrantedAuthorityConverter;
import pl.pwr.ite.bd2.service.ClockService;
import pl.pwr.ite.bd2.service.JwtService;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService, InitializingBean {

    private final JwtGrantedAuthorityConverter authorityConverter;
    private final AuthProperties authProperties;
    private final long accessTokenValidityTime = 3 * 24 * 60 * 60 * 1000;
//    private final long accessTokenValidityTime = 1 * 1 * 1 * 30 * 1000;

    private final ClockService clockService;

    @Override
    public void afterPropertiesSet() throws Exception {
    }


    public String createToken(AuthenticatedUser authenticatedUser, long expiration) {
        var claims = Jwts.claims().setSubject(authenticatedUser.getUsername());
        claims.put("email", authenticatedUser.getEmail());
        claims.put("uid", authenticatedUser.getUserId());
//        claims.put("userType", authenticatedUser.getUserType());

//        Collection<String> authorities = authenticatedUser.getAuthorities()
//                        .stream().map(authorityConverter::toClaim).toList();
//        claims.put("authorities", authorities);
        var tokenCreateDate = new Date(System.currentTimeMillis());
        var tokenExpireDate = new Date(tokenCreateDate.getTime() + expiration);
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(authenticatedUser.getEmail())
                .setIssuedAt(tokenCreateDate)
                .setExpiration(tokenExpireDate)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    @Override
    public String generateToken(AuthenticatedUser authenticatedUser) {
        return createToken(authenticatedUser, accessTokenValidityTime);
    }

    @Override
    public boolean isTokenValid(String token, AuthenticatedUser authenticatedUser) {
        final String username = extractUsername(token);
        return (username.equals(authenticatedUser.getEmail())) && !isTokenExpired(token);
    }

    @Override
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(clockService.getCurrentDate());
    }

    @Override
    public long getExpirationTime() {
        return accessTokenValidityTime;
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        var claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    private Key getSignInKey() {
        var keyBytes = Decoders.BASE64.decode(authProperties.getJwtSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
