package models;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class Cote extends Model{

    @Required
    @Column(nullable = false)
    public String name;
    @Required
    @Min(0.1)
    @Column(nullable = false)
    public double cote;


}
