package dao;

import dao.interfaces.ArticleDAO;
import models.Article;
import models.GenericQueueClass;
import util.DatabaseConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

public class ArticleDAOImpl implements ArticleDAO {
    @Override
    public boolean insert(Article entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO articles(article_title = ?, article_description = ?, article_img_url = ?) VALUES (DEFAULT, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getArticleTitle());
            ps.setString(2, entity.getArticleDescription());
            ps.setString(3, entity.getArticleImgUrl());
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
    public boolean update(Article entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE articles SET article_title = ?, article_description = ?, article_img_url = ? WHERE article_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getArticleTitle());
            ps.setString(2, entity.getArticleDescription());
            ps.setString(3, entity.getArticleImgUrl());
            ps.setLong(4, entity.getArticleId());
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
            String sql = "DELETE FROM articles WHERE article_id = ?";
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
    public Article select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT article_id, article_title, article_description, article_img_url FROM articles WHERE article_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            Article article = getArticlesFromResultSet(rs, ps, connection);
            if (article != null) return article;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericQueueClass<Article> getArticlesQueue() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT article_id, article_title, article_description, article_img_url FROM articles";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return getArticlesQueueFromResultSet(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     *  Instead of duplicating whole creation of single article from result set, better simply create method
     *  Method, which accepts ResultSet, PreparedStatement and Connection, returns articles and closing ResultSet, PreparedStatement and Connection
     */
    private Article getArticlesFromResultSet(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        if (rs.next()) {
            Article article = new Article(
                    rs.getLong("article_id"),
                    rs.getString("article_title"),
                    rs.getString("article_description"),
                    rs.getString("article_img_url")
            );
            rs.close();
            ps.close();
            connection.close();
            return article;
        }
        return null;
    }

    /*
     * Instead of duplicating whole creation of Queue of articles from result set, better simply create method
     * Method, which accepts ResultSet, PreparedStatement and Connection, returns articles and closing ResultSet, PreparedStatement and Connection
     */
    private GenericQueueClass<Article> getArticlesQueueFromResultSet(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        GenericQueueClass<Article> articlesQueue = new GenericQueueClass<>();
        Queue<Article> articlesList = new LinkedList<>();
        while (rs.next()) {
            Article article = new Article(
                    rs.getLong("article_id"),
                    rs.getString("article_title"),
                    rs.getString("article_description"),
                    rs.getString("article_img_url")
            );
            articlesList.add(article);
        }
        rs.close();
        ps.close();
        connection.close();
        articlesQueue.setQueue(articlesList);
        return articlesQueue;
    }
}
