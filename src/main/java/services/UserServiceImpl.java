package services;

import dao.UserDAOImpl;
import dao.interfaces.UserDAO;
import models.User;
import services.interfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean insert(User entity) {
        return userDAO.insert(entity);
    }

    @Override
    public boolean update(User entity) {
        return userDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return userDAO.remove(id);
    }

    @Override
    public User select(long id) {
        return userDAO.select(id);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Override
    public User getUserByLogin(String userEmail, String userPassword) {
        return userDAO.getUserByLogin(userEmail, userPassword);
    }

    @Override
    public User getUserByLoginDate(String userEmail) {
        return userDAO.getUserByLoginDate(userEmail);
    }
}
