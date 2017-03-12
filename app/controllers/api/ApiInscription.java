package controllers.api;

import models.User;
import models.api.adapters.UserSerializer;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.results.RenderJson;
import services.UserService;

/**
 * Created by choural1 on 09/03/17.
 */
public class ApiInscription extends ApiBetController {

    public static void signUp(@Valid User user) {
        if(Validation.hasErrors()) {
            apiValidationErrors(Validation.errors());
        }

        User existingUser = User.find("email = ?1", user.email).first();
        if (existingUser != null) {
            apiMetierErrors("L'utilisateur existe déjà");
        } else {
            UserService.INSTANCE.save(user);
             apiUserCreated(user);
        }
    }

    private static void apiUserCreated(User user) {
        response.status = 201;
        throw new RenderJson(user, UserSerializer.get());
    }
}
