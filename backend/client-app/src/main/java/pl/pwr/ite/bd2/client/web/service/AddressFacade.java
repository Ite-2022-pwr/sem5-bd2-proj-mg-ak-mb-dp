package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.AddressDto;
import pl.pwr.ite.bd2.client.web.mapper.AddressMapper;
import pl.pwr.ite.bd2.model.entity.Address;
import pl.pwr.ite.bd2.model.filter.AddressFilter;
import pl.pwr.ite.bd2.service.AddressService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class AddressFacade extends EntityServiceFacade<Address, AddressFilter, AddressService, AddressDto, AddressDto.Properties, AddressMapper> {

    public AddressFacade(AddressService service, AddressMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
