package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepBarLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepBarLineRepoImpl implements IRepo<RepBarLine> {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<RepBarLine> findAll() {
        String sql = "SELECT phone_number, repair_number, t1.time, t1.price, status_title, end_date\n" +
                "FROM customer NATURAL JOIN bicycle NATURAL JOIN repair_case NATURAL JOIN (SELECT repair_case_id, status_title, SUM(time) as time, SUM(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case NATURAL JOIN repair_line_item\n" +
                "GROUP BY repair_case_id) t1\n" +
                "GROUP BY repair_case_id\n" +
                "ORDER BY end_date, status_id;\n";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper);
        return repBarLines;
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
