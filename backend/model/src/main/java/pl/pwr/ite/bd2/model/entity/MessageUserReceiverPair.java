package pl.pwr.ite.bd2.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "`MessageUserReceiverPairs`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class MessageUserReceiverPair extends EntityBase {

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdUserReceiver")
    private User receiver;

    @ManyToOne
    @JoinColumn(nullable = false, name = "IdMessage")
    private Message message;
}
