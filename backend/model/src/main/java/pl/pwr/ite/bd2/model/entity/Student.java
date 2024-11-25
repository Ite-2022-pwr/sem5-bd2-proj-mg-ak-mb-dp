package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pwr.ite.bd2.model.enums.Gender;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`Students`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Student extends EntityBase {

    @Column(nullable = false, name = "DateOfBirth")
    private LocalDateTime dateOfBirth;

    @Column(nullable = false, name = "Age")
    private Integer age;

    @Column(nullable = false, name = "Gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    @JoinColumn(nullable = false, name = "IdUser")
    private User user;

    @OneToMany(mappedBy = "student")
    private Set<ParentStudentPair> parentStudentPairs = new HashSet<>();

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdClass")
    private SchoolClass studentClass;

    @OneToMany(mappedBy = "student")
    private Set<Presence> presences = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<Grade> grades = new HashSet<>();
}
