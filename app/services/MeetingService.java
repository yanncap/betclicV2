package services;

import dao.MeetingDAO;
import models.Meeting;

import java.util.Date;
import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum MeetingService {

    INSTANCE;

    public List<Meeting> findAll(){

        return MeetingDAO.INSTANCE.findAll();
    }

    public Meeting get(Long id){
        return MeetingDAO.INSTANCE.get(id);
    }

    public void save(Meeting meetting){
        MeetingDAO.INSTANCE.save(meetting);

    }

    public void delete(Long id){
        MeetingDAO.INSTANCE.delete(id);
    }

    public List<Meeting> findBayDate(Date date){
       return MeetingDAO.INSTANCE.findByDate(date);
    }

    public List<Meeting> getTopTenMeetings() throws Exception {
        List<Meeting> meetings = MeetingDAO.INSTANCE.getTopTenMeetings();
        if(meetings == null || meetings.isEmpty()){
            throw new Exception("erreur lors de la récupération des meetings");
        }
        for (Meeting m: meetings) {
            if(m.bets == null || m.bets.isEmpty()){
                meetings.remove(m);
            }
        }
        return meetings;
    }
}
