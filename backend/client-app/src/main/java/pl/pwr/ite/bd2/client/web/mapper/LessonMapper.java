package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.LessonDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class LessonMapper extends MapperBase<Lesson, LessonDto, LessonDto.Properties> {

    //    private final NestedLessonMapper nestedLessonMapper;

    private String topic;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeEnd;
    private SchoolClass studentClass;
    private Teacher teacher;
    private Set<Presence> presences = new HashSet<>();
    private SchoolSubject schoolSubject;
    public void transform(Lesson source, LessonDto destination, LessonDto.Properties properties) {
//        destination.setStreet(source.getStreet());
    }
}
