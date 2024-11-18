package pl.pwr.ite.bd2.model.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.pwr.ite.bd2.model.entity.EntityBase;

import java.util.UUID;

@NoRepositoryBean
public interface EntityRepository <T extends EntityBase> extends JpaRepository<T, UUID>, EntityManagerProvider, PathProvider<T>{
}
