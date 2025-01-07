package pl.pwr.ite.bd2.service.impl;

import pl.pwr.ite.bd2.model.entity.Presence;
import pl.pwr.ite.bd2.model.filter.PresenceFilter;
import pl.pwr.ite.bd2.model.repository.PresenceRepository;
import pl.pwr.ite.bd2.service.PresenceService;

public class PresenceServiceImpl extends FilterableEntityServiceBase<Presence, PresenceFilter> implements PresenceService {
    public PresenceServiceImpl(PresenceRepository repository) {
        super(repository);
    }
}
