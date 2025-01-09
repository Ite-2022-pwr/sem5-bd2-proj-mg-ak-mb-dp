package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.GradeDto;
import pl.pwr.ite.bd2.client.web.service.GradeFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.service.MappingService;

@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController implements InitializingBean {

    private final GradeFacade gradeFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultListProperties = mappingService.createProperties(GradeDto.Properties.class);
        defaultSingleProperties = mappingService.createProperties(GradeDto.Properties.class);
    }
}
