package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPhoneNumbersParentsMatch is a Querydsl query type for PhoneNumbersParentsMatch
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhoneNumbersParentsMatch extends EntityPathBase<PhoneNumbersParentsMatch> {

    private static final long serialVersionUID = -1930859017L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhoneNumbersParentsMatch phoneNumbersParentsMatch = new QPhoneNumbersParentsMatch("phoneNumbersParentsMatch");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final StringPath description = createString("description");

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final QParent parent;

    public final QPhoneNumber phoneNumber;

    public QPhoneNumbersParentsMatch(String variable) {
        this(PhoneNumbersParentsMatch.class, forVariable(variable), INITS);
    }

    public QPhoneNumbersParentsMatch(Path<? extends PhoneNumbersParentsMatch> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPhoneNumbersParentsMatch(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPhoneNumbersParentsMatch(PathMetadata metadata, PathInits inits) {
        this(PhoneNumbersParentsMatch.class, metadata, inits);
    }

    public QPhoneNumbersParentsMatch(Class<? extends PhoneNumbersParentsMatch> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QParent(forProperty("parent"), inits.get("parent")) : null;
        this.phoneNumber = inits.isInitialized("phoneNumber") ? new QPhoneNumber(forProperty("phoneNumber")) : null;
    }

}

