package pl.pwr.ite.bd2.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import pl.pwr.ite.bd2.properties.ServiceProperties;

@ConfigurationProperties("rajdownik")
@Data
public class ClientProperties extends ServiceProperties {
}
