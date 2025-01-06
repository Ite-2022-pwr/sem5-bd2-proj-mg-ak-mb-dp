package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Address;
import pl.pwr.ite.bd2.model.filter.AddressFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface AddressRepository extends FilterableRepository<Address, AddressFilter> {
}
