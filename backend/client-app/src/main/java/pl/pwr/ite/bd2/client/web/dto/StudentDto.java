package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.enums.Gender;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class StudentDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeUser;
        private boolean includeStudentClass;
    }

    private UUID id;

    private UserDto user;

    private LocalDateTime dateOfBirth;

    private Integer age;

    private Gender gender;

    private SchoolClassDto studentClass;
}
