package dao;

import dao.interfaces.EventDAO;
import models.Event;
import models.GenericStackClass;
import util.DatabaseConnection;

import java.sql.*;
import java.util.Stack;

public class EventDAOImpl implements EventDAO {
    @Override
    public boolean insert(Event entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO events(event_id, event_title, event_description, event_img_url, club_id) VALUES (DEFAULT, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getEventTitle());
            ps.setString(2, entity.getEventDescription());
            ps.setString(3, entity.getEventImgUrl());
            ps.setLong(4, entity.getClubId());
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
    public boolean update(Event entity) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "UPDATE events SET event_title = ?, event_description = ?, event_img_url = ? WHERE event_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getEventTitle());
            ps.setString(2, entity.getEventDescription());
            ps.setString(3, entity.getEventImgUrl());
            ps.setLong(4, entity.getEventId());
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
            String sql = "DELETE FROM events WHERE event_id = ?";
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
    public Event select(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT event_id, event_title, event_description, event_img_url, club_id FROM events WHERE event_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Event event = new Event(
                        rs.getLong("event_id"),
                        rs.getString("event_title"),
                        rs.getString("event_description"),
                        rs.getString("event_img_url"),
                        rs.getLong("club_id")
                );
                rs.close();
                ps.close();
                connection.close();
                return event;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericStackClass<Event> getEventStackByClubId(long clubId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT event_id, event_title, event_description, event_img_url, club_id FROM events WHERE club_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, clubId);
            Stack<Event> events = new Stack<>();
            GenericStackClass<Event> eventStack = new GenericStackClass<>();
            rs = ps.executeQuery();
            while(rs.next()) {
                Event event = new Event(
                        rs.getLong("event_id"),
                        rs.getString("event_title"),
                        rs.getString("event_description"),
                        rs.getString("event_img_url"),
                        rs.getLong("club_id")
                );
                events.add(event);
            }
            rs.close();
            ps.close();
            connection.close();
            eventStack.setStack(events);
            return eventStack;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public GenericStackClass<Event> getEventStack() {
        Connection connection = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT event_id, event_title, event_description, event_img_url, club_id FROM events ";
            ps = connection.createStatement();
            Stack<Event> events = new Stack<>();
            GenericStackClass<Event> eventStack = new GenericStackClass<>();
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                Event event = new Event(
                        rs.getLong("event_id"),
                        rs.getString("event_title"),
                        rs.getString("event_description"),
                        rs.getString("event_img_url"),
                        rs.getLong("club_id")
                );
                events.add(event);
            }
            rs.close();
            ps.close();
            connection.close();
            eventStack.setStack(events);
            return eventStack;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
