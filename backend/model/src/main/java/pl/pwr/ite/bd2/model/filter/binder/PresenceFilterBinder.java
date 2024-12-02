package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.Presence;
import pl.pwr.ite.bd2.model.entity.QPresence;
import pl.pwr.ite.bd2.model.filter.PresenceFilter;
import pl.pwr.ite.bd2.model.filter.binder.FilterBinderBase;

@Component
public class PresenceFilterBinder extends FilterBinderBase<Presence, PresenceFilter, QPresence> {
}
