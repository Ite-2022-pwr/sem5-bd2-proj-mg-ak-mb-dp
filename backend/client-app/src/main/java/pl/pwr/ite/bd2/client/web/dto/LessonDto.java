package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class LessonDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeStudentClass;
        private boolean includeTeacher;
        private boolean includeSchoolSubject;
    }

    private UUID id;

    private String topic;

    private LocalDateTime dateTimeStart;

    private LocalDateTime dateTimeEnd;

    private SchoolClassDto studentClass;

    private TeacherDto teacher;

    private SchoolSubjectDto schoolSubject;
}
