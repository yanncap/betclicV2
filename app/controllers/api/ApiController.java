package controllers.api;

import com.google.gson.JsonObject;
import controllers.LoggedController;
import controllers.api.result.NoContent;
import controllers.api.result.NotFound;
import models.api.adapters.MeetingSerializer;
import play.data.validation.Error;
import play.mvc.results.RenderJson;

import java.util.List;

public class ApiController extends LoggedController {

    protected static void apiNoContent() {
        throw new NoContent();
    }

    protected static void apiCreated(Object object) {
        response.status = 201;
        throw new RenderJson(object, MeetingSerializer.getInstance());
    }

    protected static void apiNotFound(String message) {
        throw new NotFound(message);
    }

    protected static void apiNotFoundIfNull(Object object, String message) {
        if (object == null) {
            apiNotFound(message);
        }
    }

    protected static void apiMetierErrors(String message) {
        JsonObject json = new JsonObject();
        json.addProperty("code", "MetierErrors");
        json.addProperty("message", message);
        response.status = 409;
        throw new RenderJson(json);
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
