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
        return Meetting.findAll();
    }

    @Override
    public Meetting get(Long id) {
        return Meetting.find("id = ?1", id).first();
    }

    @Override
    public void save(Meetting meeting) {
        meeting.save();
    }


    @Override
    public void delete(Long id) {
        Meetting.delete("id = ?1", id);
    }

}
