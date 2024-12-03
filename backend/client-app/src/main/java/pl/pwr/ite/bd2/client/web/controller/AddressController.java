package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.UserDto;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.service.MappingService;
import pl.pwr.ite.bd2.client.web.service.AddressFacade;

@RestController
@RequestMapping("/Address")
@RequiredArgsConstructor
public class AddressController implements InitializingBean {
    private final AddressFacade AddressFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(UserDto.Properties.class)
                .setIncludeNestedAddress(true); // zagnieżdżona encja zostanie zmapowana
        defaultListProperties = mappingService.createProperties(UserDto.Properties.class)
                .setIncludeNestedAddress(false); // zagnieżdżona encja nie zostanie zmapowana
    }
}