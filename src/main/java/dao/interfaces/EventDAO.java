package dao.interfaces;

import models.Event;
import models.GenericStackClass;

public interface EventDAO extends DAO<Event> {
    GenericStackClass<Event> getEventStackByClubId(long clubId);

    GenericStackClass<Event> getEventStack();
}
