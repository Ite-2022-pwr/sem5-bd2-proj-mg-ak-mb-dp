package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class GradeDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeStudent;
        private boolean includeSchoolSubject;
        private boolean includeTeacher;
    }

    private UUID id;

    private Integer numberGrade;

    private String description;

    private LocalDateTime date;

    private Integer weight;

    private StudentDto student;

    private SchoolSubjectDto schoolSubject;

    private TeacherDto teacher;

}
