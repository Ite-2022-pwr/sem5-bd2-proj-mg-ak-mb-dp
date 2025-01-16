package pl.pwr.ite.bd2.service;

import org.springframework.stereotype.Service;
import pl.pwr.ite.bd2.model.entity.Grade;
import pl.pwr.ite.bd2.model.filter.GradeFilter;

public interface GradeService extends FilterableEntityService<Grade, GradeFilter> {
}