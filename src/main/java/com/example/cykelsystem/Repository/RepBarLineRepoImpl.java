package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepBarLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class RepBarLineRepoImpl implements IRepo<RepBarLine> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<RepBarLine> findAll() {
        String sql = "select phone_number, repair_number, t1.time, t1.price, status_title, end_date\n" +
                "from customer natural join bicycle natural join repair_case natural join (select repair_case_id, status_title, sum(time) as time, sum(price) as price\n" +
                "from status s join repair_case r using(status_id) right join repair_line_item rli using(repair_case_id)\n" +
                "group by repair_case_id) t1\n" +
                "group by repair_case_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        return template.query(sql, rowMapper);
        //    phone_number, repair_number, time, price, status, end_date;
    }

    @Override
    public RepBarLine findById(int id) {
        return null;
    }

    @Override
    public RepBarLine create(RepBarLine repBarLine) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public RepBarLine update(RepBarLine repBarLine) {
        return null;
    }
}
