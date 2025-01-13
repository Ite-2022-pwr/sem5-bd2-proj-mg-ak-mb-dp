package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.StudentDto;
import pl.pwr.ite.bd2.client.web.mapper.StudentMapper;
import pl.pwr.ite.bd2.model.entity.Student;
import pl.pwr.ite.bd2.model.filter.StudentFilter;
import pl.pwr.ite.bd2.service.SchoolClassService;
import pl.pwr.ite.bd2.service.StudentService;
import pl.pwr.ite.bd2.service.UserService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class StudentFacade extends EntityServiceFacade<Student, StudentFilter, StudentService, StudentDto, StudentDto.Properties, StudentMapper> {

    private final UserService userService;
    private final SchoolClassService schoolClassService;

    public StudentFacade(StudentService service, StudentMapper mapper, SecurityFacade securityFacade, UserService userService, SchoolClassService schoolClassService) {
        super(service, mapper, securityFacade);
        this.userService = userService;
        this.schoolClassService = schoolClassService;
    }

    @Transactional
    public Student create(StudentDto dto) {
        Student student = new Student();
        return saveAndFlush(setValues(student, dto));
    }

    @Transactional
    public Student update(UUID id, StudentDto dto) {
        var student = getById(id);
        if (student == null) {
            throw new ApplicationException(ApplicationError.StudentNotFound);
        }
        return saveAndFlush(setValues(student, dto));
    }

    private Student setValues(Student student, StudentDto dto) {
        student.setAge(dto.getAge());
        student.setGender(dto.getGender());
        student.setDateOfBirth(dto.getDateOfBirth());

        var user = userService.findById(dto.getUser().getId());
        if (user == null) {
            throw new ApplicationException(ApplicationError.UserNotFound);
        }
        student.setUser(user);

        var schoolClass = schoolClassService.findById(dto.getStudentClass().getId());
        if (schoolClass == null) {
            throw new ApplicationException(ApplicationError.SchoolClassNotFound);
        }
        student.setStudentClass(schoolClass);

        return student;
    }
}
