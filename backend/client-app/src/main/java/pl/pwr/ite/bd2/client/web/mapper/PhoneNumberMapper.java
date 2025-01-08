package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PhoneNumberDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.PhoneNumber;

@Component
@RequiredArgsConstructor
public class PhoneNumberMapper extends MapperBase<PhoneNumber, PhoneNumberDto, PhoneNumberDto.Properties> {
    @Override
    public void transform(PhoneNumber source, PhoneNumberDto destination, PhoneNumberDto.Properties properties) {
        destination.setId(source.getId());
        destination.setPhoneNumber(source.getPhoneNumber());
    }
}
