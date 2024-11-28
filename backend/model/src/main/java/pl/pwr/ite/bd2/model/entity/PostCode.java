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
@Table(name = "PostCodes")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PostCode extends EntityBase {

    @Column(length = 8, name = "PostCode")
    private String postCode;

    @Column(length = 58, name = "RegionName")
    private String regionName;

    @OneToMany(mappedBy = "postCode")
    private Set<Address> addresses = new HashSet<>();
}
