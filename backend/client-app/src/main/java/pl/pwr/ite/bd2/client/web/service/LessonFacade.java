package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.LessonDto;
import pl.pwr.ite.bd2.client.web.mapper.LessonMapper;
import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.filter.LessonFilter;
import pl.pwr.ite.bd2.service.LessonService;
import pl.pwr.ite.bd2.service.SchoolClassService;
import pl.pwr.ite.bd2.service.SchoolSubjectService;
import pl.pwr.ite.bd2.service.TeacherService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class LessonFacade extends EntityServiceFacade<Lesson, LessonFilter, LessonService, LessonDto, LessonDto.Properties, LessonMapper> {

    // @RequiredArgsConstructor tu nie zadziała, trzeba zrobić constructor injection
    private final SchoolClassService schoolClassService;
    private final TeacherService teacherService;
    private final SchoolSubjectService schoolSubjectService;

    public LessonFacade(LessonService service, LessonMapper mapper, SecurityFacade securityFacade, SchoolClassService schoolClassService, TeacherService teacherService, SchoolSubjectService schoolSubjectService) {
        super(service, mapper, securityFacade);
        this.schoolClassService = schoolClassService;
        this.teacherService = teacherService;
        this.schoolSubjectService = schoolSubjectService;
    }

    /*
    jeśli jakikolwiek exception wyleci w metodzie oznaczonej @Transactional to operacje w bazie
    wykonane w tej metodzie zostaną cofnięte
    */
    @Transactional
    public Lesson create(LessonDto dto) {
        var lesson = new Lesson();
        return saveAndFlush(setValues(lesson, dto));
    }

    @Transactional
    public Lesson update(UUID id, LessonDto dto) {
        var lesson = getById(id);
        if(lesson == null) {
            throw new ApplicationException(ApplicationError.LessonNotFound);
        }
        return saveAndFlush(setValues(lesson, dto));
    }

    private Lesson setValues(Lesson lesson, LessonDto dto) {
        // zwykłe wartosci przepisujemy z dto do encji
        lesson.setTopic(dto.getTopic());
        lesson.setDateTimeStart(dto.getDateTimeStart());
        lesson.setDateTimeEnd(dto.getDateTimeEnd());
        // jeśli mamy zależność do innej encji to injectujemy serwis, wyszukujemy po id z zagnieżdżonego dto i
        // sprawdzamy czy istnieje, jeśli nie to wyrzucamy ApplicationException z odpowiednim ApplicationError(w razie
        // potrzeby dodać do enuma nową wartość
        var studentClass = schoolClassService.findById(dto.getStudentClass().getId());
        if(studentClass == null) {
            throw new ApplicationException(ApplicationError.SchoolClassNotFound);
        }
        lesson.setStudentClass(studentClass);

        var teacher = teacherService.findById(dto.getTeacher().getId());
        if(teacher == null) {
            throw new ApplicationException(ApplicationError.TeacherNotFound);
        }
        lesson.setTeacher(teacher);

        var subject = schoolSubjectService.findById(dto.getSchoolSubject().getId());
        if(subject == null) {
            throw new ApplicationException(ApplicationError.SchoolSubjectNotFound);
        }
        lesson.setSchoolSubject(subject);

        return lesson;
    }
}
