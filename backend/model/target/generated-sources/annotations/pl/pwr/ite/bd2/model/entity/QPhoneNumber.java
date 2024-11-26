package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPhoneNumber is a Querydsl query type for PhoneNumber
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhoneNumber extends EntityPathBase<PhoneNumber> {

    private static final long serialVersionUID = 1094687576L;

    public static final QPhoneNumber phoneNumber1 = new QPhoneNumber("phoneNumber1");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final StringPath phoneNumber = createString("phoneNumber");

    public final SetPath<PhoneNumbersParentsMatch, QPhoneNumbersParentsMatch> phoneNumbersParentsMatchSet = this.<PhoneNumbersParentsMatch, QPhoneNumbersParentsMatch>createSet("phoneNumbersParentsMatchSet", PhoneNumbersParentsMatch.class, QPhoneNumbersParentsMatch.class, PathInits.DIRECT2);

    public QPhoneNumber(String variable) {
        super(PhoneNumber.class, forVariable(variable));
    }

    public QPhoneNumber(Path<? extends PhoneNumber> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPhoneNumber(PathMetadata metadata) {
        super(PhoneNumber.class, metadata);
    }

}

