package pl.pwr.ite.bd2.model.querydsl;

import jakarta.persistence.EntityManager;

public class DefaultEntityManagerProvider implements EntityManagerProvider {

    private final EntityManager entityManager;

    public DefaultEntityManagerProvider(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
