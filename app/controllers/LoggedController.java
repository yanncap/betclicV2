package controllers;

import controllers.secure.BetClicSecure;
import models.User;
import play.Logger;
import play.mvc.After;
import play.mvc.Before;
import play.mvc.Controller;

public class LoggedController extends Controller {

    @Before
    private void before() {
        Logger.info(request.url);
        if (BetClicSecure.Security.isConnected()) {
            User user = User.find("byEmail", Secure.Security.connected()).first();
            renderArgs.put("connectedUser", user);
        }
    }

    @After
    private void after() {
        Logger.debug("fin de la request");
    }

}
