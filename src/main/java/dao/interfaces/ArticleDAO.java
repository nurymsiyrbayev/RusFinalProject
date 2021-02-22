package dao.interfaces;

import models.Article;
import models.GenericQueueClass;

public interface ArticleDAO extends DAO<Article> {
    GenericQueueClass<Article> getArticlesQueue();
}
