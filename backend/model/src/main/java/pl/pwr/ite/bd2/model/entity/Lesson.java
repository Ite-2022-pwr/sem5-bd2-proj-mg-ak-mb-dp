package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`Lessons`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Lesson extends EntityBase {

    @Column(nullable = false, length = 50, name = "Topic")
    private String topic;

    @Column(nullable = false, name = "DateTimeStart")
    private LocalDateTime dateTimeStart;

    @Column(nullable = false, name = "DateTimeEnd")
    private LocalDateTime dateTimeEnd;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdClass")
    private SchoolClass studentClass;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdTeacher")
    private Teacher teacher;

    @OneToMany(mappedBy = "lesson")
    private Set<Presence> presences = new HashSet<>();

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdSchoolSubject")
    private SchoolSubject schoolSubject;

}
