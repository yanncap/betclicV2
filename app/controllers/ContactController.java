package controllers;

import controllers.secure.BetClicSecure;
import models.User;
import models.UserContact;
import play.data.validation.Validation;
import play.mvc.Controller;
import services.UserContactService;

import javax.validation.Valid;

/**
 * Created by choural1 on 03/03/17.
 */
public class ContactController  extends LoggedController{

    public static void contact (){
        if(getConnectedUser()!=null){
            User user = getConnectedUser();
            UserContact userContact = new UserContact();
            userContact.firstname = user.firstname;
            userContact.lastname = user.lastname;
            userContact.email = user.email;

        render(userContact);
    }
    else{
            render();
        }
    }

//    public static void validationFormulaireContact(@Valid UserContact user){
//        if (Validation.hasErrors()) {
//            saveUserContact(Validation.errors());
//        }
////        redirect("index.html");
//        ContactController.contact();
//    }


    public static void saveUserContact(@Valid UserContact userContact) {

        if (Validation.hasErrors()) {
            params.flash();
            Validation.keep();
            contact();
        }
        UserContactService.INSTANCE.save(userContact);
        Application.index();

    }


//    protected static void apiValidationErrors(List<Error> errors) {
//        JsonObject json = new JsonObject();
//        json.addProperty("code", "ValidationErrors");
//        JsonObject jsonErrors = new JsonObject();
//        for (Error error : errors) {
//            jsonErrors.addProperty(error.getKey(), error.getMessageKey());
//        }
//        json.add("errors", jsonErrors);
//        response.status = 409;
//        throw new RenderJson(json);
//    }

}


