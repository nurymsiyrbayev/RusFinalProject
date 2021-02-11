package services.interfaces;

import models.Group;

import java.util.List;

public interface GroupService {
    boolean insert(Group entity);

    boolean update(Group entity);

    boolean remove(long id);

    Group select(long id);

    List<Group> getGroupList();
}
