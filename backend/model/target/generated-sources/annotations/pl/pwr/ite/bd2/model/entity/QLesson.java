package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLesson is a Querydsl query type for Lesson
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLesson extends EntityPathBase<Lesson> {

    private static final long serialVersionUID = 1849388951L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLesson lesson = new QLesson("lesson");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final DateTimePath<java.time.LocalDateTime> dateTimeEnd = createDateTime("dateTimeEnd", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> dateTimeStart = createDateTime("dateTimeStart", java.time.LocalDateTime.class);

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final SetPath<Presence, QPresence> presences = this.<Presence, QPresence>createSet("presences", Presence.class, QPresence.class, PathInits.DIRECT2);

    public final QSchoolSubject schoolSubject;

    public final QSchoolClass studentClass;

    public final QTeacher teacher;

    public final StringPath topic = createString("topic");

    public QLesson(String variable) {
        this(Lesson.class, forVariable(variable), INITS);
    }

    public QLesson(Path<? extends Lesson> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLesson(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLesson(PathMetadata metadata, PathInits inits) {
        this(Lesson.class, metadata, inits);
    }

    public QLesson(Class<? extends Lesson> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.schoolSubject = inits.isInitialized("schoolSubject") ? new QSchoolSubject(forProperty("schoolSubject")) : null;
        this.studentClass = inits.isInitialized("studentClass") ? new QSchoolClass(forProperty("studentClass")) : null;
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher"), inits.get("teacher")) : null;
    }

}

