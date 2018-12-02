package com.example.cykelsystem.Service;

import java.util.List;

public interface IService {

    List findAll();

    Object findById(Object object);

    Object create(Object object);

    Object update(Object object);

    boolean delete(int id);
}
