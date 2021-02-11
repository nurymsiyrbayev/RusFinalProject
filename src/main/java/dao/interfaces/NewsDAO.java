package dao.interfaces;

import models.GenericQueueClass;
import models.News;

public interface NewsDAO extends DAO<News> {
    GenericQueueClass<News> getNewsQueue();
}
