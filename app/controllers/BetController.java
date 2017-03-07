package controllers;

import exception.ObjectCreationException;
import models.Cote;
import models.DoBet;
import models.Meeting;
import models.User;
import play.Logger;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.data.validation.Validation;
import play.mvc.Controller;
import services.CoteService;
import services.DoBetService;
import services.MeetingService;
import services.UserService;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by choural1 on 03/03/17.
 */
public class BetController extends LoggedController {

    public static final String LOGGING = "BetController |";

    public static void bet(){
        List<Meeting> meetings = null;
        try {
            meetings = MeetingService.INSTANCE.getTopTenMeetings();
        } catch (Exception e) {
            e.printStackTrace();
        }

        render(meetings);
    }

    public static void doBet(@Required Long coteId, @Required double montant){
        Logger.info(LOGGING + " doBet id=[%s], montant=[%s]", coteId, montant);

        if(Validation.hasErrors()){
            params.flash();
            Validation.keep();
        }

        Cote cote = CoteService.INSTANCE.get(coteId);
        User user = getConnectedUser();

        try {
            DoBet doBet = DoBetService.INSTANCE.createDoBet(cote, user, BigDecimal.valueOf(montant));
            if(user.solde.compareTo(doBet.montant) >= 0){
                user.solde = user.solde.subtract(doBet.montant);
                Logger.info( "%s doBet user solde : [%s] user persistent? [%s]", LOGGING, user.solde,user.isPersistent());
                UserService.INSTANCE.update(user);
            }
        } catch (ObjectCreationException e) {
            render(e);
        }

        Application.index();
    }

    

}
