import com.google.gson.Gson;
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
        Http.Response response = GET("/api/bets");
        assertStatus(200, response);
    }

    @Test
    public void voidtestBetsIsNotNull(){
        //GIVEN
        //WHEN
        Http.Response response = GET("/api/bets");
        //THEN
        System.out.println(response.out);
        Type type = new TypeToken<ArrayList<Meeting>>(){}.getType();
        List<Meeting> meetings = new Gson().fromJson(response.out.toString(), type);
        assertEquals(2, meetings.size());
        assertEquals("paris-marseille", meetings.get(0).name);
        //assertThat(renderArgs("meetings"), is(notNullValue()));
    }

    @Test
    public void voidtestBetsIsPassedToWiew(){
        //GIVEN
        //WHEN
        Http.Response response = GET("/api/bets");
        //THEN
        List<Meeting> meetings = (List<Meeting>) renderArgs("bets");
        assertThat(meetings.get(0).name, is("paris-marseille"));
    }


}
