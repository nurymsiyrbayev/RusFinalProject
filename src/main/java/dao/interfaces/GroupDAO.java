package dao.interfaces;

import models.Group;

import java.util.List;

public interface GroupDAO extends DAO<Group> {
    List<Group> getGroupList();
}
