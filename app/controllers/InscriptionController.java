package controllers;

import models.User;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by choural1 on 03/03/17.
 */
public class InscriptionController extends Controller {

    public static void inscription(){
        render();
    }

    public static void creerUser(@Valid User user) {
        System.out.println(user.email);
        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            editUser(null);
        }

        user.save();
        users();
    }

    public static void editUser(Long id) {
        User user = null;
        if(id != null) {
            user = User.findById(id);
        }
        render(user);
    }

    private static void users() {
            List<User> users = User.find("isSupprime = false").fetch();
            List<User> usersSupprimes = User.find("isSupprime = true").fetch();
            render(users, usersSupprimes);
        }
    }

}
