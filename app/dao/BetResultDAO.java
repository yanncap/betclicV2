package dao;

import models.BetResult;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum BetResultDAO implements DAO<BetResult>{
    INSTANCE;

    @Override
    public List<BetResult> findAll() {
        return BetResult.findAll();
    }

    @Override
    public BetResult get(Long id) {
        return BetResult.find("id = ?1", id).first();
    }

    @Override
    public void save(BetResult betResult) {
        betResult.save();
    }


    @Override
    public void delete(Long id) {
        BetResult.delete("id = ?1", id);
    }
}
