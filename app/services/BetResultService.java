package services;

import dao.BetDAO;
import dao.BetResultDAO;
import models.Bet;
import models.BetResult;
import models.Status;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum BetResultService {
    INSTANCE;

    public List<BetResult> findAll(){
        return BetResultDAO.INSTANCE.findAll();
    }

    public BetResult get(Long id) {
        return BetResultDAO.INSTANCE.get(id);
    }

//    public BetResult find(Status status){
//
//        return BetResultDAO.INSTANCE.getByStatus(status);
//    }

    public void create(BetResult betResult){

        BetResultDAO.INSTANCE.save(betResult);
    }

    public void delete(Long id){

        BetResultDAO.INSTANCE.delete(id);
    }
}
