package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.TeacherDto;
import pl.pwr.ite.bd2.client.web.mapper.TeacherMapper;
import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.model.filter.TeacherFilter;
import pl.pwr.ite.bd2.service.TeacherService;
import pl.pwr.ite.bd2.service.UserService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class TeacherFacade extends EntityServiceFacade<Teacher, TeacherFilter, TeacherService, TeacherDto, TeacherDto.Properties, TeacherMapper> {

    private final UserService userService;

    public TeacherFacade(TeacherService service, TeacherMapper mapper, SecurityFacade securityFacade, UserService userService) {
        super(service, mapper, securityFacade);
        this.userService = userService;
    }

    @Transactional
    public Teacher create(TeacherDto dto) {
        var teacher = new Teacher();
        return saveAndFlush(setValues(teacher, dto));
    }

    @Transactional
    public Teacher update(UUID id, TeacherDto dto) {
        var teacher = getById(id);
        if (teacher == null) {
            throw new ApplicationException(ApplicationError.TeacherNotFound);
        }
        return saveAndFlush(setValues(teacher, dto));
    }

    private Teacher setValues(Teacher teacher, TeacherDto dto) {
        teacher.setLastCOCRDate(dto.getLastCOCRDate());
        teacher.setOneLeave(dto.getOneLeave());

        var user = userService.findById(dto.getUser().getId());
        if (user == null) {
            throw new ApplicationException(ApplicationError.UserNotFound);
        }
        teacher.setUser(user);

        return teacher;
    }
}
