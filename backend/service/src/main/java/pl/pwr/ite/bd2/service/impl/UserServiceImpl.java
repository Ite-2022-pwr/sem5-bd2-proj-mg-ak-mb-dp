package pl.pwr.ite.bd2.service.impl;

import com.google.common.base.CaseFormat;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.*;
import pl.pwr.ite.bd2.model.filter.UserFilter;
import pl.pwr.ite.bd2.model.repository.UserRepository;
import pl.pwr.ite.bd2.security.AuthenticatedUser;
import pl.pwr.ite.bd2.security.permission.UserRolePermissionGranter;
import pl.pwr.ite.bd2.service.UserService;

import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl extends FilterableEntityServiceBase<User, UserFilter> implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ApplicationContext applicationContext;

    public UserServiceImpl(UserRepository repository, ApplicationContext applicationContext) {
        super(repository);
        this.applicationContext = applicationContext;
    }

    @Override
    public User findById(UUID id) {
        var path = QUser.user;
        return createQuery().select(path).from(path).where(path.id.eq(id)).fetchOne();
    }

    @Override
    public User findByEmail(String email) {
        var path = QUser.user;
        return new JPAQuery<>(entityManager).select(path).from(path).where(path.email.equalsIgnoreCase(email)).fetchOne();
    }

    @Override
    public boolean hasRoleByCodes(UUID userId, String... code) {
        var userPath = QUser.user;
        var userRolePath = QUserRole.userRole;
        var rolePath = QRole.role;
        return createQuery()
                .from(userPath)
                .leftJoin(userPath.roles, userRolePath)
                .on(userRolePath.userId.eq(userId))
                .leftJoin(userRolePath.role, rolePath)
                .where(rolePath.code.in(code))
                .fetchFirst() != null;
    }

    @Override
    public User findByFirstAndLastName(String firstName, String lastName) {
        var path = QUser.user;
        return createQuery().select(path).from(path)
                .where(Expressions.allOf(
//                        path.firstName.eq(firstName),
//                        path.lastName.eq(lastName)
                )).fetchOne();
    }

    @Override
    public User findByCode(String userCode) {
        var path = QUser.user;
        return createQuery().select(path)
                .from(path)
//                .where(path.code.eq(userCode))
                .fetchOne();
    }

    @Override
    public boolean hasAdminPanelAccess(UUID userId) {
        var userRolePath = QUserRole.userRole;
        var rolePath = QRole.role;
        return createQuery().from(userRolePath)
                .leftJoin(userRolePath.role, rolePath)
                .where(Expressions.allOf(
                    userRolePath.userId.eq(userId),
                    rolePath.adminPanelAccess.isTrue()
                )).fetchFirst() != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var path = QUser.user;
        var tuple = new JPAQuery<>(entityManager).select(path.id, path.email/*, path.type*/).from(path).where(path.email.equalsIgnoreCase(username)).fetchOne();
        if(tuple == null) {
            throw new UsernameNotFoundException(String.format("User with email '%s' not found", username));
        }
        var userId = tuple.get(path.id);
//        var type = tuple.get(path.type);
        return AuthenticatedUser.builder().userId(userId).email(username)/*.userType(type)*/.build();
    }

    @Override
    public String generateCode(User user) {
        String code;
        int i = 1;
        do {
            var sb = new StringBuilder();
//            sb.append(user.getFirstName().charAt(0));
//            sb.append(user.getLastName().charAt(0));
            sb.append(String.format("%02d", i++));
            code = sb.toString();
        } while (findByCode(code) != null);
        return code;
    }

    @Override
    public void collectAuthorities(User user, Set<GrantedAuthority> grantedAuthorities) {
        grant(grantedAuthorities, user);
    }

    protected void grant(Set<GrantedAuthority> authorities, User user) {
        for(var userRole : user.getRoles()) {
            var role = userRole.getRole();
            var granterNames = role.getPermissionGranters();
            grant(authorities, userRole, granterNames);
        }
    }

    protected void grant(Set<GrantedAuthority> authorities, UserRole userRole, String granterBeanName) {
        var granter = applicationContext.getBean(granterBeanName, UserRolePermissionGranter.class);
        granter.handle(userRole, authorities);
    }

    protected void grant(Set<GrantedAuthority> authorities, UserRole userRole, String... granterNames) {
        for (var granterName : granterNames) {
            var granterBeanName = getGranterBeanName(granterName);
            grant(authorities, userRole, granterBeanName);
        }
    }

    protected String getGranterBeanName(String granterName) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, granterName) + "PermissionGranter";
    }

    @Override
    public boolean existsByEmail(String email) {
        var path = QUser.user;
        return new JPAQuery<>(entityManager)
                .select(path).from(path)
                .where(path.email.eq(email))
                .fetchFirst() != null;
    }
}