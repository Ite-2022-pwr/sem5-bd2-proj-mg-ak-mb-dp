package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pwr.ite.bd2.model.enums.UserType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`Users`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class User extends EntityBase {

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @Column(length = 64, name = "PasswordHash")
    private String passwordHash;

    @Column(name = "Login", length = 45)
    private String login;

    @Column(nullable = false, length = 45, name = "FirstName")
    private String firstName;

    @Column(nullable = false, length = 45, name = "SecondName")
    private String secondName;

    @Column(nullable = false, length = 45, name = "Surname")
    private String surname;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdAddress")
    private Address address;

    @OneToMany(mappedBy = "sender")
    private Set<Message> messages = new HashSet<>();

    @OneToMany(mappedBy = "receiver")
    private Set<MessageUserReceiverPair> messageUserReceiverPairs = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Parent parent;

    @OneToOne(mappedBy = "user")
    private Student student;

    @OneToOne(mappedBy = "user")
    private Teacher teacher;
}
