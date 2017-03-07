package controllers;
import controllers.secure.BetClicSecure;
import models.User;
import play.data.validation.Valid;
import play.data.validation.Validation;
import services.UserService;

/**
 * Created by choural1 on 03/03/17.
 */
public class InscriptionController extends LoggedController {

    public static void inscription(){

        if(getConnectedUser()==null){
            render();
        }else{
            Application.index();
        }
    }

    public static void creerUser(@Valid User user) {

        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            inscription();
        }

        UserService.INSTANCE.save(user);

        try {
            BetClicSecure.authenticate(user.email,user.password,true);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
