package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.ParentDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Parent;

@Component
@RequiredArgsConstructor
public class ParentMapper extends MapperBase<Parent, ParentDto, ParentDto.Properties> {

    private final UserMapper userMapper;

    @Override
    public void transform(Parent source, ParentDto destination, ParentDto.Properties properties) {
        destination.setId(source.getId());
        destination.setParentRole(source.getParentRole());

        if (properties.isIncludeUser()) {
            map(destination::setUser, source.getUser(), userMapper, properties);
        }
    }
}
