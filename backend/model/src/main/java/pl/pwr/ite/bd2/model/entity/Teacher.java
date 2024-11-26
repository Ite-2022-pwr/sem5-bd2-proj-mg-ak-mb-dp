package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`Teachers`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Teacher extends EntityBase {

    @Column(nullable = false, name = "LastCOCRDate")
    private LocalDate lastCOCRDate;

    @Column(nullable = false, name = "OneLeave")
    private Boolean oneLeave;

    @OneToOne
    @JoinColumn(nullable = false, name = "IdUser")
    private User user;

    @OneToMany(mappedBy = "teacher")
    private Set<Lesson> lessons = new HashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<TeachersTeachingSubject> teachersTeachingSubjects = new HashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<Grade> grades = new HashSet<>();
}
