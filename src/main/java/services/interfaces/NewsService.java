package services.interfaces;

import models.GenericQueueClass;
import models.News;

public interface NewsService {
    boolean insert(News entity);

    boolean update(News entity);

    boolean remove(long id);

    News select(long id);

    GenericQueueClass<News> getNewsQueue();
}
