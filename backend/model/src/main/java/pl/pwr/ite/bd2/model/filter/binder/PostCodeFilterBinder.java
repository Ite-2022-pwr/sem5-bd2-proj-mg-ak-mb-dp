package pl.pwr.ite.bd2.model.filter.binder;

import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.model.entity.PostCode;
import pl.pwr.ite.bd2.model.entity.QPostCode;
import pl.pwr.ite.bd2.model.filter.PostCodeFilter;

@Component
public class PostCodeFilterBinder extends FilterBinderBase<PostCode, PostCodeFilter, QPostCode> {
}
