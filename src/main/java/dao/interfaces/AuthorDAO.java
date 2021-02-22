package dao.interfaces;

import models.Author;
import models.User;

import java.util.List;

public interface AuthorDAO extends DAO<Author> {
    List<Author> getAuthorList();
}
