package pl.pwr.ite.bd2.client.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pwr.ite.bd2.client.web.dto.MessageDto;
import pl.pwr.ite.bd2.client.web.service.MessageFacade;
import pl.pwr.ite.bd2.mapping.MappingProperties;
import pl.pwr.ite.bd2.model.filter.MessageFilter;
import pl.pwr.ite.bd2.service.MappingService;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController implements InitializingBean {

    private final MessageFacade messageFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;


    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(MessageDto.Properties.class)
                .setIncludeSender(true);
        defaultListProperties = mappingService.createProperties(MessageDto.Properties.class)
                .setIncludeSender(true);
    }

    @GetMapping
    public ResponseEntity<Collection<MessageDto>> getAll(MessageFilter filter) {
        return ResponseEntity.ok(messageFacade.getList(filter, defaultListProperties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(messageFacade.getById(id, defaultSingleProperties));
    }
}
