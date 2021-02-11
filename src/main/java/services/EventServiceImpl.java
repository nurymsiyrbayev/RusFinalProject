package services;

import dao.EventDAOImpl;
import dao.interfaces.EventDAO;
import models.Event;
import models.GenericStackClass;
import services.interfaces.EventService;

public class EventServiceImpl implements EventService {
    private EventDAO eventDAO = new EventDAOImpl();

    @Override
    public boolean insert(Event entity) {
        return eventDAO.insert(entity);
    }

    @Override
    public boolean update(Event entity) {
        return eventDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return eventDAO.remove(id);
    }

    @Override
    public Event select(long id) {
        return eventDAO.select(id);
    }

    @Override
    public GenericStackClass<Event> getEventStackByClubId(long clubId) {
        return eventDAO.getEventStackByClubId(clubId);
    }

    @Override
    public GenericStackClass<Event> getEventStack() {
        return eventDAO.getEventStack();
    }
}
