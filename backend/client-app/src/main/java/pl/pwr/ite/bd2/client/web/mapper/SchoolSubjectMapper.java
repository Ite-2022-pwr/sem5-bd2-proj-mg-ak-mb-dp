package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.SchoolSubjectDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;

@Component
@RequiredArgsConstructor
public class SchoolSubjectMapper extends MapperBase<SchoolSubject, SchoolSubjectDto, SchoolSubjectDto.Properties> {
    @Override
    public void transform(SchoolSubject source, SchoolSubjectDto destination, SchoolSubjectDto.Properties properties) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setSchoolYear(source.getSchoolYear());
        destination.setLinkToSubjectProgram(source.getLinkToSubjectProgram());
    }
}
