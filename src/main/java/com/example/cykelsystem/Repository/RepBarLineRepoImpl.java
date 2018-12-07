package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.RepBarLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RepBarLineRepoImpl {

    @Autowired
    JdbcTemplate template;

    public List<RepBarLine> findAll() {
        String sql = "select repair_case_id, phone_number, repair_number, t1.time, t1.price, status_title, end_date\n" +
                "from customer natural join bicycle natural join repair_case natural join (select repair_case_id, status_title, sum(time) as time, sum(price) as price\n" +
                "from status natural join repair_case natural join repair_line_item\n" +
                "group by repair_case_id) t1\n" +
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper);
        return repBarLines;
    }

    public List<RepBarLine> findAllRepbars() {
        String sql = "select repair_case_id, phone_number, repair_number, t1.time, t1.price, status_title, end_date\n" +
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

    public List<RepBarLine> findAllRepbarsDate() {
        String sql = "select repair_case_id, phone_number, repair_number, t1.time, t1.price, status_title, end_date\n" +
                "from customer natural join bicycle natural join repair_case natural join (select repair_case_id, status_title, sum(time) as time, sum(price) as price\n" +
                "from status natural join repair_case natural join repair_line_item\n" +
                "group by repair_case_id) t1\n" +
                "where status_id < 3 and end_date >= ?" +
                "group by repair_case_id\n" +
                "order by end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        String s = "'"+LocalDate.now()+"'";

        List<RepBarLine> repBarLines = template.query(sql, rowMapper, s);
        return repBarLines;
    }
}
