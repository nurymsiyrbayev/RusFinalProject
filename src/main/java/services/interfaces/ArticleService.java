package services.interfaces;

import models.Article;
import models.GenericQueueClass;

public interface ArticleService {
    boolean insert(Article entity);

    boolean update(Article entity);

    boolean remove(long id);

    Article select(long id);

    GenericQueueClass<Article> getArticlesQueue();
}
