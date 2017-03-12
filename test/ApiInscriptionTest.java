import models.User;
import org.junit.Test;
import play.mvc.Http;
import play.test.FunctionalTest;

import java.math.BigDecimal;

/**
 * Created by choural1 on 09/03/17.
 */
public class ApiInscriptionTest  extends FunctionalTest {

    @Test
    public void singUp_work(){
        //Given
        User user = new User();

        String firstname = "boulard";
        String lastname = "luke";
        String email = "name@domain.com";
        String password = "mypassword";
        BigDecimal solde = new  BigDecimal(100);

        String birthDate = "17/10/1985";

        //when
        Http.Response response = POST("/api/user/signup?user.firstname="+firstname+"&user.lastname="+lastname+"" +
                "&user.email="+email+"&user.password="+password+"&user.birthDate="+birthDate+"&user.solde="+solde);

        //THEN
        assertStatus(201, response);
    }
}
