//Made by VN,EB,JØ, EPS

package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusRepoImpl implements IRepo<Status> {

    @Autowired
    JdbcTemplate template;
    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of Status in the database
    it does this through the JdbcTemplate. */
    @Override
    public List<Status> findAll() {
        String sql = "SELECT * FROM status";
        RowMapper<Status> rowMapper = new BeanPropertyRowMapper<>(Status.class);
        return template.query(sql, rowMapper);
    }

    // This method returns a Status with a specific status_id.
    @Override
    public Status findById(int id) {
        String sql = "SELECT * FROM status WHERE status_id=?";
        RowMapper<Status> rowMapper = new BeanPropertyRowMapper<>(Status.class);
        Status status = template.queryForObject(sql, rowMapper, id);
        return status;
    }

    // This method creates an object of Status.
    @Override
    public Status create(Status status) {
        String sql = "INSERT INTO status (status_id, status_title) VALUES(?,?)";
        template.update(sql, status.getStatus_id(), status.getStatus_title());
        return status;
    }

    // This method deletes an object of Status with a specific status_id.
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM status WHERE status_id=?";
        return template.update(sql, id) >= 0;
    }

    // This method updates a Status object, with a specific status_id.
    @Override
    public Status update(Status s) {
        String sql = "UPDATE status SET status_title=? WHERE status_id=?";
        template.update(sql, s.getStatus_title(), s.getStatus_id());
        Status status = findById(s.getStatus_id());
        return status;
    }
}