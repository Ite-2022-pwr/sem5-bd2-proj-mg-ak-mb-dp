package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;


@Data
public class AddressDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
    }
    // Dodaje sie tutaj te pola co są w encji "Example"
    private String street;
    private String buildingNumber;

    private String apartmentNumber;
}