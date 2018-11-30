package com.example.cykelsystem.Repository;

import java.util.List;

public interface IRepo {

    public List findAll();

    public Object findById(Object object);

    public Object create(Object object);

    public Object update(int id, Object object);

    public boolean delete(int id);
}
