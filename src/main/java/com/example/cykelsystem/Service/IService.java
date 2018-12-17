package com.example.cykelsystem.Service;

import java.util.List;

public interface IService<T> {

    // This method creates a list of all the objects
    List<T> findAll();

    // This method returns a specific object depending on the id
    T findById(int id);

    // this method creates an object
    T create(T t);

    // This method updates an object
    T update(T t);

    // This method deletes an object
    boolean delete(int id);

}
