package com.example.cykelsystem.Repository;

import java.util.List;

public interface IRepo<T> {

    List<T> findAll();

    T findById(int id);

    T create(T t);

    Boolean delete(int id);

    T update(T t);
}
