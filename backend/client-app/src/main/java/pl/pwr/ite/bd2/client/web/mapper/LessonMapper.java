package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.LessonDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Lesson;

@Component
@RequiredArgsConstructor
public class LessonMapper extends MapperBase<Lesson, LessonDto, LessonDto.Properties> {

    private final SchoolClassMapper schoolClassMapper;
    private final TeacherMapper teacherMapper;
    private final SchoolSubjectMapper schoolSubjectMapper;

    @Override
    public void transform(Lesson source, LessonDto destination, LessonDto.Properties properties) {
        destination.setId(source.getId());
        destination.setTopic(source.getTopic());
        destination.setDateTimeStart(source.getDateTimeStart());
        destination.setDateTimeEnd(source.getDateTimeEnd());

        if (properties.isIncludeStudentClass()) {
            map(destination::setStudentClass, source.getStudentClass(), schoolClassMapper, properties);
        }

        if (properties.isIncludeTeacher()) {
            map(destination::setTeacher, source.getTeacher(), teacherMapper, properties);
        }

        if (properties.isIncludeSchoolSubject()) {
            map(destination::setSchoolSubject, source.getSchoolSubject(), schoolSubjectMapper, properties);
        }

    }
}
