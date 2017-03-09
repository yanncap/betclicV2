import org.joda.time.DateTime;
import org.junit.Test;
import play.mvc.Http;
import play.test.FunctionalTest;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by choural1 on 09/03/17.
 */
public class ApiInscriptionTest  extends FunctionalTest {

    @Test
    public void singUp_work(){
        //Given
        String email = "aa@aaaaaa.com";
        String password = "aaa";
        String lastname ="aa";
        String firstname = "bb";
        Date birthDate = new DateTime().toDate();
        BigDecimal solde = new  BigDecimal(10);
        //when
        Http.Response response = POST("/api/user/signup?email="+email+"&password="+password+"&lastname="+ lastname+"&firstname="+firstname+"&birthDate="+birthDate+"&solde="+solde+" ");
        //THEN
        assertStatus(201, response);
    }
}
