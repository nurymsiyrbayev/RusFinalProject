package dao.interfaces;

import models.User;

import java.util.List;

public interface UserDAO extends DAO<User> {
    List<User> getUserList();

    User getUserByLogin(String userEmail, String userPassword);

    User getUserByLoginDate(String userEmail);
}
