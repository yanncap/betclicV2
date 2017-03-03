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

    public User create(User user){
        User usertmp = UserDAO.INSTANCE.get(user.email);
        if(usertmp == null){
            UserDAO.INSTANCE.save(user);
        }
        return user;
    }
}
