package dao.interfaces;

import models.GenericModel;

public interface DAO<T extends GenericModel> {
    boolean insert(T entity);

    boolean update(T entity);

    boolean remove(long id);

    T select(long id);
}
