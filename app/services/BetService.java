package services;

import dao.BetDAO;
import dao.UserDAO;
import models.Bet;
import models.Status;
import models.User;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum  BetService {

    INSTANCE;

    public List<Bet> findAll(){
        return BetDAO.INSTANCE.findAll();
    }

    public Bet get(Long id){
        return BetDAO.INSTANCE.get(id);
    }

    public Bet find(String name , Status status){
        return BetDAO.INSTANCE.getByNameAndNotClose(name,status);
    }

    public void save(Bet bet){
       BetDAO.INSTANCE.save(bet);
    }

    public void delete(Long id){
        BetDAO.INSTANCE.delete(id);
    }

}
