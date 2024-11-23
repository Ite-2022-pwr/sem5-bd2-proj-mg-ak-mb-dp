package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.UserDto;
import pl.pwr.ite.bd2.client.web.service.UserFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.UserFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController implements InitializingBean {

    private final MappingService mappingService;
    private final UserFacade userFacade;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(UserDto.Properties.class);
        defaultListProperties = mappingService.createProperties(UserDto.Properties.class);
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> getAll(UserFilter filter) {
        return ResponseEntity.ok(userFacade.getList(filter, defaultListProperties));
    }
}
