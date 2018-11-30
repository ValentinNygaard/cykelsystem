package com.example.cykelsystem.Service;
import com.example.cykelsystem.Model.Person;
import com.example.cykelsystem.Repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {

    @Autowired
    IRepo personRepo;

    @Override
    public List<Person> fetchAll() {
        return personRepo.fetchAll();
    }

    @Override
    public Person findPersonById(int id) {
        return personRepo.findPersonById(id);
    }

    @Override
    public Person addPerson(Person p) {
        return personRepo.addPerson(p);
    }

    @Override
    public Boolean deletePerson(int id) {
        return personRepo.deletePerson(id);
    }

    @Override
    public Person updatePerson(int id, Person p) {
        return personRepo.updatePerson(id, p);
    }
}
