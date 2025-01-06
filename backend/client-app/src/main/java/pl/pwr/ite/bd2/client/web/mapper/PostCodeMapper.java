package pl.pwr.ite.bd2.client.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pwr.ite.bd2.client.web.dto.PostCodeDto;
import pl.pwr.ite.bd2.mapping.MapperBase;
import pl.pwr.ite.bd2.model.entity.PostCode;

@Component
@RequiredArgsConstructor
public class PostCodeMapper extends MapperBase<PostCode, PostCodeDto, PostCodeDto.Properties> {

    @Override
    public void transform(PostCode source, PostCodeDto destination, PostCodeDto.Properties properties) {
        destination.setId(source.getId());
        destination.setPostCode(source.getPostCode());
        destination.setRegionName(source.getRegionName());
    }
}
