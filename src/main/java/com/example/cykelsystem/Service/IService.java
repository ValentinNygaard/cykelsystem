package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.StdBicyclepartLineItem;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    T findById(int id);

    T create(T t);

    T update(T t);

    boolean delete(int id);
}
