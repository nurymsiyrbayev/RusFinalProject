package services.interfaces;

import models.GenericSetClass;
import models.Major;

public interface MajorService {
    boolean insert(Major entity);

    boolean update(Major entity);

    boolean remove(long id);

    Major select(long id);

    GenericSetClass<Major> getAllMajors();
}
