package services;

import dao.AuthorDAOImpl;
import dao.interfaces.AuthorDAO;
import models.Author;
import models.User;
import services.interfaces.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorDAO authorDAO = new AuthorDAOImpl();

    @Override
    public boolean insert(Author entity) {
        return authorDAO.insert(entity);
    }

    @Override
    public boolean update(Author entity) {
        return authorDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return authorDAO.remove(id);
    }

    @Override
    public Author select(long id) {
        return authorDAO.select(id);
    }

    @Override
    public List<Author> getAuthorList() {
        return authorDAO.getAuthorList();
    }
}
