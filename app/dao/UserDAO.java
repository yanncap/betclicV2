package dao;

import models.User;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum UserDAO implements DAO<User> {
    INSTANCE;

    @Override
    public List<User> findAll() {
        return User.findAll();
    }

    @Override
    public User get(Long id) {
        return User.find("id=?1", id).first();
    }

    public User get(String email){
        return User.find("email=?1", email).first();
    }

    @Override
    public void save(User type) {

    }

    @Override
    public void update(User type) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(User type) {

    }
}