package DAO;

import java.io.IOException;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-05
 * Time: 10:33
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public interface Dao<T> {

    List<T> getAll() throws IOException, ClassNotFoundException;

    void saveAll() throws IOException;

    void save(T t) throws IOException;

    void update(T t);

    void delete(T t);
}
