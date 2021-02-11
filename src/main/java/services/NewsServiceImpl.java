package services;

import dao.NewsDAOImpl;
import dao.interfaces.NewsDAO;
import models.GenericQueueClass;
import models.News;
import services.interfaces.NewsService;

public class NewsServiceImpl implements NewsService {
    private NewsDAO newsDAO = new NewsDAOImpl();

    @Override
    public boolean insert(News entity) {
        return newsDAO.insert(entity);
    }

    @Override
    public boolean update(News entity) {
        return newsDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return newsDAO.remove(id);
    }

    @Override
    public News select(long id) {
        return newsDAO.select(id);
    }

    @Override
    public GenericQueueClass<News> getNewsQueue() {
        return newsDAO.getNewsQueue();
    }
}
