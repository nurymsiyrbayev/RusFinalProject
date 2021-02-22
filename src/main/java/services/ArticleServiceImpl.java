package services;

import dao.ArticleDAOImpl;
import dao.interfaces.ArticleDAO;
import models.Article;
import models.GenericQueueClass;
import services.interfaces.ArticleService;

public class ArticleServiceImpl implements ArticleService {
    private ArticleDAO articleDAO = new ArticleDAOImpl();

    @Override
    public boolean insert(Article entity) {
        return articleDAO.insert(entity);
    }

    @Override
    public boolean update(Article entity) {
        return articleDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return articleDAO.remove(id);
    }

    @Override
    public Article select(long id) {
        return articleDAO.select(id);
    }

    @Override
    public GenericQueueClass<Article> getArticlesQueue() {
        return articleDAO.getArticlesQueue();
    }
}
