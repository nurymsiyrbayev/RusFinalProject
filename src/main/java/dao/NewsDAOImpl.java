package dao;

import dao.interfaces.NewsDAO;
import models.GenericQueueClass;
import models.News;
import util.DatabaseConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

public class NewsDAOImpl implements NewsDAO {
    @Override
    public boolean insert(News entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO news(news_id, news_title, news_description, news_img_url) VALUES (DEFAULT, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getNewsTitle());
            ps.setString(2, entity.getNewsDescription());
            ps.setString(3, entity.getNewsImgUrl());
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
    public boolean update(News entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE news SET news_title = ?, news_description = ?, news_img_url = ? WHERE news_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getNewsTitle());
            ps.setString(2, entity.getNewsDescription());
            ps.setString(3, entity.getNewsImgUrl());
            ps.setLong(4, entity.getNewsId());
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
            String sql = "DELETE FROM news WHERE news_id = ?";
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
    public News select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT news_id, news_title, news_description, news_img_url FROM news WHERE news_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            News news = getNewsFromResultSet(rs, ps, connection);
            if (news != null) return news;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericQueueClass<News> getNewsQueue() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT news_id, news_title, news_description, news_img_url FROM news";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return getNewsQueueFromResultSet(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     *  Instead of duplicating whole creation of single news from result set, better simply create method
     *  Method, which accepts ResultSet, PreparedStatement and Connection, returns news and closing ResultSet, PreparedStatement and Connection
     */
    private News getNewsFromResultSet(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        if (rs.next()) {
            News news = new News(
                    rs.getLong("news_id"),
                    rs.getString("news_title"),
                    rs.getString("news_description"),
                    rs.getString("news_img_url")
            );
            rs.close();
            ps.close();
            connection.close();
            return news;
        }
        return null;
    }

    /*
     * Instead of duplicating whole creation of Queue of news from result set, better simply create method
     * Method, which accepts ResultSet, PreparedStatement and Connection, returns news and closing ResultSet, PreparedStatement and Connection
     */
    private GenericQueueClass<News> getNewsQueueFromResultSet(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        GenericQueueClass<News> newsQueue = new GenericQueueClass<>();
        Queue<News> newsList = new LinkedList<>();
        while (rs.next()) {
            News news = new News(
                    rs.getLong("news_id"),
                    rs.getString("news_title"),
                    rs.getString("news_description"),
                    rs.getString("news_img_url")
            );
            newsList.add(news);
        }
        rs.close();
        ps.close();
        connection.close();
        newsQueue.setQueue(newsList);
        return newsQueue;
    }
}
