package com.example.cykelsystem.Service;

import java.util.List;

public interface IService {

    public List findAll();

    public Object findById(Object object);

    public Object create(Object object);

    public Object update(int id, Object object);

    public boolean delete(int id);
}
