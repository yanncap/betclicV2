package dao;



import models.UserContact;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum UserContactDAO implements DAO<UserContact> {

    INSTANCE;

    @Override
    public List<UserContact> findAll() {
        return UserContact.findAll();
    }

    @Override
    public UserContact get(Long id) {
        return UserContact.find("id = ?1", id).first();
    }

    @Override
    public void save(UserContact bet) {
        bet.save();
    }

    @Override
    public void delete(Long id) {
        UserContact.delete("id = ?1", id);
    }
}
