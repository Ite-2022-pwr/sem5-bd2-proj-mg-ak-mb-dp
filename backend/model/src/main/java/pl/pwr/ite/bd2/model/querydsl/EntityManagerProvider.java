package pl.pwr.ite.bd2.model.querydsl;

import jakarta.persistence.EntityManager;

public interface EntityManagerProvider {

    EntityManager getEntityManager();
}
