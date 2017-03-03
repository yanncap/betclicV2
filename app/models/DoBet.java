package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class DoBet {

    @ManyToOne
    public  User user;
    @ManyToOne
    public Cote cote;
    @Column(nullable = false)
    public BigDecimal montant;
    @ManyToOne
    public BetResult  result ;


}
