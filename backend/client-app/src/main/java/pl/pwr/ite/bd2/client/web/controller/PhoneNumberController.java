package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.PhoneNumberDto;
import pl.pwr.ite.bd2.client.web.service.PhoneNumberFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.PhoneNumberFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/phone-number")
@RequiredArgsConstructor
public class PhoneNumberController implements InitializingBean {

    private final PhoneNumberFacade phoneNumberFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(PhoneNumberDto.Properties.class);
        defaultListProperties = mappingService.createProperties(PhoneNumberDto.Properties.class);
    }

    @GetMapping
    public ResponseEntity<Collection<PhoneNumberDto>> getAll(PhoneNumberFilter filter) {
        return ResponseEntity.ok(phoneNumberFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneNumberDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(phoneNumberFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<PhoneNumberDto> create(@RequestBody PhoneNumberDto dto) {
        var phoneNumber = phoneNumberFacade.create(dto);
        return ResponseEntity.ok(phoneNumberFacade.map(phoneNumber, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneNumberDto> update(@PathVariable UUID id, @RequestBody PhoneNumberDto dto) {
        var phoneNumber = phoneNumberFacade.update(id, dto);
        return ResponseEntity.ok(phoneNumberFacade.map(phoneNumber, defaultSingleProperties));
    }
}
