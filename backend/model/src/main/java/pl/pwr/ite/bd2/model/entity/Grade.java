package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.security.auth.Subject;
import java.time.LocalDateTime;

@Entity
@Table(name = "`Grades`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Grade extends EntityBase {

    @Column(nullable = false, name = "NumberGrade")
    private Integer numberGrade;

    @Column(nullable = false, length = 45, name = "Description")
    private String description;

    @Column(nullable = false, name = "Date")
    private LocalDateTime date;

    @Column(nullable = false, name = "Weight")
    private Integer weight;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdStudent")
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdSubject")
    private SchoolSubject schoolSubject;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdTeacher")
    private Teacher teacher;

}
