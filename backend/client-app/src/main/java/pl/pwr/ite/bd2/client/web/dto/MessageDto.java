package pl.pwr.ite.bd2.client.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.pwr.ite.bd2.mapping.MappingProperties;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeSender;
    }

    private String content;

    private LocalDateTime dateSent;

    private UserDto sender;
}
