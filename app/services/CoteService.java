package services;

import dao.BetDAO;
import dao.CoteDAO;
import models.Bet;
import models.Cote;
import models.Status;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum CoteService {
    INSTANCE;

    public List<Cote> findAll(){

        return CoteDAO.INSTANCE.findAll();
    }

    public Cote get(Long id){
        return CoteDAO.INSTANCE.get(id);
    }

    public void save(Cote cote){
        CoteDAO.INSTANCE.save(cote);
    }

    public void delete(Long id){
        CoteDAO.INSTANCE.delete(id);
    }
}
