package services;

import dao.GroupDAOImpl;
import dao.interfaces.GroupDAO;
import models.Group;
import services.interfaces.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    private GroupDAO groupDAO = new GroupDAOImpl();

    @Override
    public boolean insert(Group entity) {
        return groupDAO.insert(entity);
    }

    @Override
    public boolean update(Group entity) {
        return groupDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return groupDAO.remove(id);
    }

    @Override
    public Group select(long id) {
        return groupDAO.select(id);
    }

    @Override
    public List<Group> getGroupList() {
        return groupDAO.getGroupList();
    }
}
