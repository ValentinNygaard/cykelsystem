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

        /*sql statement med null værdier
        SELECT repair_case_id, phone_number, repair_number, t1.time, t1.price, status_title, end_date
FROM customer NATURAL JOIN bicycle
	NATURAL JOIN repair_case
	LEFT JOIN
    (SELECT repair_case_id, status_title, sum(time) as time, sum(price) as price
	FROM status NATURAL JOIN repair_case
		LEFT JOIN repair_line_item using(repair_case_id)
	GROUP BY repair_case_id) t1 using(repair_case_id)
GROUP BY repair_case_id
ORDER BY end_date, status_id;*/

        /*sql statement 2 med null værdier
        SELECT repair_case_id, sum(price) as price
FROM part_line_item
GROUP BY repair_case_id
ORDER BY repair_case_id;
         */

        /*sql statement hvor der hentes pris til en enkelt repair case
	SELECT repair_case_id, sum(repair_line_item.price) as rep_price, sum(part_line_item.price) as part_price
	FROM repair_line_item LEFT JOIN part_line_item using(repair_case_id)
	where repair_case_id = ?
UNION
	SELECT repair_case_id, sum(repair_line_item.price) as rep_price, sum(part_line_item.price) as part_price
	FROM repair_line_item RIGHT JOIN part_line_item using(repair_case_id)
	where repair_case_id = ?;
        */
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

    public List<RepBarLine> findAllRepbarsDate(java.sql.Date date) {
        String sql = "SELECT repair_case_id, phone_number, repair_number, t1.time, t1.price, status_title, end_date\n" +
                "FROM customer NATURAL JOIN bicycle NATURAL JOIN repair_case NATURAL JOIN (SELECT repair_case_id, status_title, sum(time) AS time, sum(price) AS price\n" +
                "FROM status NATURAL JOIN repair_case NATURAL JOIN repair_line_item\n" +
                "GROUP BY repair_case_id) t1\n" +
                "WHERE status_id > 1 AND status_id < 4 AND end_date >= ? \n" +
                "GROUP BY repair_case_id\n" +
                "ORDER BY end_date, status_id;";
        RowMapper<RepBarLine> rowMapper = new BeanPropertyRowMapper<>(RepBarLine.class);
        List<RepBarLine> repBarLines = template.query(sql, rowMapper, date);
        return repBarLines;
    }
}
