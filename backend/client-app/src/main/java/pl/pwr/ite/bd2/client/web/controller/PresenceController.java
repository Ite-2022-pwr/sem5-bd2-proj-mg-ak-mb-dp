package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.PresenceDto;
import pl.pwr.ite.bd2.client.web.service.PresenceFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.PresenceFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/presence")
@RequiredArgsConstructor
public class PresenceController implements InitializingBean {

    private final PresenceFacade presenceFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(PresenceDto.Properties.class)
                .setIncludeLesson(true)
                .setIncludeStudent(true);
        defaultListProperties = mappingService.createProperties(PresenceDto.Properties.class)
                .setIncludeLesson(true)
                .setIncludeStudent(true);
    }

    @GetMapping
    public ResponseEntity<Collection<PresenceDto>> getAll(PresenceFilter filter) {
        return ResponseEntity.ok(presenceFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenceDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(presenceFacade.getById(id, defaultSingleProperties));
    }
}
