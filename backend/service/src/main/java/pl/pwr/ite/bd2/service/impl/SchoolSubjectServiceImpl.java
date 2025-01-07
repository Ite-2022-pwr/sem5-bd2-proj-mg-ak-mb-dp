package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.filter.SchoolSubjectFilter;
import pl.pwr.ite.bd2.model.repository.SchoolSubjectRepository;
import pl.pwr.ite.bd2.service.SchoolSubjectService;

public class SchoolSubjectServiceImpl extends FilterableEntityServiceBase<SchoolSubject, SchoolSubjectFilter> implements SchoolSubjectService {
    public SchoolSubjectServiceImpl(SchoolSubjectRepository repository) {
        super(repository);
    }
}
