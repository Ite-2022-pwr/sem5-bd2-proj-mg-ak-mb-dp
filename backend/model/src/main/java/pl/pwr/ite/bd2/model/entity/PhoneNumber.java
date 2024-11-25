package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`PhoneNumbers`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PhoneNumber extends EntityBase {

    @Column(nullable = false, length = 20, name = "PhoneNumber")
    private String phoneNumber;

    @OneToMany(mappedBy = "phoneNumber")
    private Set<PhoneNumbersParentsMatch> phoneNumbersParentsMatchSet = new HashSet<>();
}
