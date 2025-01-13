package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.StudentDto;
import pl.pwr.ite.bd2.client.web.service.StudentFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.StudentFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController implements InitializingBean {

    private final StudentFacade studentFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(StudentDto.Properties.class)
                .setIncludeStudentClass(true)
                .setIncludeUser(true);
        defaultListProperties = mappingService.createProperties(StudentDto.Properties.class)
                .setIncludeStudentClass(true)
                .setIncludeUser(true);
    }

    @GetMapping
    public ResponseEntity<Collection<StudentDto>> getAll(StudentFilter filter) {
        return ResponseEntity.ok(studentFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(studentFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto dto) {
        var student = studentFacade.create(dto);
        return ResponseEntity.ok(studentFacade.map(student, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable UUID id, @RequestBody StudentDto dto) {
        var student = studentFacade.update(id, dto);
        return ResponseEntity.ok(studentFacade.map(student, defaultSingleProperties));
    }
}
