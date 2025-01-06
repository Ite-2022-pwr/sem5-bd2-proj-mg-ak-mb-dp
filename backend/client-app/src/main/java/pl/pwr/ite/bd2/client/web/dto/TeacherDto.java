package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class TeacherDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeUser;
    }

    private UUID id;

    private LocalDate lastCOCRDate;

    private Boolean oneLeave;

    private UserDto user;
}
