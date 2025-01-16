package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.AddressDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Address;

@Component
@RequiredArgsConstructor
public class AddressMapper extends MapperBase<Address, AddressDto, AddressDto.Properties> {
    private String street;
    private String buildingNumber;

    private String apartmentNumber;

    @Override
    public void transform(Address source, AddressDto destination, AddressDto.Properties properties) {
        destination.setStreet(source.getStreet());
    }
}