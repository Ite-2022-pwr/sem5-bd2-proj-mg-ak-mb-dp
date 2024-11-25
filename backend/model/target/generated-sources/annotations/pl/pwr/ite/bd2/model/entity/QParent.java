package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParent is a Querydsl query type for Parent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParent extends EntityPathBase<Parent> {

    private static final long serialVersionUID = 1960168201L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParent parent = new QParent("parent");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final EnumPath<pl.pwr.ite.bd2.model.enums.ParentRole> parentRole = createEnum("parentRole", pl.pwr.ite.bd2.model.enums.ParentRole.class);

    public final SetPath<ParentStudentPair, QParentStudentPair> parentStudentPairs = this.<ParentStudentPair, QParentStudentPair>createSet("parentStudentPairs", ParentStudentPair.class, QParentStudentPair.class, PathInits.DIRECT2);

    public final SetPath<PhoneNumbersParentsMatch, QPhoneNumbersParentsMatch> phoneNumbersParentsMatches = this.<PhoneNumbersParentsMatch, QPhoneNumbersParentsMatch>createSet("phoneNumbersParentsMatches", PhoneNumbersParentsMatch.class, QPhoneNumbersParentsMatch.class, PathInits.DIRECT2);

    public final QUser user;

    public QParent(String variable) {
        this(Parent.class, forVariable(variable), INITS);
    }

    public QParent(Path<? extends Parent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParent(PathMetadata metadata, PathInits inits) {
        this(Parent.class, metadata, inits);
    }

    public QParent(SchoolClass<? extends Parent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

