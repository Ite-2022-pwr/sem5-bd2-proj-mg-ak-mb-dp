package pl.pwr.ite.bd2.service.impl;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.QRole;
import pl.pwr.ite.bd2.model.entity.Role;
import pl.pwr.ite.bd2.model.filter.RoleFilter;
import pl.pwr.ite.bd2.model.repository.RoleRepository;
import pl.pwr.ite.bd2.service.RoleService;

@Service
public class RoleServiceImpl extends FilterableEntityServiceBase<Role, RoleFilter> implements RoleService {

    @PersistenceContext
    private EntityManager entityManager;

    public RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }

    @Override
    public Role findByCode(String code) {
        var path = QRole.role;
        return new JPAQuery<>(entityManager).select(path).from(path)
                .where(path.code.eq(code))
                .fetchOne();
    }
}
