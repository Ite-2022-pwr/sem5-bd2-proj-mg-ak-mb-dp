package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.TeachersTeachingSubject;
import pl.pwr.ite.bd2.model.repository.TeachersTeachingSubjectRepository;
import pl.pwr.ite.bd2.service.TeachersTeachingSubjectService;

public class TeachersTeachingSubjectServiceImpl extends EntityServiceBase<TeachersTeachingSubject> implements TeachersTeachingSubjectService {
    public TeachersTeachingSubjectServiceImpl(TeachersTeachingSubjectRepository repository) {
        super(repository);
    }
}
