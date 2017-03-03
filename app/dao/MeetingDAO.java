package dao;

import models.Meetting;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum MeetingDAO implements DAO<Meetting> {
    INSTANCE;

    @Override
    public List<Meetting> findAll() {
        return null;
    }

    @Override
    public Meetting get(Long id) {
        return null;
    }

    @Override
    public void save(Meetting type) {

    }

    @Override
    public void update(Meetting type) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Meetting type) {

    }
}
