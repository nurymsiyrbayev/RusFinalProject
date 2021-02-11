package dao.interfaces;

import models.GenericSetClass;
import models.Major;

public interface MajorDAO extends DAO<Major> {
    GenericSetClass<Major> getAllMajors();
}
