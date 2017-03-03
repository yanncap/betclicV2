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
public class AproposController extends Controller {

    public static void apropos(){
        render();
    }
}

