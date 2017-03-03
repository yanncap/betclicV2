package dao;

import models.Bet;
import models.Status;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum BetDAO implements DAO<Bet> {

    INSTANCE;

    @Override
    public List<Bet> findAll() {
        return Bet.findAll();
    }

    @Override
    public Bet get(Long id) {
        return Bet.find("id = ?1", id).first();
    }

    public Bet getByNameAndNotClose(String name, Status status){
        return Bet.find("name like CONCAT(?1, '%') and status=?2 or status=?3",
                name, status.WAIT, status.IN_PROGRESS).first();
    }


    @Override
    public void save(Bet bet) {
        bet.save();
    }

    @Override
    public void delete(Long id) {
        Bet.delete("id = ?1", id);
    }
}
