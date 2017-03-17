package controllers.api;

import models.User;
import play.data.validation.Email;
import play.data.validation.Required;
import play.data.validation.Validation;
import services.UserService;

import java.util.UUID;

/**
 * Created by schiff on 09/03/17.
 */
public class ApiSignIn extends ApiController {

    public static void signIn(@Required @Email String email, @Required String password){

        if(Validation.hasErrors()) {
            apiValidationErrors(Validation.errors());
        }

        User existingUser = User.find("email = ?1 AND password=?2", email, password).first();

        if (existingUser != null) {

            if(existingUser.token==null){
                existingUser.token = UUID.randomUUID().toString();
            }
            UserService.INSTANCE.save(existingUser);

            renderJSON(existingUser.getUserTransfert());
        } else {
         apiNotFound("Erreur d'authentification");
        }
    }
}
