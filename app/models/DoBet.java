package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class DoBet extends Model {

    public Date doBetDate;
    @ManyToOne
    @JoinColumn(name = "userId")
    public  User user;
    @ManyToOne
    public Cote cote;
    @Column(nullable = false)
    public BigDecimal montant;
    @ManyToOne
    public BetResult  result;


}
