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
@Table(name = "`Classes`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class SchoolClass extends EntityBase {

    @OneToMany(mappedBy = "studentClass")
    private Set<Student> students = new HashSet<>();

    @Column(nullable = false, length = 3, name = "Name")
    private String name;

    @Column(nullable = false, name = "YearOfStudy")
    private Integer yearOfStudy;

    @Column(nullable = false, name = "YearStarted")
    private LocalDateTime yearStarted;

    @OneToMany(mappedBy = "studentClass")
    private Set<Student> student = new HashSet<>();
}
