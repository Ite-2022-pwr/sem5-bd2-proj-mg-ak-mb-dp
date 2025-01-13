package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.PostCodeDto;
import pl.pwr.ite.bd2.client.web.service.MessageFacade;
import pl.pwr.ite.bd2.client.web.service.PhoneNumberFacade;
import pl.pwr.ite.bd2.client.web.service.PostCodeFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.PostCodeFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/postcode")
@RequiredArgsConstructor
public class PostCodeController implements InitializingBean {

    private final PostCodeFacade postCodeFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;


    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(PostCodeDto.Properties.class);
        defaultListProperties = mappingService.createProperties(PostCodeDto.Properties.class);
    }

    @GetMapping
    public ResponseEntity<Collection<PostCodeDto>> getAll(PostCodeFilter filter) {
        return ResponseEntity.ok(postCodeFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCodeDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(postCodeFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<PostCodeDto> create(@RequestBody PostCodeDto dto) {
        var postCode = postCodeFacade.create(dto);
        return ResponseEntity.ok(postCodeFacade.map(postCode, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostCodeDto> update(@PathVariable UUID id, @RequestBody PostCodeDto dto) {
        var postCode = postCodeFacade.update(id, dto);
        return ResponseEntity.ok(postCodeFacade.map(postCode, defaultSingleProperties));
    }
}
