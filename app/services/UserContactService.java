package services;

import dao.UserContactDAO;
import models.UserContact;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum UserContactService {
    INSTANCE;

    public List<UserContact> findAll(){
        return UserContactDAO.INSTANCE.findAll();
    }

    public UserContact get(Long id){
        return UserContactDAO.INSTANCE.get(id);
    }

    public UserContact save(UserContact userContact){
        userContact.save();
        return userContact;
    }

    public void delete(Long id){
        UserContactDAO.INSTANCE.delete(id);
    }

    public void delete(UserContact userContact){
        UserContactDAO.INSTANCE.delete(userContact.id);
    }

}
