package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Address;
import pl.pwr.ite.bd2.model.filter.AddressFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.service.AddressService;

@Service
public class AddressServiceImpl extends FilterableEntityServiceBase<Address, AddressFilter> implements AddressService {
    public AddressServiceImpl(FilterableRepository<Address, AddressFilter> repository) {
        super(repository);
    }
}