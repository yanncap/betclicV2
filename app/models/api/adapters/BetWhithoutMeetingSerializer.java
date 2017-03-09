package models.api.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import models.Bet;

import java.lang.reflect.Type;

/**
 * Created by formation on 09/03/17.
 */
public class BetWhithoutMeetingSerializer implements JsonSerializer<Bet>{

    private static BetWhithoutMeetingSerializer instance;

    private BetWhithoutMeetingSerializer(){

    }

    public static BetWhithoutMeetingSerializer getInstance(){
        if(instance == null){
            instance = new BetWhithoutMeetingSerializer();
        }
        return instance;
    }

    @Override
    public JsonElement serialize(Bet bet, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        json.addProperty("name", bet.name);
        json.addProperty("status", String.valueOf(bet.status));
        json.addProperty("name", bet.name);
        json.add("betType", jsonSerializationContext.serialize(bet.betType));
        json.add("cotes", jsonSerializationContext.serialize(bet.cotes));
        return json;
    }
}
