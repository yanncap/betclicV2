package controllers;

import models.Bet;
import play.mvc.Controller;
import services.BetService;

import java.util.List;


/**
 * Created by choural1 on 03/03/17.
 */
public class BetController extends Controller {
    public static void bet(){
        List<Bet> bets = BetService.INSTANCE.findAll();
        if(bets == null || bets.isEmpty()){
            //error
        }

        render(bets);
    }

}
