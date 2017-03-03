package models;

import play.data.validation.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class BetResult {
    @Required
    @Enumerated
    @Column(nullable = false)
    public StatusResult status;
    @Required
    @Column(nullable = false)
    public BigDecimal montant;
}
