package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.Grade;
import pl.pwr.ite.bd2.model.filter.GradeFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.model.repository.GradeRepository;
import pl.pwr.ite.bd2.service.GradeService;

public class GradeServiceImpl extends FilterableEntityServiceBase<Grade, GradeFilter> implements GradeService {
    public GradeServiceImpl(GradeRepository repository) {
        super(repository);
    }
}
