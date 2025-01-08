package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.util.UUID;

@Data
public class AddressDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includePostCode;
    }

    private UUID id;

    private PostCodeDto postCode;

    private String street;

    private String buildingNumber;

    private String apartmentNumber;
}
