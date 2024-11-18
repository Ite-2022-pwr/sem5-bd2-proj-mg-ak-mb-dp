package pl.pwr.ite.bd2.model.querydsl;

import com.querydsl.core.types.EntityPath;

public interface PathProvider<T> {

    EntityPath<T> getPath();
}
