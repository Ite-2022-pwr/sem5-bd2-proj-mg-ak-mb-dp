package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.TeacherDto;
import pl.pwr.ite.bd2.client.web.mapper.TeacherMapper;
import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.model.filter.TeacherFilter;
import pl.pwr.ite.bd2.service.TeacherService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class TeacherFacade extends EntityServiceFacade<Teacher, TeacherFilter, TeacherService, TeacherDto, TeacherDto.Properties, TeacherMapper> {
    public TeacherFacade(TeacherService service, TeacherMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
