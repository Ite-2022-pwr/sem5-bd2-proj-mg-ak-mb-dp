package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.SchoolSubject;
import pl.pwr.ite.bd2.model.filter.SchoolSubjectFilter;
import pl.pwr.ite.bd2.model.repository.SchoolSubjectRepository;
import pl.pwr.ite.bd2.service.SchoolSubjectService;

@Service
public class SchoolSubjectServiceImpl extends FilterableEntityServiceBase<SchoolSubject, SchoolSubjectFilter> implements SchoolSubjectService {
    public SchoolSubjectServiceImpl(SchoolSubjectRepository repository) {
        super(repository);
    }
}
