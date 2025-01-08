package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Student;
import pl.pwr.ite.bd2.model.filter.StudentFilter;
import pl.pwr.ite.bd2.model.repository.StudentRepository;
import pl.pwr.ite.bd2.service.StudentService;

@Service
public class StudentSeviceImpl extends FilterableEntityServiceBase<Student, StudentFilter> implements StudentService {
    public StudentSeviceImpl(StudentRepository repository) {
        super(repository);
    }
}
