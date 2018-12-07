package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepBarLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepBarLineRepoImpl {

    @Autowired
    JdbcTemplate template;

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

    public List<RepBarLine> findAllRepbars() {
        String sql = "select phone_number, repair_number, t1.time, t1.price, status_title, end_date\n" +
                "from customer natural join bicycle natural join repair_case natural join (select repair_case_id, status_title, sum(time) as time, sum(price) as price\n" +
                "from status natural join repair_case natural join repair_line_item\n" +
                "group by repair_case_id) t1\n" +
                "where status_id < 3\n" +
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper);
        return repBarLines;
    }
}
