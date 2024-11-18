package pl.pwr.ite.bd2.web.exception;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
public class ErrorDto {

    private String requestId;

    private String code;

    private String message;

    private Map<String, Object> additionalInfo;

    private boolean accessRevoked;

    private FieldErrorDto[] fieldErrors;
}
