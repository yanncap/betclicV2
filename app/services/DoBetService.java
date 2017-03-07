package services;

import dao.CoteDAO;
import dao.DoBetDAO;
import exception.ObjectCreationException;
import models.Cote;
import models.DoBet;
import models.User;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum DoBetService {

    INSTANCE;

    public List<DoBet> findAll(){

        return DoBetDAO.INSTANCE.findAll();
    }

    public DoBet get(Long id){
        return DoBetDAO.INSTANCE.get(id);
    }

    public void save(DoBet doBet){
        DoBetDAO.INSTANCE.save(doBet);
    }

    public void delete(Long id){
        DoBetDAO.INSTANCE.delete(id);
    }

    public DoBet createDoBet(Cote cote, User user, BigDecimal montant) throws ObjectCreationException {
        if(cote == null || user == null || montant.doubleValue() <= 0){
            throw new ObjectCreationException("Un problème est survenu lors de la création d'un objet DoBet");
        }
        DoBet doBet = new DoBet();
        doBet.doBetDate = DateTime.now().toDate();
        //doBet.bet =?
        doBet.cote = cote;
        doBet.user = user;

        doBet.montant = montant;

        save(doBet);

        return doBet;

    }
}
