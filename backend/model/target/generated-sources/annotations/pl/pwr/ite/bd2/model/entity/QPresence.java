package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPresence is a Querydsl query type for Presence
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPresence extends EntityPathBase<Presence> {

    private static final long serialVersionUID = 74138522L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPresence presence = new QPresence("presence");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    public final QLesson lesson;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final QStudent student;

    public final EnumPath<pl.pwr.ite.bd2.model.enums.PresenceType> type = createEnum("type", pl.pwr.ite.bd2.model.enums.PresenceType.class);

    public QPresence(String variable) {
        this(Presence.class, forVariable(variable), INITS);
    }

    public QPresence(Path<? extends Presence> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPresence(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPresence(PathMetadata metadata, PathInits inits) {
        this(Presence.class, metadata, inits);
    }

    public QPresence(Class<? extends Presence> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lesson = inits.isInitialized("lesson") ? new QLesson(forProperty("lesson"), inits.get("lesson")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

