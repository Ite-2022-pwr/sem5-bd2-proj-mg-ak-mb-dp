package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.PhoneNumber;
import pl.pwr.ite.bd2.model.entity.QPhoneNumber;
import pl.pwr.ite.bd2.model.filter.PhoneNumberFilter;

@Component
public class PhoneNumberFilterBinder extends FilterBinderBase<PhoneNumber, PhoneNumberFilter, QPhoneNumber> {
}
