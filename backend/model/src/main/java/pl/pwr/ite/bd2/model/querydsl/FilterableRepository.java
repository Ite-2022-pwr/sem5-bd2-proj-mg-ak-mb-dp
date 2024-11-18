package pl.pwr.ite.bd2.model.querydsl;

import org.springframework.data.repository.NoRepositoryBean;
import pl.pwr.ite.bd2.model.entity.EntityBase;
import pl.pwr.ite.bd2.model.filter.Filter;

import java.util.List;

@NoRepositoryBean
public interface FilterableRepository<T extends EntityBase, F extends Filter> extends EntityRepository<T>, FilterExecutor<T, F> {

    List<T> findAll(F filter);
}
