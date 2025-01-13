package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.AddressDto;
import pl.pwr.ite.bd2.client.web.mapper.AddressMapper;
import pl.pwr.ite.bd2.model.entity.Address;
import pl.pwr.ite.bd2.model.filter.AddressFilter;
import pl.pwr.ite.bd2.service.AddressService;
import pl.pwr.ite.bd2.service.PostCodeService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class AddressFacade extends EntityServiceFacade<Address, AddressFilter, AddressService, AddressDto, AddressDto.Properties, AddressMapper> {

    private final PostCodeService postCodeService;

    public AddressFacade(AddressService service, AddressMapper mapper, SecurityFacade securityFacade, PostCodeService postCodeService) {
        super(service, mapper, securityFacade);
        this.postCodeService = postCodeService;
    }

    @Transactional
    public Address create(AddressDto dto) {
        var address = new Address();
        return saveAndFlush(setValues(address, dto));
    }

    @Transactional
    public Address update(UUID id, AddressDto dto) {
        var address = getById(id);
        if (address == null) {
            throw new ApplicationException(ApplicationError.AddressNotFound);
        }
        return saveAndFlush(setValues(address, dto));
    }

    private Address setValues(Address address, AddressDto dto) {
        address.setApartmentNumber(address.getApartmentNumber());
        address.setStreet(address.getStreet());
        address.setBuildingNumber(address.getBuildingNumber());

        var postCode = postCodeService.findById(dto.getPostCode().getId());
        if (postCode == null) {
            throw new ApplicationException(ApplicationError.PostCodeNotFound);
        }
        address.setPostCode(postCode);

        return address;
    }
}
