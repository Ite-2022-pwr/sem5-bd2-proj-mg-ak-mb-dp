package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.util.UUID;

@Data
public class PostCodeDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {

    }

    private UUID id;

    private String postCode;

    private String regionName;
}
