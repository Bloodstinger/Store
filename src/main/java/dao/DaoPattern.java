package dao;

import java.util.List;

public interface DaoPattern<T> {

    void add(T t);

    List<T> getAll();
}
