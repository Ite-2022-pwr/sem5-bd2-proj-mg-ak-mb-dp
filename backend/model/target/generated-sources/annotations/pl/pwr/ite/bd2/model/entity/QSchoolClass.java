package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchoolClass is a Querydsl query type for SchoolClass
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchoolClass extends EntityPathBase<SchoolClass> {

    private static final long serialVersionUID = -705738907L;

    public static final QSchoolClass schoolClass = new QSchoolClass("schoolClass");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final StringPath name = createString("name");

    public final SetPath<Student, QStudent> students = this.<Student, QStudent>createSet("students", Student.class, QStudent.class, PathInits.DIRECT2);

    public final NumberPath<Integer> yearOfStudy = createNumber("yearOfStudy", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> yearStarted = createDateTime("yearStarted", java.time.LocalDateTime.class);

    public QSchoolClass(String variable) {
        super(SchoolClass.class, forVariable(variable));
    }

    public QSchoolClass(Path<? extends SchoolClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchoolClass(PathMetadata metadata) {
        super(SchoolClass.class, metadata);
    }

}

