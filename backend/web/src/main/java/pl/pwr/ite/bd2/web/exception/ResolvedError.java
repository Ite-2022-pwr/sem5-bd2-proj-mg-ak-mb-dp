package pl.pwr.ite.bd2.web.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResolvedError {

    private ErrorDto error;
    private HttpStatus status;
}
