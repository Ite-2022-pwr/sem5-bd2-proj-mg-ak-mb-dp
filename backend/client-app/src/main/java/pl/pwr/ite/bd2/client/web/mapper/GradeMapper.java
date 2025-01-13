package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.GradeDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Grade;

@Component
@RequiredArgsConstructor
public class GradeMapper extends MapperBase<Grade, GradeDto, GradeDto.Properties> {

    private final StudentMapper studentMapper;
    private final SchoolSubjectMapper schoolSubjectMapper;
    private final TeacherMapper teacherMapper;

    @Override
    public void transform(Grade source, GradeDto destination, GradeDto.Properties properties) {
        destination.setNumberGrade(source.getNumberGrade());
        destination.setDescription(source.getDescription());
        destination.setDate(source.getDate());
        destination.setWeight(source.getWeight());

        if (properties.isIncludeSchoolSubject()) {
            map(destination::setSchoolSubject, source.getSchoolSubject(), schoolSubjectMapper, properties);
        }

        if (properties.isIncludeTeacher()) {
            map(destination::setTeacher, source.getTeacher(), teacherMapper, properties);
        }

        if (properties.isIncludeStudent()) {
            map(destination::setStudent, source.getStudent(), studentMapper, properties);
        }
    }
}
