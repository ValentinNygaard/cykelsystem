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


    @Override
    public List<Status> findAll() {
        String sql = "SELECT * FROM status";
        RowMapper<Status> rowMapper = new BeanPropertyRowMapper<>(Status.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Status findById(int id) {
        String sql = "SELECT * FROM status WHERE id=?";
        RowMapper<Status> rowMapper = new BeanPropertyRowMapper<>(Status.class);
        Status s = template.queryForObject(sql, rowMapper, id);
        return s;
    }

    @Override
    public Status add(Status s) {
        String sql = "INSERT INTO status (id, status_title) VALUES(?,?)";
        template.update(sql, s.getStatus_id(), s.getStatus_title());
        return s;
    }

    @Override
    public Boolean delete(int id) {
        String sql = "DELETE FROM person WHERE id=?";
        return template.update(sql, id) >= 0;
    }

    @Override
    public Status update(int id, Status s) {
        String sql = "UPDATE status SET status_title=? WHERE id=?";
        template.update(sql, s.getStatus_title(), s.getStatus_id());
        return null;
    }
}
