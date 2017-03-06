package controllers;

import controllers.secure.BetClicSecure;
import models.User;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.List;

import static controllers.secure.BetClicSecure.authenticate;


/**
 * Created by choural1 on 03/03/17.
 */
public class InscriptionController extends LoggedController {

    public static void inscription(){
        render();
    }

    public static void creerUser(@Valid User user) {

        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            editUser(null);
        }

        user.save();

        try {
            BetClicSecure.authenticate(user.email,user.password,true);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    public static void editUser(Long id) {
        User user = null;
        if(id != null) {
            user = User.findById(id);
        }
        render(user);
    }

//    private static void users() {
//            List<User> users = User.find("isSupprime = false").fetch();
//            List<User> usersSupprimes = User.find("isSupprime = true").fetch();
//            render(users, usersSupprimes);
//        }

}
