package models;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class UserContact extends Model {
    @Required
    @Email
    @Column(nullable = false)
    public String email;
    @Required
    @Column(nullable = false)
    public String lastname;
    @Required
    @Column(nullable = false)
    public String firstname;
    @Required
    @Column(nullable = false)
    public String message;
}
