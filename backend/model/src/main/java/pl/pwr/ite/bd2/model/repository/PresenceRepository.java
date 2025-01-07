package pl.pwr.ite.bd2.model.repository;

import pl.pwr.ite.bd2.model.entity.Presence;
import pl.pwr.ite.bd2.model.filter.PresenceFilter;
import pl.pwr.ite.bd2.model.querydsl.FilterableRepository;

public interface PresenceRepository extends FilterableRepository<Presence, PresenceFilter> {
}
