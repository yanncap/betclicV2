package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class Bet extends Model{
    @Required
    @Column(nullable = false)
    public String name;
    @Required
    @Enumerated(EnumType.STRING)
    public Status status;
    @ManyToOne
    @JoinColumn(name = "betTypeId")
    public BetType betType;
    @ManyToOne
    @JoinColumn(name = "meetingId")
    public Meeting meeting;
    @OneToMany
    @JoinColumn(name = "betId")
    public List<Cote> cotes;
    @ManyToOne
    public Cote coteWin;
    @OneToMany
    @JoinColumn(name = "betId")
    public List<DoBet> doBets;

}
