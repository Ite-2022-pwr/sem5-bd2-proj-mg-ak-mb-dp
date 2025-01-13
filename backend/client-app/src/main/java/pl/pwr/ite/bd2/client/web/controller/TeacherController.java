package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.TeacherDto;
import pl.pwr.ite.bd2.client.web.service.TeacherFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.TeacherFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController implements InitializingBean {

    private final TeacherFacade teacherFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(TeacherDto.Properties.class)
                .setIncludeUser(true);
        defaultListProperties = mappingService.createProperties(TeacherDto.Properties.class)
                .setIncludeUser(true);
    }

    @GetMapping
    public ResponseEntity<Collection<TeacherDto>> getAll(TeacherFilter filter) {
        return ResponseEntity.ok(teacherFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(teacherFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<TeacherDto> create(@RequestBody TeacherDto dto) {
        var teacher = teacherFacade.create(dto);
        return ResponseEntity.ok(teacherFacade.map(teacher, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDto> update(@PathVariable UUID id, @RequestBody TeacherDto dto) {
        var teacher = teacherFacade.update(id, dto);
        return ResponseEntity.ok(teacherFacade.map(teacher, defaultSingleProperties));
    }
}
