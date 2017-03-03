package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class Meeting extends Model {
    @Required
    @Column(nullable = false)
    public String name ;
    @Required
    @Column(nullable = false)
    public Date date;
    @Required
    @Enumerated
    @Column(nullable = false)
    public Status status;
    @OneToMany
    public List<Bet> bet ;


}
