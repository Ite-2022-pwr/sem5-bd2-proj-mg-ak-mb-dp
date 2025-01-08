package pl.pwr.ite.bd2.service.impl;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.PostCode;
import pl.pwr.ite.bd2.model.filter.PostCodeFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;
import pl.pwr.ite.bd2.model.repository.PostCodeRepository;
import pl.pwr.ite.bd2.service.FilterableEntityService;
import pl.pwr.ite.bd2.service.PostCodeService;

@Service
public class PostCodeServiceImpl extends FilterableEntityServiceBase<PostCode, PostCodeFilter> implements PostCodeService {

    public PostCodeServiceImpl(PostCodeRepository repository) {
        super(repository);
    }
}
