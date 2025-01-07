package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PresenceDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Presence;

@Component
@RequiredArgsConstructor
public class PresenceMapper extends MapperBase<Presence, PresenceDto, PresenceDto.Properties> {

    private final StudentMapper studentMapper;
    private final LessonMapper lessonMapper;

    @Override
    public void transform(Presence source, PresenceDto destination, PresenceDto.Properties properties) {
        destination.setId(source.getId());
        destination.setType(source.getType());

        if (properties.isIncludeStudent()) {
            map(destination::setStudent, source.getStudent(), studentMapper, properties);
        }

        if (properties.isIncludeLesson()) {
            map(destination::setLesson, source.getLesson(), lessonMapper, properties);
        }
    }
}
