package pl.pwr.ite.bd2.client.web.service;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PhoneNumberDto;
import pl.pwr.ite.bd2.client.web.mapper.PhoneNumberMapper;
import pl.pwr.ite.bd2.model.entity.PhoneNumber;
import pl.pwr.ite.bd2.model.filter.PhoneNumberFilter;
import pl.pwr.ite.bd2.service.PhoneNumberService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;

@Component
public class PhoneNumberFacade extends EntityServiceFacade<PhoneNumber, PhoneNumberFilter, PhoneNumberService, PhoneNumberDto, PhoneNumberDto.Properties, PhoneNumberMapper> {
    public PhoneNumberFacade(PhoneNumberService service, PhoneNumberMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }
}
