package services.interfaces;

import models.Author;
import models.User;

import java.util.List;

public interface AuthorService {
    boolean insert(Author entity);

    boolean update(Author entity);

    boolean remove(long id);

    Author select(long id);

    List<Author> getAuthorList();

}
