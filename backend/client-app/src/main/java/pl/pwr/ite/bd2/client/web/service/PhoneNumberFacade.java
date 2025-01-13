package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PhoneNumberDto;
import pl.pwr.ite.bd2.client.web.mapper.PhoneNumberMapper;
import pl.pwr.ite.bd2.model.entity.PhoneNumber;
import pl.pwr.ite.bd2.model.filter.PhoneNumberFilter;
import pl.pwr.ite.bd2.service.PhoneNumberService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class PhoneNumberFacade extends EntityServiceFacade<PhoneNumber, PhoneNumberFilter, PhoneNumberService, PhoneNumberDto, PhoneNumberDto.Properties, PhoneNumberMapper> {
    public PhoneNumberFacade(PhoneNumberService service, PhoneNumberMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }

    @Transactional
    public PhoneNumber create(PhoneNumberDto dto) {
        var phoneNumber = new PhoneNumber();
        return saveAndFlush(setValues(phoneNumber, dto));
    }

    @Transactional
    public PhoneNumber update(UUID id, PhoneNumberDto dto) {
        var phoneNumber = getById(id);
        if (phoneNumber == null) {
            throw new ApplicationException(ApplicationError.PhoneNumberNotFound);
        }
        return saveAndFlush(setValues(phoneNumber, dto));
    }

    private PhoneNumber setValues(PhoneNumber phoneNumber, PhoneNumberDto dto) {
        phoneNumber.setPhoneNumber(dto.getPhoneNumber());
        return phoneNumber;
    }
}
