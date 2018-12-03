package com.example.cykelsystem.Repository;

import java.util.List;

public interface IRepo<T> {

    List<T> findAll();

    T findById(T t);
    
    T create(T t);

    T update(T t);

    boolean delete(int id);
}
