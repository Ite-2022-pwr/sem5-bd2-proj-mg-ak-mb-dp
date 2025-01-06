package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SchoolSubjectDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {

    }

    private UUID id;

    private String name;

    private LocalDateTime schoolYear;

    private String linkToSubjectProgram;

}
