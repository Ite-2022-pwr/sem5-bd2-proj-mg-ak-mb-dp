package pl.pwr.ite.bd2.client.web.mapper;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.GradeDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Grade;

@Component
public class GradeMapper extends MapperBase<Grade, GradeDto, GradeDto.Properties> {


    @Override
    public void transform(Grade source, GradeDto destination, GradeDto.Properties properties) {
        destination.setNumberGrade(source.getNumberGrade());
        destination.setDescription(source.getDescription());
        destination.setDate(source.getDate());
        destination.setWeight(source.getWeight());
    }
}
