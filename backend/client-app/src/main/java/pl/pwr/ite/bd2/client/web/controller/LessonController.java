package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.UserDto;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.service.MappingService;
import pl.pwr.ite.bd2.client.web.service.LessonFacade;

@RestController
@RequestMapping("/Lesson")
@RequiredArgsConstructor
public class LessonController implements InitializingBean {
    private final LessonFacade LessonFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(UserDto.Properties.class)
                .setIncludeNestedLesson(true); // zagnieżdżona encja zostanie zmapowana
        defaultListProperties = mappingService.createProperties(UserDto.Properties.class)
                .setIncludeNestedLesson(false); // zagnieżdżona encja nie zostanie zmapowana
    }
}