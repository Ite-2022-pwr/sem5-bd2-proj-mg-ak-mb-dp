package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.PhoneNumber;
import pl.pwr.ite.bd2.model.filter.PhoneNumberFilter;
import pl.pwr.ite.bd2.model.repository.PhoneNumberRepository;
import pl.pwr.ite.bd2.service.PhoneNumberService;

@Service
public class PhoneNumberServiceImpl extends FilterableEntityServiceBase<PhoneNumber, PhoneNumberFilter> implements PhoneNumberService {
    public PhoneNumberServiceImpl(PhoneNumberRepository repository) {
        super(repository);
    }
}
