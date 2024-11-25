package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessageUserReceiverPair is a Querydsl query type for MessageUserReceiverPair
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessageUserReceiverPair extends EntityPathBase<MessageUserReceiverPair> {

    private static final long serialVersionUID = -1832528260L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMessageUserReceiverPair messageUserReceiverPair = new QMessageUserReceiverPair("messageUserReceiverPair");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    public final QMessage message;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final QUser receiver;

    public QMessageUserReceiverPair(String variable) {
        this(MessageUserReceiverPair.class, forVariable(variable), INITS);
    }

    public QMessageUserReceiverPair(Path<? extends MessageUserReceiverPair> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMessageUserReceiverPair(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMessageUserReceiverPair(PathMetadata metadata, PathInits inits) {
        this(MessageUserReceiverPair.class, metadata, inits);
    }

    public QMessageUserReceiverPair(SchoolClass<? extends MessageUserReceiverPair> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.message = inits.isInitialized("message") ? new QMessage(forProperty("message"), inits.get("message")) : null;
        this.receiver = inits.isInitialized("receiver") ? new QUser(forProperty("receiver"), inits.get("receiver")) : null;
    }

}

