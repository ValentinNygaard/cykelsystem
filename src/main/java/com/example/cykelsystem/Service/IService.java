package com.example.cykelsystem.Service;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    T findById(T t);

    T create(T t);

    T update(T t);

    boolean delete(int id);
}
