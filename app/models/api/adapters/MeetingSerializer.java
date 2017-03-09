package models.api.adapters;

import com.google.gson.*;
import models.Meeting;

import java.lang.reflect.Type;

/**
 * Created by formation on 09/03/17.
 */
public class MeetingSerializer implements JsonSerializer<Meeting> {
    private static MeetingSerializer instance;
    private MeetingSerializer(){

    }

    public static MeetingSerializer getInstance(){
        if(instance == null){
            instance = new MeetingSerializer();
        }
        return instance;
    }

    @Override
    public JsonElement serialize(Meeting meeting, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        json.addProperty("name", meeting.name);
        json.addProperty("date", String.valueOf(meeting.date));
        json.addProperty("satus", String.valueOf(meeting.status));
        //json.addProperty("bets", String.valueOf(meeting.bets));

        return json;
    }
}
