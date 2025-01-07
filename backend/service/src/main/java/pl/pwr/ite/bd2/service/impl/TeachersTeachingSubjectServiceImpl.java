package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.TeachersTeachingSubject;
import pl.pwr.ite.bd2.model.repository.TeachersTeachingSubjectRepository;
import pl.pwr.ite.bd2.service.TeachersTeachingSubjectService;

@Service
public class TeachersTeachingSubjectServiceImpl extends EntityServiceBase<TeachersTeachingSubject> implements TeachersTeachingSubjectService {
    public TeachersTeachingSubjectServiceImpl(TeachersTeachingSubjectRepository repository) {
        super(repository);
    }
}
