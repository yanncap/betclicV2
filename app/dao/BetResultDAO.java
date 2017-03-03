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
        return null;
    }
     @Override
     public void save(BetResult type) {

     }

    @Override
    public void update(BetResult type) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(BetResult type) {

    }

}
