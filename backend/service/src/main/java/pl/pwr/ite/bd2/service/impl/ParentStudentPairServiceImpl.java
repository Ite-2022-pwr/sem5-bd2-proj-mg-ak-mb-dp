package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.ParentStudentPair;
import pl.pwr.ite.bd2.model.repository.ParentStudentPairRepository;
import pl.pwr.ite.bd2.service.ParentStudentPairService;

@Service
public class ParentStudentPairServiceImpl extends EntityServiceBase<ParentStudentPair> implements ParentStudentPairService {
    public ParentStudentPairServiceImpl(ParentStudentPairRepository repository) {
        super(repository);
    }
}
