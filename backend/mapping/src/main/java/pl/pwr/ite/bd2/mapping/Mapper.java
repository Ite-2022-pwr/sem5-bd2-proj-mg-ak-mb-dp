package pl.pwr.ite.bd2.mapping;

import java.util.List;
import java.util.function.Consumer;

public interface Mapper<S, D, P extends MappingProperties> {

    Class<S> getSourceType();
    Class<D> getDestinationType();
    Class<P> getPropertiesType();

    D map(S source, MappingProperties properties);
    void map(S source, D destination, MappingProperties mappingProperties);

    <Sex, XD, Penis extends MappingProperties> void map(Consumer<XD> setter, Sex source, Mapper<Sex, XD, Penis> mapper, MappingProperties properties);
    <Sex, XD, Penis extends MappingProperties> void map(Consumer<XD[]> setter, Iterable<Sex> source, Mapper<Sex, XD, Penis> mapper, MappingProperties properties);
    <Sex, XD, Penis extends MappingProperties> void mapToList(Consumer<List<XD>> setter, Iterable<Sex> source, Mapper<Sex, XD, Penis> mapper, MappingProperties properties);
    List<D> map(Iterable<? extends S> source, MappingProperties properties);

    void transform(S source, D destination, P properties);
    D createDestination(S source);
}
