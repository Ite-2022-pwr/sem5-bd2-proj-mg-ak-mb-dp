package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`SchoolSubjects`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class SchoolSubject extends EntityBase {

    @Column(nullable = false, length = 45, name = "Name")
    private String name;

    @Column(nullable = false, name = "SchoolYear")
    private LocalDateTime schoolYear;

    @Column(nullable = false, length = 100, name = "LinkToSubjectProgram")
    private String linkToSubjectProgram;

    @OneToMany(mappedBy = "schoolSubject")
    private Set<Lesson> lessons = new HashSet<>();

    @OneToMany(mappedBy = "schoolSubject")
    private Set<TeachersTeachingSubject> teachersTeachingSubjects = new HashSet<>();

    @OneToMany(mappedBy = "schoolSubject")
    private Set<Grade> grades = new HashSet<>();
}
