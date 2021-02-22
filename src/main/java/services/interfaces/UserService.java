package services.interfaces;

import models.User;

import java.util.List;

public interface UserService {

    boolean insert(User entity);

    boolean update(User entity);

    boolean remove(long id);

    User select(long id);

    List<User> getUserList();

    User getUserByLogin(String userEmail, String userPassword);

    User getUserByLoginDate(String userEmail);

}
