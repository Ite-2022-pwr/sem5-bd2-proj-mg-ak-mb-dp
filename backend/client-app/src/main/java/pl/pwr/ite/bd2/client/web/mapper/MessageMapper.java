package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.MessageDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.Message;

@Component
@RequiredArgsConstructor
public class MessageMapper extends MapperBase<Message, MessageDto, MessageDto.Properties> {

    private final UserMapper userMapper;

    @Override
    public void transform(Message source, MessageDto destination, MessageDto.Properties properties) {
        destination.setContent(source.getContent());
        destination.setDateSent(source.getDateSent());

        if(properties.isIncludeSender()) {
            map(destination::setSender, source.getSender(), userMapper, properties);
        }
    }
}
