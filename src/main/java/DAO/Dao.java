package DAO;

import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-05
 * Time: 10:33
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public interface Dao<T> {

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
