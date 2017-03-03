package dao;

import models.Bet;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum BetDAO implements DAO<Bet> {

    INSTANCE;

    @Override
    public List<Bet> findAll() {
        return null;
    }

    @Override
    public Bet get(Long id) {
        return null;
    }

    @Override
    public void save(Bet type) {

    }

    @Override
    public void update(Bet type) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Bet type) {

    }
}
