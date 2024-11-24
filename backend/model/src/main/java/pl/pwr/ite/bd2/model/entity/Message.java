package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`Messages`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Message extends EntityBase{

    @Column(nullable = false, columnDefinition = "character varying")
    private String content;

    @Column(nullable = false, name = "DateSent")
    private LocalDateTime dateSent;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdUserSender")
    private User sender;

    @OneToMany(mappedBy = "message")
    private Set<MessageUserReceiverPair> receivers = new HashSet<>();
}
