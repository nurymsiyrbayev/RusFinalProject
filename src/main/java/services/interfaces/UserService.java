package services.interfaces;

import models.User;

import java.util.List;

public interface UserService {
    boolean insert(User entity);

    boolean update(User entity);

    boolean remove(long id);

    User select(long id);

    List<User> getUserList();

    List<User> getUserListByMajorId(long majorId);

    List<User> getUserListByGroupId(long groupId);

    List<User> getUserListByGraduateYear(int graduateYear);

    User getUserByLogin(String userEmail, String userPassword);

    List<Integer> getGraduateYears();

    List<User> searchUserListByEmail(String userEmail, long groupId, long majorId, int graduateYear);

    User getUserByLoginDate(String userEmail);

}
