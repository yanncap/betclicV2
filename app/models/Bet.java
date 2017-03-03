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
    @Enumerated
    public Status status;
    @OneToMany
    public List<Cote> cotes;
    @ManyToOne
    public Cote coteWin;
    @OneToMany
    public List<DoBet> doBets;


}
