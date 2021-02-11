package dao;

import dao.interfaces.ClubDAO;
import models.Club;
import models.User;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClubDAOImpl implements ClubDAO {
    @Override
    public boolean insert(Club entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO clubs(club_id, club_name, club_description, club_img_url, owner_id) VALUES (DEFAULT, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getClubName());
            ps.setString(2, entity.getClubDescription());
            ps.setString(3, entity.getClubImgUrl());
            ps.setLong(4, entity.getClubOwnerId());
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
    public boolean update(Club entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE clubs SET club_name = ?, club_description = ?, club_img_url = ?, owner_id = ? WHERE club_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getClubName());
            ps.setString(2, entity.getClubDescription());
            ps.setString(3, entity.getClubImgUrl());
            ps.setLong(4, entity.getClubOwnerId());
            ps.setLong(5, entity.getClubId());
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
            String sql = "DELETE FROM clubs WHERE club_id = ?";
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
    public Club select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT club_id, club_name, club_description, club_img_url, owner_id FROM clubs WHERE club_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Club club = new Club(
                        rs.getLong("club_id"),
                        rs.getString("club_name"),
                        rs.getString("club_description"),
                        rs.getString("club_img_url"),
                        rs.getLong("owner_id")
                );
                rs.close();
                ps.close();
                connection.close();
                return club;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Club> getClubList() {
        Connection connection = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT club_id, club_name, club_description, club_img_url, owner_id FROM clubs";
            ps = connection.createStatement();
            List<Club> clubList = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                Club club = new Club(
                        rs.getLong("club_id"),
                        rs.getString("club_name"),
                        rs.getString("club_description"),
                        rs.getString("club_img_url"),
                        rs.getLong("owner_id")
                );
                clubList.add(club);
            }
            rs.close();
            ps.close();
            connection.close();
            return clubList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUserToClub(long userId, long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO club_members(user_id, club_id) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setLong(2, clubId);
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
    public boolean removeUserFromClub(long userId, long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "DELETE FROM club_members WHERE user_id = ? and club_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setLong(2, clubId);
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
    public List<User> getMembersByClubId(long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT DISTINCT users.user_id, users.user_first_name, users.user_last_name, users.user_email," +
                    " users.user_role, users.group_id, users.major_id, users.graduate_year FROM club_members " +
                    "INNER JOIN users ON users.user_id = club_members.user_id WHERE club_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, clubId);
            rs = ps.executeQuery();
            return getUserListFromResultSet(rs, ps, connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getMembershipRequestsByClubId(long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT DISTINCT users.user_id, users.user_first_name, users.user_last_name, users.user_email," +
            " users.user_role, users.group_id, users.major_id, users.graduate_year FROM user_requests_to_join_the_club " +
            "INNER JOIN users ON users.user_id = user_requests_to_join_the_club.user_id WHERE club_id = ? AND request_status = 'true'";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, clubId);
            rs = ps.executeQuery();
            return getUserListFromResultSet(rs, ps, connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeUserRequestsToJoinTheClub(long userId, long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE user_requests_to_join_the_club SET request_status = 'false' " +
                        "WHERE user_id = ? and club_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setLong(2, clubId);
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
    public boolean addUserRequestsToJoinTheClub(long userId, long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO user_requests_to_join_the_club(user_id, club_id) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setLong(2, clubId);
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
    public User getClubOwnerByClubId(long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT users.user_id, users.user_first_name, users.user_last_name, users.user_email," +
                    " users.user_role, users.group_id, users.major_id, users.graduate_year FROM clubs " +
                    "INNER JOIN users ON users.user_id = clubs.owner_id WHERE club_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, clubId);
            rs = ps.executeQuery();
            if(rs.next()) {
                User user = new User(
                        rs.getLong("user_id"),
                        rs.getString("user_first_name"),
                        rs.getString("user_last_name"),
                        rs.getString("user_email"),
                        rs.getInt("user_role"),
                        rs.getLong("group_id"),
                        rs.getLong("major_id"),
                        rs.getInt("graduate_year")
                );
                rs.close();
                ps.close();
                connection.close();
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
                    rs.getInt("user_role"),
                    rs.getLong("group_id"),
                    rs.getLong("major_id"),
                    rs.getInt("graduate_year")
            );
            userList.add(user);
        }
        rs.close();
        connection.close();
        return userList;
    }
}
