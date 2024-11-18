package pl.pwr.ite.bd2.service;

import pl.pwr.ite.bd2.mapping.MappingProperties;

public interface MappingService {

    <T extends MappingProperties> T createProperties(Class<T> propertiesType);
}
