package pl.pwr.ite.bd2.service;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Address;
import pl.pwr.ite.bd2.model.filter.AddressFilter;

public interface AddressService extends FilterableEntityService<Address, AddressFilter> {
}
