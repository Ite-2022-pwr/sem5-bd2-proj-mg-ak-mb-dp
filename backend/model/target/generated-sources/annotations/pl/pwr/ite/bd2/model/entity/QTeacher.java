package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeacher is a Querydsl query type for Teacher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeacher extends EntityPathBase<Teacher> {

    private static final long serialVersionUID = -10529437L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeacher teacher = new QTeacher("teacher");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final SetPath<Grade, QGrade> grades = this.<Grade, QGrade>createSet("grades", Grade.class, QGrade.class, PathInits.DIRECT2);

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    public final DatePath<java.time.LocalDate> lastCOCRDate = createDate("lastCOCRDate", java.time.LocalDate.class);

    public final SetPath<Lesson, QLesson> lessons = this.<Lesson, QLesson>createSet("lessons", Lesson.class, QLesson.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final BooleanPath onLeave = createBoolean("onLeave");

    public final SetPath<TeachersTeachingSubject, QTeachersTeachingSubject> teachersTeachingSubjects = this.<TeachersTeachingSubject, QTeachersTeachingSubject>createSet("teachersTeachingSubjects", TeachersTeachingSubject.class, QTeachersTeachingSubject.class, PathInits.DIRECT2);

    public final QUser user;

    public QTeacher(String variable) {
        this(Teacher.class, forVariable(variable), INITS);
    }

    public QTeacher(Path<? extends Teacher> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeacher(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeacher(PathMetadata metadata, PathInits inits) {
        this(Teacher.class, metadata, inits);
    }

    public QTeacher(Class<? extends Teacher> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

