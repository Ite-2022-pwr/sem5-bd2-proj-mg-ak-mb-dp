package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.LessonDto;
import pl.pwr.ite.bd2.client.web.mapper.LessonMapper;
import pl.pwr.ite.bd2.model.entity.Lesson;
import pl.pwr.ite.bd2.model.filter.LessonFilter;
import pl.pwr.ite.bd2.service.LessonService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class LessonFacade extends EntityServiceFacade<Lesson, LessonFilter, LessonService, LessonDto, LessonDto.Properties, LessonMapper> {
    public LessonFacade(LessonService service, LessonMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
