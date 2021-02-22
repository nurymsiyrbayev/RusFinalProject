package dao;

import dao.interfaces.UserDAO;
import models.User;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean insert(User entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO users(user_id, user_first_name, user_last_name, user_email, user_password, user_role)" +
                    "VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getUserFirstName());
            ps.setString(2, entity.getUserLastName());
            ps.setString(3, entity.getUserEmail());
            ps.setString(4, entity.getUserPassword());
            ps.setInt(5, entity.getUserRole());
            if(ps.executeUpdate() > 0) {
                ps.close();
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE users SET user_first_name = ?, user_last_name = ?, user_email = ?, user_password = ?," +
                    " user_role = ?  WHERE user_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getUserFirstName());
            ps.setString(2, entity.getUserLastName());
            ps.setString(3, entity.getUserEmail());
            ps.setString(4, entity.getUserPassword());
            ps.setInt(5, entity.getUserRole());
            ps.setLong(6, entity.getUserId());
            if(ps.executeUpdate() > 0) {
                ps.close();
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM users WHERE user_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            if(ps.executeUpdate() > 0) {
                ps.close();
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public User select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT user_id, user_first_name, user_last_name, user_email, user_role FROM users WHERE user_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            User user = getUserFromResultSet(rs, ps, connection);
            if (user != null) return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT user_id, user_first_name, user_last_name, user_email, user_role FROM users";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return getUserListFromResultSet(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByLogin(String userEmail, String userPassword) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT user_id, user_first_name, user_last_name, user_email, user_role " +
                    "FROM users WHERE user_email = ? and user_password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, userEmail);
            ps.setString(2, userPassword);
            rs = ps.executeQuery();
            User user = getUserFromResultSet(rs, ps, connection);
            if (user != null) return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByLoginDate(String userEmail) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT user_id, user_first_name, user_last_name, user_email, user_role " +
                    "FROM users WHERE user_email = ? ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, userEmail);
            rs = ps.executeQuery();
            User user = getUserFromResultSet(rs, ps, connection);
            if (user != null) return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     *  Instead of duplicating whole creation of single user from result set, better simply create method
     *  Method, which accepts ResultSet, PreparedStatement and Connection, returns user and closing ResultSet, PreparedStatement and Connection
     */
    private User getUserFromResultSet(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        if (rs.next()) {
            User user = new User(
                    rs.getLong("user_id"),
                    rs.getString("user_first_name"),
                    rs.getString("user_last_name"),
                    rs.getString("user_email"),
                    rs.getInt("user_role")
            );
            rs.close();
            ps.close();
            connection.close();
            return user;
        }
        return null;
    }

    /*
     *  Instead of duplicating whole creation of userList from result set, better simply create method
     *  Method, which accepts ResultSet, PreparedStatement and Connection, returns list of users and closing ResultSet, PreparedStatement and Connection
     */
    private List<User> getUserListFromResultSet(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            User user = new User(
                    rs.getLong("user_id"),
                    rs.getString("user_first_name"),
                    rs.getString("user_last_name"),
                    rs.getString("user_email"),
                    rs.getInt("user_role")
            );
            userList.add(user);
        }
        rs.close();
        ps.close();
        connection.close();
        return userList;
    }
}
