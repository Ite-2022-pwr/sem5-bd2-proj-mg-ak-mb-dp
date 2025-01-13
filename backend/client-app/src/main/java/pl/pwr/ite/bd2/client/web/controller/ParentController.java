package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.ParentDto;
import pl.pwr.ite.bd2.client.web.service.ParentFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.ParentFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController implements InitializingBean {

    private final ParentFacade parentFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(ParentDto.Properties.class)
                .setIncludeUser(true);
        defaultListProperties = mappingService.createProperties(ParentDto.Properties.class)
                .setIncludeUser(true);
    }

    @GetMapping
    public ResponseEntity<Collection<ParentDto>> getAll(ParentFilter filter) {
        return ResponseEntity.ok(parentFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(parentFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<ParentDto> create(@RequestBody ParentDto dto) {
        var parent = parentFacade.create(dto);
        return ResponseEntity.ok(parentFacade.map(parent, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentDto> update(@PathVariable UUID id, @RequestBody ParentDto dto) {
        var parent = parentFacade.update(id, dto);
        return ResponseEntity.ok(parentFacade.map(parent, defaultSingleProperties));
    }
}
