package dao;

import models.DoBet;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum DoBetDAO implements DAO<DoBet>{
    INSTANCE;

    @Override
    public List<DoBet> findAll() {
        return null;
    }

    @Override
    public DoBet get(Long id) {
        return null;
    }

    @Override
    public void save(DoBet doBet) {
        doBet.save();
    }


    @Override
    public void delete(Long id) {
        DoBet.delete("id = ?1", id);
    }

}
