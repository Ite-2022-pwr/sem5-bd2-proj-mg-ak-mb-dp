package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.enums.PresenceType;

import java.util.UUID;

@Data
public class PresenceDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeStudent;
        private boolean includeLesson;
    }

    private UUID id;

    private PresenceType type;

    private StudentDto student;

    private LessonDto lesson;
}
