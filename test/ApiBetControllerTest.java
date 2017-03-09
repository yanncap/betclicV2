import models.Meeting;
import org.junit.Test;
import play.mvc.Http;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static play.test.FunctionalTest.GET;
import static play.test.FunctionalTest.renderArgs;

/**
 * Created by formation on 09/03/17.
 */
public class ApiBetControllerTest {

    @Test
    public void voidtestBetsIsFoundAndPasseToWiew(){
        //GIVEN
        Http.Response response = GET("/api/bets");
        //WHEN
        //THEN
        assertThat(renderArgs("meetings"), is(notNullValue()));
        //List<Meeting> meetings = (Meeting)renderArgs("")
    }


}
