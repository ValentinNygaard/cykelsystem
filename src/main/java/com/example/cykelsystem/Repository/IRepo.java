package com.example.cykelsystem.Repository;

import java.util.List;

public interface IRepo {

    List findAll();

    Object findById(Object object);
    
    Object create(Object object);

    Object update(Object object);

    boolean delete(int id);
}
