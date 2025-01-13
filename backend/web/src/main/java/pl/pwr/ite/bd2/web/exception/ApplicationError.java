package pl.pwr.ite.bd2.web.exception;

import com.google.common.base.CaseFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApplicationError implements ErrorDescriptor {
    NoAuthenticatedUser(HttpStatus.FORBIDDEN),
    UserNotFound(HttpStatus.NOT_FOUND),
    DataNotFound(HttpStatus.NOT_FOUND),
    UserDataNotFound(HttpStatus.NOT_FOUND),
    UserTokenNotFound(HttpStatus.NOT_FOUND),
    ActivityNotFound(HttpStatus.NOT_FOUND),
    AnnouncementNotFound(HttpStatus.NOT_FOUND),
    UserDisplayNotFound(HttpStatus.NOT_FOUND),
    RegistrationNotFound(HttpStatus.NOT_FOUND),
    RegistrationPartNotFound(HttpStatus.NOT_FOUND),

    //LOGIN
    PasswordHashNotPresent(HttpStatus.FORBIDDEN),
    WrongPassword(HttpStatus.FORBIDDEN),
    InvalidJwtToken(HttpStatus.FORBIDDEN),

    //REGISTRATION PROCESS
    RegistrationFull(HttpStatus.FORBIDDEN),
    RegistrationPartLocked(HttpStatus.FORBIDDEN),
    UserAlreadyRegistered(HttpStatus.FORBIDDEN),
    UserWithCodeNotFound(HttpStatus.NOT_FOUND),
    UserAlreadyOwnsALock(HttpStatus.FORBIDDEN),

    //ACTIVITY REGISTRATION
    ActivityRegistrationNotFound(HttpStatus.NOT_FOUND),
    TeamNameAlreadyTaken(HttpStatus.FORBIDDEN),

    //DB2
    LessonNotFound(HttpStatus.NOT_FOUND),
    SchoolClassNotFound(HttpStatus.NOT_FOUND),
    TeacherNotFound(HttpStatus.NOT_FOUND),
    SchoolSubjectNotFound(HttpStatus.NOT_FOUND),
    PostCodeNotFound(HttpStatus.NOT_FOUND),
    AddressNotFound(HttpStatus.NOT_FOUND),
    StudentNotFound(HttpStatus.NOT_FOUND),
    GradeNotFound(HttpStatus.NOT_FOUND),
    MessageNotFound(HttpStatus.NOT_FOUND),
    ParentNotFound(HttpStatus.NOT_FOUND),
    PhoneNumberNotFound(HttpStatus.NOT_FOUND),
    PresenceNotFound(HttpStatus.NOT_FOUND),
    ;

    private final HttpStatus defaultStatus;

    private final String code;

    private final String defaultMessage;

    ApplicationError(HttpStatus defaultStatus) {
        this(defaultStatus, null, null);
    }

    ApplicationError(HttpStatus defaultStatus, String defaultMessage) {
        this(defaultStatus, null, defaultMessage);
    }

    ApplicationError(HttpStatus defaultStatus, String code, String defaultMessage) {
        this.defaultStatus = defaultStatus;
        if(code == null) {
            code = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, this.name());
        }
        if(defaultMessage == null) {
            defaultMessage = code;
        }
        this.code = code;
        this.defaultMessage = defaultMessage;
    }
}
