package models.api.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import models.User;

import java.lang.reflect.Type;

/**
 * Created by choural1 on 09/03/17.
 */

public class UserSerializer implements JsonSerializer<User> {


    private static UserSerializer instance;

    private UserSerializer(){
    }

    public static UserSerializer get(){
        if (instance == null) {
            instance = new UserSerializer();
        }
        return instance;
    }

    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        json.addProperty("firstname", user.firstname);
        json.addProperty("lastname", user.lastname);
        json.addProperty("email", user.email);
        json.addProperty("password",user.password);
        json.addProperty("solde",user.solde);
        json.addProperty("birthDate", String.valueOf(user.birthDate));
        return json;
    }
}
