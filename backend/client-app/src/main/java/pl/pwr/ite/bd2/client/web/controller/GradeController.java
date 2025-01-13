package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.GradeDto;
import pl.pwr.ite.bd2.client.web.service.GradeFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.GradeFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

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
        defaultListProperties = mappingService.createProperties(GradeDto.Properties.class)
                .setIncludeSchoolSubject(true)
                .setIncludeTeacher(true)
                .setIncludeStudent(true);
        defaultSingleProperties = mappingService.createProperties(GradeDto.Properties.class)
                .setIncludeSchoolSubject(true)
                .setIncludeTeacher(true)
                .setIncludeStudent(true);
    }

    @GetMapping
    public ResponseEntity<Collection<GradeDto>> getAll(GradeFilter filter) {
        return ResponseEntity.ok(gradeFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(gradeFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<GradeDto> create(@RequestBody GradeDto dto) {
        var grade = gradeFacade.create(dto);
        return ResponseEntity.ok(gradeFacade.map(grade, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeDto> update(@PathVariable UUID id, @RequestBody GradeDto dto) {
        var grade = gradeFacade.update(id, dto);
        return ResponseEntity.ok(gradeFacade.map(grade, defaultSingleProperties));
    }
}
