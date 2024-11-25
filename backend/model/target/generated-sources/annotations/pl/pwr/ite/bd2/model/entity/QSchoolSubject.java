package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchoolSubject is a Querydsl query type for SchoolSubject
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchoolSubject extends EntityPathBase<SchoolSubject> {

    private static final long serialVersionUID = 1963207641L;

    public static final QSchoolSubject schoolSubject = new QSchoolSubject("schoolSubject");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    public final SetPath<Grade, QGrade> grades = this.<Grade, QGrade>createSet("grades", Grade.class, QGrade.class, PathInits.DIRECT2);

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    public final SetPath<Lesson, QLesson> lessons = this.<Lesson, QLesson>createSet("lessons", Lesson.class, QLesson.class, PathInits.DIRECT2);

    public final StringPath linkToSubjectProgram = createString("linkToSubjectProgram");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> schoolYear = createDateTime("schoolYear", java.time.LocalDateTime.class);

    public final SetPath<TeachersTeachingSubject, QTeachersTeachingSubject> teachersTeachingSubjects = this.<TeachersTeachingSubject, QTeachersTeachingSubject>createSet("teachersTeachingSubjects", TeachersTeachingSubject.class, QTeachersTeachingSubject.class, PathInits.DIRECT2);

    public QSchoolSubject(String variable) {
        super(SchoolSubject.class, forVariable(variable));
    }

    public QSchoolSubject(Path<? extends SchoolSubject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchoolSubject(PathMetadata metadata) {
        super(SchoolSubject.class, metadata);
    }

}

