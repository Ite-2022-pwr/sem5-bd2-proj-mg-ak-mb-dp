package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pwr.ite.bd2.model.enums.ParentRole;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`Parents`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Parent extends EntityBase {

    @OneToOne
    @JoinColumn(nullable = false, name = "IdUser")
    private User user;

    @Column(nullable = false, name = "ParentRole")
    @Enumerated(EnumType.STRING)
    private ParentRole parentRole;

    @OneToMany(mappedBy = "parent")
    private Set<PhoneNumbersParentsMatch> phoneNumbersParentsMatches = new HashSet<>();

    @OneToMany(mappedBy = "parent")
    private  Set<ParentStudentPair> parentStudentPairs = new HashSet<>();
}
