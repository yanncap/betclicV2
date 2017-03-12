import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
    public void signIn_notValidEmail() {
        String email = "coucou";
        String password ="pwd";
        Http.Response  response = POST("/api/login?email="+email+"&password="+password);
       // assertStatus(404,response);
        JsonObject jsonObject = new Gson().fromJson(response.out.toString(),JsonObject.class);
        assertEquals("validation.email",jsonObject.getAsJsonObject("errors").get("email").getAsString());

    }
    @Test
    public void signIn_notValidFields() {
        String email = "fauxMail@domain.fr";
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
       /* ça marche aussi : String token = new Gson().fromJson(response.out.toString(),String.class);*/
        System.out.println("token| : "+token);
        assertNotNull(token);
    }

}


