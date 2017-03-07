package controllers;

import models.User;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;
import services.UserService;

/**
 * Created by choural1 on 06/03/17.
 */
public class CompteController extends LoggedController{

    public static void compte (){

        if(getConnectedUser()==null){
            Application.index();
        }else{
            User user = getConnectedUser();
                    render(user);
        }

    }
//
//    public static void creerCompteUser(@Valid User user) {
//        if (Validation.hasErrors()) {
//            params.flash();
//            Validation.keep();
//            editUser(null);
//        }
//        // TODO : regler probleme EXECUTION ERROR : occured : org.hibernate.exception.ConstraintViolationException: could not execute statement
//        //user.save();
//        UserService.INSTANCE.save(user);
//        compte();
//    }


    public static void UpdateUser(@Valid User user){
        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            editUser(null);
        }
        UserService.INSTANCE.update(user);
        compte();
    }
    public static void editUser(Long id) {
        User user = null;
        if(id != null) {
            user  = UserService.INSTANCE.get(id);
            //user = User.findById(id);
        }
        if(user == null){
            Application.index();
        }
        render(user);
    }


}
