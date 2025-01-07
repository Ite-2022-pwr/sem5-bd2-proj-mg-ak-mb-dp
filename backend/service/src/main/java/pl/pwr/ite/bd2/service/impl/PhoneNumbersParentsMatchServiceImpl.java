package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.PhoneNumbersParentsMatch;
import pl.pwr.ite.bd2.model.repository.PhoneNumbersParentsMatchRepository;
import pl.pwr.ite.bd2.service.PhoneNumbersParentsMatchService;

public class PhoneNumbersParentsMatchServiceImpl extends EntityServiceBase<PhoneNumbersParentsMatch> implements PhoneNumbersParentsMatchService {
    public PhoneNumbersParentsMatchServiceImpl(PhoneNumbersParentsMatchRepository repository) {
        super(repository);
    }
}
