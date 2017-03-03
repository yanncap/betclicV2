package dao;

import java.util.List;

/**
 * Created by formation on 03/03/17.
 */
public interface DAO<T> {

    List<T> findAll();
    T get(Long id);
    void save(T type);
    void delete(Long id);
}
