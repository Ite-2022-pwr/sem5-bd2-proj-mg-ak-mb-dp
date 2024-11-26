package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = -450098244L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

    public final QEntityBase _super = new QEntityBase(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final DateTimePath<java.time.LocalDateTime> dateOfBirth = createDateTime("dateOfBirth", java.time.LocalDateTime.class);

    public final EnumPath<pl.pwr.ite.bd2.model.enums.Gender> gender = createEnum("gender", pl.pwr.ite.bd2.model.enums.Gender.class);

    public final SetPath<Grade, QGrade> grades = this.<Grade, QGrade>createSet("grades", Grade.class, QGrade.class, PathInits.DIRECT2);

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final SetPath<ParentStudentPair, QParentStudentPair> parentStudentPairs = this.<ParentStudentPair, QParentStudentPair>createSet("parentStudentPairs", ParentStudentPair.class, QParentStudentPair.class, PathInits.DIRECT2);

    public final SetPath<Presence, QPresence> presences = this.<Presence, QPresence>createSet("presences", Presence.class, QPresence.class, PathInits.DIRECT2);

    public final QSchoolClass studentClass;

    public final QUser user;

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.studentClass = inits.isInitialized("studentClass") ? new QSchoolClass(forProperty("studentClass")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

