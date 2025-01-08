package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.SchoolClassDto;
import pl.pwr.ite.bd2.client.web.service.SchoolClassFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.SchoolClassFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/school-class")
@RequiredArgsConstructor
public class SchoolClassController implements InitializingBean {

    private final SchoolClassFacade schoolClassFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(SchoolClassDto.Properties.class);
        defaultListProperties = mappingService.createProperties(SchoolClassDto.Properties.class);
    }

    @GetMapping
    public ResponseEntity<Collection<SchoolClassDto>> getAll(SchoolClassFilter filter) {
        return ResponseEntity.ok(schoolClassFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClassDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(schoolClassFacade.getById(id, defaultSingleProperties));
    }
}
