package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ResponseEntity<SchoolClassDto> create(@RequestBody SchoolClassDto dto) {
        var schoolClass = schoolClassFacade.create(dto);
        return ResponseEntity.ok(schoolClassFacade.map(schoolClass, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolClassDto> update(@PathVariable UUID id, @RequestBody SchoolClassDto dto) {
        var schoolClass = schoolClassFacade.update(id, dto);
        return ResponseEntity.ok(schoolClassFacade.map(schoolClass, defaultSingleProperties));
    }
}
