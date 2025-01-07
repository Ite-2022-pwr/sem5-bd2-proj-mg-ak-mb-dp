package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.StudentDto;
import pl.pwr.ite.bd2.client.web.mapper.StudentMapper;
import pl.pwr.ite.bd2.model.entity.Student;
import pl.pwr.ite.bd2.model.filter.StudentFilter;
import pl.pwr.ite.bd2.service.StudentService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class StudentFacade extends EntityServiceFacade<Student, StudentFilter, StudentService, StudentDto, StudentDto.Properties, StudentMapper> {
    public StudentFacade(StudentService service, StudentMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
