// Made by VN
package com.example.cykelsystem.Service;

import com.example.cykelsystem.Model.Comment;
import com.example.cykelsystem.Repository.CommentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements IService<Comment> {

    @Autowired
    CommentRepoImpl repoImpl;
    // All the methods with the @Override annotation, is implemeted.

    // This method finds all objects of Comment
    @Override
    public List<Comment> findAll() {
        return repoImpl.findAll();
    }

    // This method finds all Comment objects with a specific id.
    @Override
    public Comment findById(int id) {
        return repoImpl.findById(id);
    }

    // This method checks if there is a Comment object with a specific id
    public boolean existsById(int id) {
        return repoImpl.existsById(id);
    }

    //This method creates a new object of Comment
    @Override
    public Comment create(Comment o) {
        return repoImpl.create(o);
    }

    // This method updates an object of Comment
    @Override
    public Comment update(Comment o) {
        return repoImpl.update(o);
    }

    // This method delets an object of Comment with a specific id
    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

}
