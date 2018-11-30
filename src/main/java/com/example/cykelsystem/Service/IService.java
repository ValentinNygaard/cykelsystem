package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Person;
import java.util.List;

public interface IService {

    List<Person> fetchAll();

    Person findPersonById(int id);

    Person addPerson(Person p);

    Boolean deletePerson(int id);

    Person updatePerson(int id, Person p);

}
