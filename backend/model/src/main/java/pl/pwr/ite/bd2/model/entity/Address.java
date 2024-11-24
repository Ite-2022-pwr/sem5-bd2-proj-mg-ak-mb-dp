package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Address extends EntityBase {

    @Column(length = 45, name = "Street")
    private String street;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdPostCode")
    private PostCode postCode;

    @Column(length = 6, name = "BuildingNumber")
    private String buildingNumber;

    @Column(length = 6, name = "ApartmentNumber")
    private String apartmentNumber;

    @OneToMany(mappedBy = "address")
    private Set<User> users = new HashSet<>();
}
