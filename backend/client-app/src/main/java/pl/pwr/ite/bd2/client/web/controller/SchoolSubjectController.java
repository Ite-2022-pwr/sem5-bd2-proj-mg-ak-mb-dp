package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.SchoolSubjectDto;
import pl.pwr.ite.bd2.client.web.service.SchoolSubjectFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.SchoolSubjectFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("school-subject")
@RequiredArgsConstructor
public class SchoolSubjectController implements InitializingBean {

    private final SchoolSubjectFacade schoolSubjectFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(SchoolSubjectDto.Properties.class);
        defaultListProperties = mappingService.createProperties(SchoolSubjectDto.Properties.class);
    }

    @GetMapping
    public ResponseEntity<Collection<SchoolSubjectDto>> getAll(SchoolSubjectFilter filter) {
        return ResponseEntity.ok(schoolSubjectFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolSubjectDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(schoolSubjectFacade.getById(id, defaultSingleProperties));
    }
}
