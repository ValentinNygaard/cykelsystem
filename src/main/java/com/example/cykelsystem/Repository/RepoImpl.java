package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepoImpl implements IRepo {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Person> fetchAll() {
        String sql = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Person findPersonById(int id) {
        String sql = "SELECT * FROM person WHERE id=?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person p = template.queryForObject(sql, rowMapper, id);
        return p;
    }

    @Override
    public Person addPerson(Person p) {
        String sql = "INSERT INTO person (id, first_name, last_name) VALUES(?,?,?)";
        template.update(sql, p.getId(), p.getFirst_name(), p.getLast_name());
        return null;
    }

    @Override
    public Boolean deletePerson(int id) {
        String sql = "DELETE FROM person WHERE id=?";
        return template.update(sql, id) >= 0;
    }

    @Override
    public Person updatePerson(int id, Person p) {
        String sql = "UPDATE person SET first_name=?, last_name=? WHERE id=?";
        template.update(sql, p.getFirst_name(), p.getLast_name(), p.getId());
        return null;
    }
}
