package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by formation on 06/03/17.
 */
@Entity
public class BetType extends Model {
    @Required
    @Column(nullable = false)
    public String name;
}
