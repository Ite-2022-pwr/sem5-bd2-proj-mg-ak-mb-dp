package pl.pwr.ite.bd2.client.web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PostCodeDto;
import pl.pwr.ite.bd2.client.web.mapper.PostCodeMapper;
import pl.pwr.ite.bd2.model.entity.PostCode;
import pl.pwr.ite.bd2.model.filter.PostCodeFilter;
import pl.pwr.ite.bd2.service.PostCodeService;
import pl.pwr.ite.bd2.web.EntityServiceFacade;
import pl.pwr.ite.bd2.web.SecurityFacade;
import pl.pwr.ite.bd2.web.exception.ApplicationError;
import pl.pwr.ite.bd2.web.exception.ApplicationException;

import java.util.UUID;

@Component
public class PostCodeFacade extends EntityServiceFacade<PostCode, PostCodeFilter, PostCodeService, PostCodeDto, PostCodeDto.Properties, PostCodeMapper> {
    public PostCodeFacade(PostCodeService service, PostCodeMapper mapper, SecurityFacade securityFacade) {
        super(service, mapper, securityFacade);
    }

    @Transactional
    public PostCode create(PostCodeDto postCodeDto) {
        var postCode = new PostCode();
        return saveAndFlush(setValues(postCode, postCodeDto));
    }

    @Transactional
    public PostCode update(UUID id, PostCodeDto dto) {
        var postCode = getById(id);
        if (postCode == null) {
            throw new ApplicationException(ApplicationError.PostCodeNotFound);
        }
        return saveAndFlush(setValues(postCode, dto));
    }

    private PostCode setValues(PostCode postCode, PostCodeDto dto) {
        postCode.setPostCode(dto.getPostCode());
        postCode.setRegionName(dto.getRegionName());

        return postCode;
    }
}
