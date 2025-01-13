package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.GradeDto;
import pl.pwr.ite.bd2.client.web.mapper.GradeMapper;
import pl.pwr.ite.bd2.model.entity.Grade;
import pl.pwr.ite.bd2.model.filter.GradeFilter;
import pl.pwr.ite.bd2.service.GradeService;
import pl.pwr.ite.bd2.service.SchoolSubjectService;
import pl.pwr.ite.bd2.service.StudentService;
import pl.pwr.ite.bd2.service.TeacherService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class GradeFacade extends EntityServiceFacade<Grade, GradeFilter, GradeService, GradeDto, GradeDto.Properties, GradeMapper> {

    private final StudentService studentService;
    private final SchoolSubjectService subjectService;
    private final TeacherService teacherService;

    public GradeFacade(GradeService service, GradeMapper mapper, SecurityFacade securityFacade, StudentService studentService, SchoolSubjectService subjectService, TeacherService teacherService) {
        super(service, mapper, securityFacade);
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    @Transactional
    public Grade create(GradeDto dto) {
        var grade = new Grade();
        return saveAndFlush(setValues(grade, dto));
    }

    @Transactional
    public Grade update(UUID id, GradeDto dto) {
        var grade = getById(id);
        if (grade == null) {
            throw new ApplicationException(ApplicationError.GradeNotFound);
        }
        return saveAndFlush(setValues(grade, dto));
    }

    private Grade setValues(Grade grade, GradeDto dto) {
        grade.setNumberGrade(dto.getNumberGrade());
        grade.setDate(dto.getDate());
        grade.setDescription(dto.getDescription());
        grade.setWeight(dto.getWeight());

        var student = studentService.findById(dto.getStudent().getId());
        if (student == null) {
            throw new ApplicationException(ApplicationError.StudentNotFound);
        }
        grade.setStudent(student);

        var teacher = teacherService.findById(dto.getTeacher().getId());
        if (teacher == null) {
            throw new ApplicationException(ApplicationError.TeacherNotFound);
        }
        grade.setTeacher(teacher);

        var schoolSubject = subjectService.findById(dto.getSchoolSubject().getId());
        if (schoolSubject == null) {
            throw new ApplicationException(ApplicationError.SchoolSubjectNotFound);
        }
        grade.setSchoolSubject(schoolSubject);

        return grade;
    }
}
