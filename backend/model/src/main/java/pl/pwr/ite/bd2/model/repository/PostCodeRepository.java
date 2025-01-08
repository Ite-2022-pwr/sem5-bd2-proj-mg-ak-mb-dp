package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.PostCode;
import pl.pwr.ite.bd2.model.filter.PostCodeFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface PostCodeRepository extends FilterableRepository<PostCode, PostCodeFilter> {
}
