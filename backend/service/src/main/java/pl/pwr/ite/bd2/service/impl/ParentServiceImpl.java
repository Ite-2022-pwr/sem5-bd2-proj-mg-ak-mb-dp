package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Parent;
import pl.pwr.ite.bd2.model.filter.ParentFilter;
import pl.pwr.ite.bd2.model.repository.ParentRepository;
import pl.pwr.ite.bd2.service.ParentService;

@Service
public class ParentServiceImpl extends FilterableEntityServiceBase<Parent, ParentFilter> implements ParentService {
    public ParentServiceImpl(ParentRepository repository) {
        super(repository);
    }
}
