package pl.pwr.ite.bd2.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.querydsl.TypedPage;

@Slf4j
@Component
@RequiredArgsConstructor
public class TypedPageMapper extends MapperBase<TypedPage, PageDto, PageDto.Properties> {

    @Override
    public void transform(TypedPage source, PageDto destination, PageDto.Properties properties) {
        destination.setContent(properties.getContentMapper().map(source.getContent(), properties));
        destination.setPageNumber(source.getNumber());
        destination.setTotalPages(source.getTotalPages());
        destination.setNumberOfElements(source.getNumberOfElements());
        destination.setTotalElements(source.getTotalElements());
    }
}
