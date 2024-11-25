package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "`TeachersTeachingSubjects`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class TeachersTeachingSubject extends EntityBase {

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdTacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdSchoolSubject")
    private SchoolSubject schoolSubject;

}
