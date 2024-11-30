package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pwr.ite.bd2.model.enums.PresenceType;

@Entity
@Table(name = "`Presences`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Presence extends EntityBase {

    @Column(nullable = false, length = 50, name = "PresenceType")
    @Enumerated(EnumType.STRING)
    private PresenceType type;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdStudent")
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdLesson")
    private Lesson lesson;
}
