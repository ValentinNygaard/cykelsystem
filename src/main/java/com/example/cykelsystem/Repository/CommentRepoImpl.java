// Made by VN
package com.example.cykelsystem.Repository;

import com.example.cykelsystem.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepoImpl  implements IRepo<Comment>{

    @Autowired
    JdbcTemplate template;

    // All the methods with the @Override annotation, is implemeted.

    /* This method finds all objects of comment in the database
     it does this through the JdbcTemplate. */
    @Override
    public List<Comment> findAll() {
        String sql = "SELECT * FROM comment";
        RowMapper<Comment> rowMapper = new BeanPropertyRowMapper<>(Comment.class);
        return template.query(sql, rowMapper);
    }
    // This method returns a Bicycle with a specific id.
    @Override
    public Comment findById(int id) {
        String sql ="SELECT * FROM comment WHERE repair_case_id=?";
        RowMapper<Comment> rowMapper = new BeanPropertyRowMapper<>(Comment.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // This method finds a comment, on a specific repair_case_id
    public boolean existsById(int id) {
        String sql ="SELECT * FROM comment WHERE repair_case_id=?";
        RowMapper<Comment> rowMapper = new BeanPropertyRowMapper<>(Comment.class);
        return (template.query(sql, rowMapper, id).size()>0);
    }

    // This method creates a new object of Comment
    @Override
    public Comment create(Comment comment) {
        String sql = "INSERT INTO comment (repair_case_id, comment) VALUES(?,?)";
        template.update(sql, comment.getRepair_case_id(), comment.getComment());
        return comment;
    }

    // This method updates a specific Comment with a specific repair_case_id.
    @Override
    public Comment update(Comment comment) {
        System.out.println("getting to repo");
        String sql = "UPDATE comment SET comment=? WHERE repair_case_id=?";
        template.update(sql,comment.getComment(), comment.getRepair_case_id());
        return comment;
    }

    // This method deletes a comment with a specific repair_case_id.
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM comment WHERE repair_case_id=?";
        return  template.update(sql, id) >= 0;
    }
}
