package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        defaultSingleProperties = mappingService.createProperties(AddressDto.Properties.class);
        defaultListProperties = mappingService.createProperties(AddressDto.Properties.class);
    }

    @GetMapping
    public ResponseEntity<Collection<AddressDto>> getAll(AddressFilter filter) {
        return ResponseEntity.ok(addressFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(addressFacade.getById(id, defaultSingleProperties));
    }
}
