package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.SchoolClass;
import pl.pwr.ite.bd2.model.filter.SchoolClassFilter;
import pl.pwr.ite.bd2.model.repository.SchoolClassRepository;
import pl.pwr.ite.bd2.service.SchoolClassService;

public class SchoolClassServiceImpl extends FilterableEntityServiceBase<SchoolClass, SchoolClassFilter> implements SchoolClassService {
    public SchoolClassServiceImpl(SchoolClassRepository repository) {
        super(repository);
    }
}
