import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Meeting;
import models.User;
import org.junit.Test;
import play.mvc.Http;
import play.test.FunctionalTest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by schiff on 09/03/17.
 */
public class ApiSignInTest extends FunctionalTest {
    @Test
    public void signIn_emptyFields() {
        String email = "";
        String password ="pwd";
        Http.Response  response = POST("/api/login?email="+email+"&password="+password);
        assertStatus(409,response);
    }

    @Test
    public void signIn_validFields() {
        String email = "a@b.fr";
        String password ="pwd";
        Http.Response  response = POST("/api/login?email="+email+"&password="+password);
        assertStatus(200,response);
    }
    @Test
    public void signIn_notValidFields() {
        String email = "coucou";
        String password ="pwd";
        Http.Response  response = POST("/api/login?email="+email+"&password="+password);
        assertStatus(404,response);
    }

    @Test
    public void signIn_givenToken() {
        //GIVEN
        String email = "a@b.fr";
        String password ="pwd";
        //WHEN
        Http.Response  response = POST("/api/login?email="+email+"&password="+password);
        //THEN
        Type type = new TypeToken<String>(){}.getType();
        String token = new Gson().fromJson(response.out.toString(), type);
       /*String token = new Gson().fromJson(response.out.toString(),String.class);*/ /* ça marche aussi */
        System.out.println("token| : "+token);
        assertNotNull(token);
    }

}


