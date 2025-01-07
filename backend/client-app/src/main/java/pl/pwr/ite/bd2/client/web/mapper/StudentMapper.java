package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.StudentDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Student;

@Component
@RequiredArgsConstructor
public class StudentMapper extends MapperBase<Student, StudentDto, StudentDto.Properties> {

    private final UserMapper userMapper;
    private final SchoolClassMapper schoolClassMapper;

    @Override
    public void transform(Student source, StudentDto destination, StudentDto.Properties properties) {
        destination.setId(source.getId());
        destination.setDateOfBirth(source.getDateOfBirth());
        destination.setAge(source.getAge());
        destination.setGender(source.getGender());

        if (properties.isIncludeUser()) {
            map(destination::setUser, source.getUser(), userMapper, properties);
        }

        if (properties.isIncludeStudentClass()) {
            map(destination::setStudentClass, source.getStudentClass(), schoolClassMapper, properties);
        }
    }
}
