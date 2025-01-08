package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.SchoolClassDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.SchoolClass;

@Component
@RequiredArgsConstructor
public class SchoolClassMapper extends MapperBase<SchoolClass, SchoolClassDto, SchoolClassDto.Properties> {

    @Override
    public void transform(SchoolClass source, SchoolClassDto destination, SchoolClassDto.Properties properties) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setYearOfStudy(source.getYearOfStudy());
        destination.setYearStarted(source.getYearStarted());
    }
}
