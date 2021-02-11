package services;

import dao.MajorDAOImpl;
import dao.interfaces.MajorDAO;
import models.GenericSetClass;
import models.Major;
import services.interfaces.MajorService;

public class MajorServiceImpl implements MajorService {
    private MajorDAO majorDAO = new MajorDAOImpl();

    @Override
    public boolean insert(Major entity) {
        return majorDAO.insert(entity);
    }

    @Override
    public boolean update(Major entity) {
        return majorDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return majorDAO.remove(id);
    }

    @Override
    public Major select(long id) {
        return majorDAO.select(id);
    }

    @Override
    public GenericSetClass<Major> getAllMajors() {
        return majorDAO.getAllMajors();
    }
}
