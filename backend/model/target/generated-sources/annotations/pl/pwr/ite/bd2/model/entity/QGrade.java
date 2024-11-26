package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGrade is a Querydsl query type for Grade
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGrade extends EntityPathBase<Grade> {

    private static final long serialVersionUID = -1607158376L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGrade grade = new QGrade("grade");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final StringPath description = createString("description");

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final NumberPath<Integer> numberGrade = createNumber("numberGrade", Integer.class);

    public final QSchoolSubject schoolSubject;

    public final QStudent student;

    public final QTeacher teacher;

    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    public QGrade(String variable) {
        this(Grade.class, forVariable(variable), INITS);
    }

    public QGrade(Path<? extends Grade> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGrade(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGrade(PathMetadata metadata, PathInits inits) {
        this(Grade.class, metadata, inits);
    }

    public QGrade(Class<? extends Grade> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.schoolSubject = inits.isInitialized("schoolSubject") ? new QSchoolSubject(forProperty("schoolSubject")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
        this.teacher = inits.isInitialized("teacher") ? new QTeacher(forProperty("teacher"), inits.get("teacher")) : null;
    }

}

