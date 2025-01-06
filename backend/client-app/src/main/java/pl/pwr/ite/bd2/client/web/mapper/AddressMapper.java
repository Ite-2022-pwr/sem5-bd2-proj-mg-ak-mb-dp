package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.AddressDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Address;

@Component
@RequiredArgsConstructor
public class AddressMapper extends MapperBase<Address, AddressDto, AddressDto.Properties> {

    private final PostCodeMapper postCodeMapper;

    @Override
    public void transform(Address source, AddressDto destination, AddressDto.Properties properties) {
        destination.setId(source.getId());
        destination.setStreet(source.getStreet());
        destination.setBuildingNumber(source.getBuildingNumber());
        destination.setApartmentNumber(source.getApartmentNumber());

        map(destination::setPostCode, source.getPostCode(), postCodeMapper, properties);
    }
}
