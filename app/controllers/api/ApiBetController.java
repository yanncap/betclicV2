package controllers.api;

import models.*;
import play.data.validation.Required;
import play.data.validation.Validation;
import services.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by formation on 07/03/17.
 */
public class ApiBetController extends ApiController {

    public static void bets(){
        List<Meeting> meetings = null;
        try {
            meetings = MeetingService.INSTANCE.getTopTenMeetings();
        } catch (Exception e) {
            e.printStackTrace();
        }

        renderJSON(meetings);
    }

    public static void result(@Required Long coteWinId, @Required Long betId, @Required Long doBetId, @Required String email){
        if(Validation.hasErrors()){
            apiValidationErrors(Validation.errors());
        }
        Cote cote = CoteService.INSTANCE.get(coteWinId);
        Bet bet = BetService.INSTANCE.get(betId);
        User user = UserService.INSTANCE.find(email);
        DoBet doBet = DoBetService.INSTANCE.get(doBetId);
        apiNotFoundIfNull(cote, "La cote d'id " + coteWinId + "n'existe pas");
        apiNotFoundIfNull(cote, "Le paris d'id " + betId+ "n'existe pas");
        apiNotFoundIfNull(cote, "L'utilisateur de mail " + email + "n'existe pas");
        apiNotFoundIfNull(cote, "La mise d'id " + doBetId + "n'existe pas");



        bet.coteWin = cote;
        BetService.INSTANCE.update(bet);

        BetResult br = new BetResult();

        if(doBet.cote.id == cote.id){
            br.status = StatusResult.WIN;
            br.montant = doBet.montant.multiply(BigDecimal.valueOf(cote.cote));
        }
        else{
            br.status = StatusResult.LOSE;
            br.montant = BigDecimal.valueOf(0);
        }

        BetResultService.INSTANCE.save(br);
        //TODO: faire retourner le betResult persisté ou faire un find
        doBet.result = br;
        DoBetService.INSTANCE.save(doBet);

        for (DoBet db: user.doBets) {
            if(db.id == doBet.id && db.result.status == StatusResult.WIN){
                user.solde.add(db.montant);
            }
        }

        renderJSON(user);

    }
}
