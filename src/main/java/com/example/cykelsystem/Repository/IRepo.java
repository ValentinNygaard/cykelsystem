package com.example.cykelsystem.Repository;

import java.util.List;

public interface IRepo<T> {

    List<T> fetchAll();

    T findById(int id);

    T add(T t);

    Boolean delete(int id);

    T update(int id, T t);
}
