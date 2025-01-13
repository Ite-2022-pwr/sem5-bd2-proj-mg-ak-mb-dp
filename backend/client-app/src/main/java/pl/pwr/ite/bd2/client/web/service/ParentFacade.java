package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.ParentDto;
import pl.pwr.ite.bd2.client.web.mapper.ParentMapper;
import pl.pwr.ite.bd2.model.entity.Parent;
import pl.pwr.ite.bd2.model.filter.ParentFilter;
import pl.pwr.ite.bd2.service.ParentService;
import pl.pwr.ite.bd2.service.UserService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class ParentFacade extends EntityServiceFacade<Parent, ParentFilter, ParentService, ParentDto, ParentDto.Properties, ParentMapper> {

    private final UserService userService;

    public ParentFacade(ParentService service, ParentMapper mapper, SecurityFacade securityFacade, UserService userService) {
        super(service, mapper, securityFacade);
        this.userService = userService;
    }

    @Transactional
    public Parent create(ParentDto dto) {
        var parent = new Parent();
        return saveAndFlush(setValues(parent, dto));
    }

    @Transactional
    public Parent update(UUID id, ParentDto dto) {
        var parent = getById(id);
        if (parent == null) {
            throw new ApplicationException(ApplicationError.ParentNotFound);
        }
        return saveAndFlush(setValues(parent, dto));
    }

    private Parent setValues(Parent parent, ParentDto dto) {
        parent.setParentRole(dto.getParentRole());

        var user = userService.findById(dto.getUser().getId());
        if (user == null) {
            throw new ApplicationException(ApplicationError.UserNotFound);
        }
        parent.setUser(user);

        return parent;
    }
}
