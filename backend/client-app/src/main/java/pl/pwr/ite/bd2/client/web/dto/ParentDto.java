package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.enums.ParentRole;

import java.util.UUID;

@Data
public class ParentDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeUser;
    }

    private UUID id;

    private UserDto user;

    private ParentRole parentRole;
}
