package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.AddressDto;
import pl.pwr.ite.bd2.client.web.service.AddressFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.AddressFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController implements InitializingBean {

    private final AddressFacade addressFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(AddressDto.Properties.class)
                .setIncludePostCode(true);
        defaultListProperties = mappingService.createProperties(AddressDto.Properties.class)
                .setIncludePostCode(true);
    }

    @GetMapping
    public ResponseEntity<Collection<AddressDto>> getAll(AddressFilter filter) {
        return ResponseEntity.ok(addressFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(addressFacade.getById(id, defaultSingleProperties));
    }

    @PostMapping
    public ResponseEntity<AddressDto> create(@RequestBody AddressDto dto) {
        var address = addressFacade.create(dto);
        return ResponseEntity.ok(addressFacade.map(address, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> update(@PathVariable UUID id, @RequestBody AddressDto dto) {
        var address = addressFacade.update(id, dto);
        return ResponseEntity.ok(addressFacade.map(address, defaultSingleProperties));
    }
}
