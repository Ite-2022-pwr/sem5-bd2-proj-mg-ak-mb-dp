package pl.pwr.ite.bd2.model.querydsl;

import org.springframework.data.domain.Page;
import pl.pwr.ite.bd2.model.entity.EntityBase;

public interface TypedPage<T extends EntityBase> extends Page<T> {

    Class<T> getType();
}
