package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PresenceDto;
import pl.pwr.ite.bd2.client.web.mapper.PresenceMapper;
import pl.pwr.ite.bd2.model.entity.Presence;
import pl.pwr.ite.bd2.model.filter.PresenceFilter;
import pl.pwr.ite.bd2.service.LessonService;
import pl.pwr.ite.bd2.service.PresenceService;
import pl.pwr.ite.bd2.service.StudentService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class PresenceFacade extends EntityServiceFacade<Presence, PresenceFilter, PresenceService, PresenceDto, PresenceDto.Properties, PresenceMapper> {

    private final StudentService studentService;
    private final LessonService lessonService;

    public PresenceFacade(PresenceService service, PresenceMapper mapper, SecurityFacade securityFacade, StudentService studentService, LessonService lessonService) {
        super(service, mapper, securityFacade);
        this.studentService = studentService;
        this.lessonService = lessonService;
    }

    @Transactional
    public Presence create(PresenceDto dto) {
        var presence = new Presence();
        return saveAndFlush(setValues(presence, dto));
    }

    @Transactional
    public Presence update(UUID id, PresenceDto dto) {
        var presence = getById(id);
        if (presence == null) {
            throw new ApplicationException(ApplicationError.PresenceNotFound);
        }
        return saveAndFlush(setValues(presence, dto));
    }

    private Presence setValues(Presence presence, PresenceDto dto) {
        presence.setType(dto.getType());

        var student = studentService.findById(dto.getStudent().getId());
        if (student == null) {
            throw new ApplicationException(ApplicationError.StudentNotFound);
        }
        presence.setStudent(student);

        var lesson = lessonService.findById(dto.getLesson().getId());
        if (lesson == null) {
            throw new ApplicationException(ApplicationError.LessonNotFound);
        }
        presence.setLesson(lesson);

        return presence;
    }
}
