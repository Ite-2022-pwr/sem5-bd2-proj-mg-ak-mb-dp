package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.model.filter.AddressFilter;
import pl.pwr.ite.bd2.model.entity.Address;

public interface AddressRepository extends FilterableRepository<Address, AddressFilter> {
}
