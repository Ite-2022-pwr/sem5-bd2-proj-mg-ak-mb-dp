package pl.pwr.ite.bd2.properties;

import lombok.Data;

@Data
public class AuthProperties {

    private String jwtSecret;

    private JwkProperties jwk;

    private AuthProviderProperties provider;
}
