import org.joda.time.DateTime;
import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        DateTime dt = DateTime.now();
        System.out.println(dt);
        dt.plus(10);
        System.out.println(dt);

        assertEquals(2, 1 + 1);
    }


}
