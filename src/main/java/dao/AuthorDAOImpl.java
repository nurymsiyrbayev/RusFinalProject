package dao;

import dao.interfaces.AuthorDAO;
import models.Author;
import models.User;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public boolean insert(Author entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO authors(author_id, author_full_name, author_biography, author_img_url, author_birth_date, author_death_date)  " +
                    "VALUES (DEFAULT, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getAuthorName());
            ps.setString(2, entity.getAuthorBiography());
            ps.setString(3, entity.getAuthorImgUrl());
            ps.setDate(4, entity.getBirthDate());
            ps.setDate(5, entity.getDeathDate());
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
    public boolean update(Author entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE authors SET author_full_name = ?, author_biography = ?, author_img_url = ?, author_birth_date = ?, author_death_date = ?\n" +
                    "WHERE author_id = ?;";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getAuthorName());
            ps.setString(2, entity.getAuthorBiography());
            ps.setString(3, entity.getAuthorImgUrl());
            ps.setDate(4, entity.getBirthDate());
            ps.setDate(5, entity.getDeathDate());
            ps.setLong(6, entity.getAuthorId());
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
            String sql = "DELETE FROM authors WHERE author_id = ?";
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
    public Author select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "select author_id, author_full_name, author_biography, author_img_url, author_birth_date, author_death_date FROM authors\n" +
                    "WHERE author_id = ?;";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Author author = new Author(
                        rs.getLong("author_id"),
                        rs.getString("author_full_name"),
                        rs.getString("author_biography"),
                        rs.getString("author_img_url"),
                        rs.getDate("author_birth_date"),
                        rs.getDate("author_death_date")
                );
                rs.close();
                ps.close();
                connection.close();
                return author;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Author> getAuthorList() {
        Connection connection = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "select author_id, author_full_name, author_biography, author_img_url, author_birth_date, author_death_date FROM authors";
            ps = connection.createStatement();
            List<Author> authors = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                Author author = new Author(
                        rs.getLong("author_id"),
                        rs.getString("author_full_name"),
                        rs.getString("author_biography"),
                        rs.getString("author_img_url"),
                        rs.getDate("author_birth_date"),
                        rs.getDate("author_death_date")
                );
                authors.add(author);
            }
            rs.close();
            ps.close();
            connection.close();
            return authors;
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
                    rs.getInt("user_role")
            );
            userList.add(user);
        }
        rs.close();
        connection.close();
        return userList;
    }
}
