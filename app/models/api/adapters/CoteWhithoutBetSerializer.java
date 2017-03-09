package models.api.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import models.Bet;
import models.Cote;

import java.lang.reflect.Type;

/**
 * Created by formation on 09/03/17.
 */
public class CoteWhithoutBetSerializer implements JsonSerializer<Cote>{

    private static CoteWhithoutBetSerializer instance;

    private CoteWhithoutBetSerializer(){

    }

    public static CoteWhithoutBetSerializer getInstance(){
        if(instance == null){
            instance = new CoteWhithoutBetSerializer();
        }
        return instance;
    }

    @Override
    public JsonElement serialize(Cote cote, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        json.addProperty("name", cote.name);
        json.addProperty("cote", cote.cote);

        return json;
    }
}
