package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Teacher;
import pl.pwr.ite.bd2.model.filter.TeacherFilter;
import pl.pwr.ite.bd2.model.repository.TeacherRepository;
import pl.pwr.ite.bd2.service.TeacherService;

@Service
public class TeacherServiceImpl extends FilterableEntityServiceBase<Teacher, TeacherFilter> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }
}
