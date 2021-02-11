package dao;

import dao.interfaces.GroupDAO;
import models.Group;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAOImpl implements GroupDAO {
    @Override
    public boolean insert(Group entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO groups(group_id, group_name) VALUES (DEFAULT, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getGroupName());
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
    public boolean update(Group entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE groups SET group_name = ? WHERE group_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getGroupName());
            ps.setLong(2, entity.getGroupId());
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
            String sql = "DELETE FROM groups WHERE group_id = ?";
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
    public Group select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT group_id, group_name FROM groups WHERE group_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Group group = new Group(
                        rs.getLong("group_id"),
                        rs.getString("group_name")
                );
                rs.close();
                ps.close();
                connection.close();
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Group> getGroupList() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT group_id, group_name FROM groups";
            ps = connection.prepareStatement(sql);
            List<Group> groupList = new ArrayList<>();
            rs = ps.executeQuery();
            while(rs.next()) {
                Group group = new Group(
                        rs.getLong("group_id"),
                        rs.getString("group_name")
                );
                groupList.add(group);
            }
            rs.close();
            ps.close();
            connection.close();
            return groupList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
