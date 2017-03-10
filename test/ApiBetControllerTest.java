import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import models.Meeting;
import org.junit.Test;
import play.mvc.Http;
import play.test.FunctionalTest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static play.test.FunctionalTest.GET;
import static play.test.FunctionalTest.assertStatus;
import static play.test.FunctionalTest.renderArgs;

/**
 * Created by formation on 09/03/17.
 */
public class ApiBetControllerTest extends FunctionalTest{

    @Test
    public void apiBetsTest(){
        Http.Response response = GET("/api/meetings");
        assertStatus(200, response);
    }

    @Test
    public void testBetsIsNotNull(){
        //GIVEN
        //WHEN
        Http.Response response = POST("/api/meetings");
        //THEN
        System.out.println(response.out);
        Type type = new TypeToken<ArrayList<Meeting>>(){}.getType();
        List<Meeting> meetings = new Gson().fromJson(response.out.toString(), type);
        System.out.println(response.out);

        assertNotNull(meetings);
    }

    @Test
    public void testBetsIsNotEmpty(){
        //GIVEN
        //WHEN
        Http.Response response = GET("/api/meetings");
        //THEN
        Type type = new TypeToken<ArrayList<Meeting>>(){}.getType();
        List<Meeting> meetings = new Gson().fromJson(response.out.toString(), type);
        assertEquals(2, meetings.size());
    }

    @Test
    public void testBetsWorks(){
        //GIVEN
        //WHEN
        Http.Response response = GET("/api/meetings");
        //THEN
        Type type = new TypeToken<ArrayList<Meeting>>(){}.getType();
        List<Meeting> meetings = new Gson().fromJson(response.out.toString(), type);

        assertEquals("paris-marseille", meetings.get(0).name);
    }


}
