package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.Address;
import pl.pwr.ite.bd2.model.entity.QAddress;
import pl.pwr.ite.bd2.model.filter.AddressFilter;

@Component
public class AddressFilterBinder extends FilterBinderBase<Address, AddressFilter, QAddress> {
}
