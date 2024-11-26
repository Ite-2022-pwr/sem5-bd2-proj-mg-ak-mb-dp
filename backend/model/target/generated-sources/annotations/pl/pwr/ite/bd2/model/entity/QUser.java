package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1298351638L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QEntityBase _super = new QEntityBase(this);

    public final QAddress address;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    public final StringPath login = createString("login");

    public final SetPath<Message, QMessage> messages = this.<Message, QMessage>createSet("messages", Message.class, QMessage.class, PathInits.DIRECT2);

    public final SetPath<MessageUserReceiverPair, QMessageUserReceiverPair> messageUserReceiverPairs = this.<MessageUserReceiverPair, QMessageUserReceiverPair>createSet("messageUserReceiverPairs", MessageUserReceiverPair.class, QMessageUserReceiverPair.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final QParent parent;

    public final StringPath passwordHash = createString("passwordHash");

    public final SetPath<UserRole, QUserRole> roles = this.<UserRole, QUserRole>createSet("roles", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public final StringPath secondName = createString("secondName");

    public final QStudent student;

    public final StringPath surname = createString("surname");

    public final QTeacher teacher;

    public final EnumPath<pl.pwr.ite.bd2.model.enums.UserType> type = createEnum("type", pl.pwr.ite.bd2.model.enums.UserType.class);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address"), inits.get("address")) : null;
        this.parent = inits.isInitialized("parent") ? new QParent(forProperty("parent"), inits.get("parent")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher"), inits.get("teacher")) : null;
    }

}

