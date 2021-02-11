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
    public List<User> getUserListByMajorId(long majorId) {
        return userDAO.getUserListByMajorId(majorId);
    }

    @Override
    public List<User> getUserListByGroupId(long groupId) {
        return userDAO.getUserListByGroupId(groupId);
    }

    @Override
    public List<User> getUserListByGraduateYear(int graduateYear) {
        return userDAO.getUserListByGraduateYear(graduateYear);
    }

    @Override
    public User getUserByLogin(String userEmail, String userPassword) {
        return userDAO.getUserByLogin(userEmail, userPassword);
    }

    @Override
    public List<Integer> getGraduateYears() {
        return userDAO.getGraduateYears();
    }

    @Override
    public List<User> searchUserListByEmail(String userEmail, long groupId, long majorId, int graduateYear) {
        return userDAO.searchUserListByEmail(userEmail, groupId, majorId, graduateYear);
    }

    @Override
    public User getUserByLoginDate(String userEmail) {
        return userDAO.getUserByLoginDate(userEmail);
    }
}
