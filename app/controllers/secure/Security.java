package controllers.secure;

import controllers.Application;
import models.User;

public class Security extends BetClicSecure.Security {

   static boolean authenticate(String email , String password) {
        User user = User.find("byEmail", email).first();
        return user != null && user.password.equals(password);
    }

    static void onDisconnected() {
        Application.index();
    }

}
