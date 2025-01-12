package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.LessonDto;
import pl.pwr.ite.bd2.client.web.dto.SchoolClassDto;
import pl.pwr.ite.bd2.client.web.service.LessonFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.LessonFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController implements InitializingBean {

    private final LessonFacade lessonFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(LessonDto.Properties.class)
                .setIncludeSchoolSubject(true)
                .setIncludeTeacher(true)
                .setIncludeStudentClass(true);
        defaultListProperties = mappingService.createProperties(LessonDto.Properties.class)
                .setIncludeSchoolSubject(true)
                .setIncludeTeacher(true)
                .setIncludeStudentClass(true);
    }

    @GetMapping
    public ResponseEntity<Collection<LessonDto>> getAll(LessonFilter filter) {
        return ResponseEntity.ok(lessonFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(lessonFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<LessonDto> create(@RequestBody LessonDto dto) {
        var lesson = lessonFacade.create(dto);
        return ResponseEntity.ok(lessonFacade.map(lesson, defaultSingleProperties));
    }

    @PutMapping("/{id}") // zmienna oznaczona @PathVariable musi mieć dokładnie taką samą nazwę jak w stringu w @PutMapping
    public ResponseEntity<LessonDto> update(@PathVariable UUID id, @RequestBody LessonDto dto) {
        var lesson = lessonFacade.update(id, dto);
        return ResponseEntity.ok(lessonFacade.map(lesson, defaultSingleProperties));
    }
}
