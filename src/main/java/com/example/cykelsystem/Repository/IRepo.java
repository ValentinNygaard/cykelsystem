//Made by VN,EB,JØ, EPS

package com.example.cykelsystem.Repository;

import java.util.List;

/* Here we are creating a generic interface, the T i our placeholder for the Type
The different methods will have to be implemented in all classes that implements this class. */
public interface IRepo<T> {

    //All these methods don't have any functionality yet, but it will be added when the class is implemented

    //This method creates a list of all the specific objects
    List<T> findAll();

    //This method finds a specific object with a specific id
    T findById(int id);

    //This method creates a new object
    T create(T t);

    //This method deletes a specific object with the specific id
    boolean delete(int id);

    //This method updates the object
    T update(T t);
}
