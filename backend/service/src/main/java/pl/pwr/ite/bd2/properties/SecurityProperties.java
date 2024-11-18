package pl.pwr.ite.bd2.properties;

import lombok.Data;
import org.springframework.web.cors.CorsConfiguration;

@Data
public class SecurityProperties {

    private CorsConfiguration cors;
}
