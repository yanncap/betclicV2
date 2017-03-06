package controllers;

import controllers.secure.BetClicSecure;
import models.User;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;
import services.UserService;

import java.util.List;

import static controllers.secure.BetClicSecure.authenticate;


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

    public static void creerUser( User user) {

        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            editUser(null);
        }

        //user.save();
        UserService.INSTANCE.save(user);

        try {
            BetClicSecure.authenticate(user.email,user.password,true);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public static void editUser(Long id) {
        User user = null;
        if(id != null) {
            //user = User.findById(id);
            UserService.INSTANCE.get(id);
        }
        render(user);
    }

//    private static void users() {
//            List<User> users = User.find("isSupprime = false").fetch();
//            List<User> usersSupprimes = User.find("isSupprime = true").fetch();
//            render(users, usersSupprimes);
//        }

}
