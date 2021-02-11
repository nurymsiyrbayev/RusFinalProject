package services.interfaces;

import models.Event;
import models.GenericStackClass;

public interface EventService {
    boolean insert(Event entity);

    boolean update(Event entity);

    boolean remove(long id);

    Event select(long id);

    GenericStackClass<Event> getEventStackByClubId(long clubId);

    GenericStackClass<Event> getEventStack();
}
