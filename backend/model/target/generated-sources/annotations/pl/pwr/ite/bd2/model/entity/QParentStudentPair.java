package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParentStudentPair is a Querydsl query type for ParentStudentPair
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QParentStudentPair extends EntityPathBase<ParentStudentPair> {

    private static final long serialVersionUID = -1222078228L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParentStudentPair parentStudentPair = new QParentStudentPair("parentStudentPair");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final QParent parent;

    public final QStudent student;

    public QParentStudentPair(String variable) {
        this(ParentStudentPair.class, forVariable(variable), INITS);
    }

    public QParentStudentPair(Path<? extends ParentStudentPair> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QParentStudentPair(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QParentStudentPair(PathMetadata metadata, PathInits inits) {
        this(ParentStudentPair.class, metadata, inits);
    }

    public QParentStudentPair(Class<? extends ParentStudentPair> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QParent(forProperty("parent"), inits.get("parent")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

