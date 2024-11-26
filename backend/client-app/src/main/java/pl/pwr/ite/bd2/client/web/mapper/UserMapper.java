package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.UserDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.User;

@Component
@RequiredArgsConstructor
public class UserMapper extends MapperBase<User, UserDto, UserDto.Properties> {

    @Override
    public void transform(User source, UserDto destination, UserDto.Properties properties) {
        destination.setId(source.getId());
        destination.setUserType(source.getType());
        destination.setEmail(source.getEmail());
        destination.setFirstName(source.getFirstName());
        destination.setSecondName(source.getSecondName());
    }
}
