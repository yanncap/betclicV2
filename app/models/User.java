package models;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class User {
    @Required
    @Email
    @Column(unique = true, nullable = false)
    public String email;

    @Required
    @Password
    @Column(nullable = false)
    public String password;

    @Required
    @Column(nullable = false)
    public String lastname;

    @Required
    @Column(nullable = false)
    public String firstname;
}
