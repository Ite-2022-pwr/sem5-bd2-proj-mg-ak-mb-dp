package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.TeacherDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Teacher;

@Component
@RequiredArgsConstructor
public class TeacherMapper extends MapperBase<Teacher, TeacherDto, TeacherDto.Properties> {

    private final UserMapper userMapper;

    @Override
    public void transform(Teacher source, TeacherDto destination, TeacherDto.Properties properties) {
        destination.setId(source.getId());
        destination.setLastCOCRDate(source.getLastCOCRDate());
        destination.setOneLeave(source.getOneLeave());

        if (properties.isIncludeUser()) {
            map(destination::setUser, source.getUser(), userMapper, properties);
        }
    }
}
