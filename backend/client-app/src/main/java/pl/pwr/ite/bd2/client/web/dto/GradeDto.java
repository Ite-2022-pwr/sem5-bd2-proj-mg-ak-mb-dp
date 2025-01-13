package pl.pwr.ite.bd2.client.web.dto;

import jakarta.persistence.Access;
import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.time.LocalDateTime;

@Data
public class GradeDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeStudent;
        private boolean includeTeacher;
        private boolean includeSchoolSubject;
    }

    private Integer numberGrade;

    private String description;

    private LocalDateTime date;

    private Integer weight;

    private StudentDto student;

    private SchoolSubjectDto schoolSubject;

    private TeacherDto teacher;
}
