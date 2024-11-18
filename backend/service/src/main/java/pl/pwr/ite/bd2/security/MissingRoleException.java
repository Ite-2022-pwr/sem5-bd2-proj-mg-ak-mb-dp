package pl.pwr.ite.bd2.security;

import org.springframework.security.core.AuthenticationException;

public class MissingRoleException extends AuthenticationException {

    public MissingRoleException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MissingRoleException(String msg) {
        super(msg);
    }
}
