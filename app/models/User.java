package models;

import org.joda.time.DateTime;
import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
@Entity
public class User  extends Model{
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

    @Required
    @Column(nullable = false)
    public Date birthDate;

    @OneToMany(mappedBy = "user")
    public List<DoBet> doBets;

    public BigDecimal solde;

    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserTransfert getUserTransfert() {
        return new UserTransfert(this.token);
    }

    class UserTransfert {

        public String token;

        public UserTransfert(String token) {
            this.token = token;
        }
    }
}
