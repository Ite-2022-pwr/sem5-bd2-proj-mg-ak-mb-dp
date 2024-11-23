package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.enums.UserType;

import java.util.UUID;

@Data
public class UserDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {

    }

    private UUID id;

    private UserType userType;

    private String email;
}
