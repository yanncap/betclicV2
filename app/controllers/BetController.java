package controllers;

import models.DoBet;
import models.Meeting;
import play.data.validation.Valid;
import play.mvc.Controller;
import services.MeetingService;

import java.util.List;


/**
 * Created by choural1 on 03/03/17.
 */
public class BetController extends LoggedController {
    public static void bet(){
        List<Meeting> meetings = null;
        try {
            meetings = MeetingService.INSTANCE.getTopTenMeetings();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(meetings == null || meetings.isEmpty()){
            //error
        }

        render(meetings);
    }

    public static void doBet(@Valid DoBet doBet){

    }

}
