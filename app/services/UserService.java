package services;

import dao.UserDAO;
import models.User;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public enum UserService {
    INSTANCE;

    public List<User> findAll(){
        return UserDAO.INSTANCE.findAll();
    }

    public User find(String email){
        return UserDAO.INSTANCE.get(email);
    }

    public User get(Long id){
        return UserDAO.INSTANCE.get(id);
    }

    public User save(User user){
        UserDAO.INSTANCE.save(user);
        return user;
    }

    public void update(User user){
            UserDAO.INSTANCE.save(user);
    }
}
