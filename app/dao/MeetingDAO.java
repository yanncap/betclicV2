package dao;

import models.Meeting;

import java.util.Date;
import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum MeetingDAO implements DAO<Meeting> {
    INSTANCE;

    @Override
    public List<Meeting> findAll() {
        return Meeting.findAll();
    }

    public  List<Meeting> findByDate(Date date){

        return Meeting.find("date = ?1", date).fetch(10);

    }

    @Override
    public Meeting get(Long id) {
        return Meeting.find("id = ?1", id).first();
    }


    @Override
    public void save(Meeting meeting) {
        meeting.save();
    }

    @Override
    public void delete(Long id) {
        Meeting.delete("id = ?1", id);
    }

}
