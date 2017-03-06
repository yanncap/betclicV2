package controllers;

import models.User;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;

/**
 * Created by choural1 on 06/03/17.
 */
public class CompteController extends Controller{
    public static void compte (){
        render();
    }


    public static void creerCompteUser(@Valid User user) {
        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            editUser(null);
        }
        // TODO : regler probleme EXECUTION ERROR : occured : org.hibernate.exception.ConstraintViolationException: could not execute statement
        //user.save();
        compte();
    }

    public static void editUser(Long id) {
        User user = null;
        if(id != null) {
            user = User.findById(id);
        }
        render(user);
    }


}
