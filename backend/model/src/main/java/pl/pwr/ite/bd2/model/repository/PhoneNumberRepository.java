package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.PhoneNumber;
import pl.pwr.ite.bd2.model.filter.PhoneNumberFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface PhoneNumberRepository extends FilterableRepository<PhoneNumber, PhoneNumberFilter> {
}
