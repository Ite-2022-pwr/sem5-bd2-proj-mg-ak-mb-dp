package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;

@Data
public class JwtDto {

    private String token;

    private Long expiresIn;
}
