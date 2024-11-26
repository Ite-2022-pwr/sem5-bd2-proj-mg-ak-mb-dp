package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "`PhoneNumbersParentsMatches`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PhoneNumbersParentsMatch extends EntityBase {

    @Column(nullable = false, length = 200, name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdParent")
    private Parent parent;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdPhoneNumber")
    private PhoneNumber phoneNumber;
}
