package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeachersTeachingSubject is a Querydsl query type for TeachersTeachingSubject
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeachersTeachingSubject extends EntityPathBase<TeachersTeachingSubject> {

    private static final long serialVersionUID = 1678794639L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeachersTeachingSubject teachersTeachingSubject = new QTeachersTeachingSubject("teachersTeachingSubject");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final QSchoolSubject schoolSubject;

    public final QTeacher teacher;

    public QTeachersTeachingSubject(String variable) {
        this(TeachersTeachingSubject.class, forVariable(variable), INITS);
    }

    public QTeachersTeachingSubject(Path<? extends TeachersTeachingSubject> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeachersTeachingSubject(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeachersTeachingSubject(PathMetadata metadata, PathInits inits) {
        this(TeachersTeachingSubject.class, metadata, inits);
    }

    public QTeachersTeachingSubject(Class<? extends TeachersTeachingSubject> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.schoolSubject = inits.isInitialized("schoolSubject") ? new QSchoolSubject(forProperty("schoolSubject")) : null;
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher"), inits.get("teacher")) : null;
    }

}

