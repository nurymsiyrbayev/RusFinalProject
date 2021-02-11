package dao;

import dao.interfaces.MajorDAO;
import models.GenericSetClass;
import models.Major;
import util.DatabaseConnection;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class MajorDAOImpl implements MajorDAO {
    @Override
    public boolean insert(Major entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO majors(major_id, major_name) VALUES (DEFAULT, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getMajorName());
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
    public boolean update(Major entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE majors SET major_name = ? WHERE news_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getMajorName());
            ps.setLong(2, entity.getMajorId());
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
            String sql = "DELETE FROM majors WHERE major_id = ?";
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
    public Major select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT major_id, major_name FROM majors WHERE major_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Major major = new Major(
                        rs.getLong("major_id"),
                        rs.getString("major_name")
                );
                rs.close();
                ps.close();
                connection.close();
                return major;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericSetClass<Major> getAllMajors() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT major_id, major_name FROM majors";
            ps = connection.prepareStatement(sql);
            GenericSetClass<Major> majorSet = new GenericSetClass<>();
            Set<Major> majors = new LinkedHashSet<>();
            rs = ps.executeQuery();
            while(rs.next()) {
                majors.add(new Major(
                        rs.getLong("major_id"),
                        rs.getString("major_name")
                    )
                );
            }
            majorSet.setSet(majors);
            rs.close();
            ps.close();
            connection.close();
            return majorSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
