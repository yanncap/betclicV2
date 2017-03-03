package services;

import dao.CoteDAO;
import dao.DoBetDAO;
import models.Cote;
import models.DoBet;

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
}
