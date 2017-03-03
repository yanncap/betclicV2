package controllers;

import com.google.gson.JsonObject;
import play.data.validation.Email;
import play.data.validation.Error;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.Controller;
import play.mvc.results.RenderJson;

import java.util.List;

/**
 * Created by choural1 on 03/03/17.
 */
public class ContactController  extends Controller{

    public static void empty (){
        render();
    }

    public static void contact( @Required @Email String email,
                                @Required String lastname,
                                @Required String firstname,
                                @Required String message){
        if (Validation.hasErrors()) {
            apiValidationErrors(Validation.errors());
        }
        render();
    }

    protected static void apiValidationErrors(List<Error> errors) {
        JsonObject json = new JsonObject();
        json.addProperty("code", "ValidationErrors");
        JsonObject jsonErrors = new JsonObject();
        for (Error error : errors) {
            jsonErrors.addProperty(error.getKey(), error.getMessageKey());
        }
        json.add("errors", jsonErrors);
        response.status = 409;
        throw new RenderJson(json);
    }

}


