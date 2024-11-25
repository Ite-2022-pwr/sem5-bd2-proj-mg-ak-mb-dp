package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "`ParentStudentPairs`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class ParentStudentPair extends EntityBase {

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdStudent")
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdParent")
    private Parent parent;
}
