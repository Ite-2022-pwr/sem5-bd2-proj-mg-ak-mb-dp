package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.QAddress;
import pl.pwr.ite.bd2.model.filter.AddressFilter;
import pl.pwr.ite.bd2.model.entity.Address;


@Component
public class AddressFilterBinder extends FilterBinderBase<Address, AddressFilter, QAddress>{
}
