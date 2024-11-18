package pl.pwr.ite.bd2.web.exception;

import org.springframework.http.HttpStatus;

public interface ErrorDescriptor {

    HttpStatus getDefaultStatus();
    String getCode();
    String getDefaultMessage();
}
