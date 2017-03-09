import org.joda.time.DateTime;
import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class teoTest extends UnitTest {
    //TODO : Tester un pari negatif
    @Test
    public void testPariNegatif(){
        //Given
        Long pari = -1L;
        //When
        // POST /bet
        //Then
        // error 409
    }

    //TODO : Tester un pari 0 euros
    public void testPariNull(){
        //Given
        Long pari = 0L;
        //When
        // POST /bet
        //Then
        // error 409
    }

    //TODO : Tester une date de naissance du futur (01/01/2020)
    public void testMartiMcFly(){
        //Given
        // Date uneDate = 01/01/2020;
        //When
        // POST /inscription
        //Then
        // error 409
    }

    //TODO : injection sql formulaire contact et inscription
    public void testInjection(){
        //Given
        String inject = "SELECT * FROM user";
        //When
        // POST /inscription
        //Then
        // error 404
    }

    //TODO : test un nom de plus de 50 caractere
    @Test
    public void testTropLong(){
        //Given
        String unNomTropLong= "blablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla";
        //When
        // POST /inscription
        //Then
        // error 409
    }

    //TODO : test un password infireiur a 7 caractere
    @Test
    public void testPWDTropCourt(){
        //Given
        String pwd = "a";
        //When
        // POST /inscription
        //Then
        // error 409
    }

    //TODO : tester un nom / prenom avec que des chiffre
    @Test
    public void testNomEronee(){
        //Given
        String nomIncorrect = "000";
        //When
        // POST /bet
        //Then
        // error 409
    }

    //TODO : tester un pari
    @Test
    public void testPari(){
        //Given
        Long pari = 1L;
        //When
        // POST /bet
        //Then
        // message: 200
    }
    //TODO : test un message du contact avec uniquement des espaces
    @Test
    public void testFauxMessage(){
        //Given
        String faux = " ";
        //When
        // POST /contact
        //Then
        // error 409
    }
    //TODO : test un message du contact de moins de 10 caractere
    @Test
    public void testMessageTropCourt(){
        //Given
        String court = "court";
        //When
        // POST /contact
        //Then
        // error 409
    }
    //TODO : tester que un numero de telephone a bien que des chiffre et fait moins de 16 caractere et plus de 6
    @Test
    public void testTelephone(){
        //Given
        String fauxNumero = "l02020202m";
        //When
        // POST /inscription
        //Then
        // error 409
    }
}