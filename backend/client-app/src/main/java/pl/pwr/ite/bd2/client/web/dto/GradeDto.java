package pl.pwr.ite.bd2.client.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.entity.Student;
import pl.pwr.ite.bd2.model.entity.Teacher;

import java.time.LocalDateTime;

@Data
public class GradeDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeNestedGrade;
    }

    private Integer numberGrade;
    private String description;
    private LocalDateTime date;
    private Integer weight;
    private Student student;
    private SchoolSubject schoolSubject;
    private Teacher teacher;
}