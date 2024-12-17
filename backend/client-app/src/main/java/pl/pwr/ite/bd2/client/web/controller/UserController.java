package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.bd2.client.web.dto.UserDto;
import pl.pwr.ite.bd2.client.web.service.UserFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.UserFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController implements InitializingBean {

    private final MappingService mappingService;
    private final UserFacade userFacade;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;
    private MappingProperties authenticatedProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(UserDto.Properties.class);
        defaultListProperties = mappingService.createProperties(UserDto.Properties.class);
        authenticatedProperties = mappingService.createProperties(UserDto.Properties.class);
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> getAll(UserFilter filter) {
        return ResponseEntity.ok(userFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(userFacade.getById(id, defaultSingleProperties));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable UUID id, @RequestBody UserDto dto) {
        return ResponseEntity.ok(userFacade.map(userFacade.update(id, dto), defaultSingleProperties));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getAuthenticated() {
        return ResponseEntity.ok(userFacade.map(userFacade.getAuthenticatedUser(), authenticatedProperties));
    }
}
