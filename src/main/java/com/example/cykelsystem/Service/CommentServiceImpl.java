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

    @Override
    public List<Comment> findAll() {
        return repoImpl.findAll();
    }

    @Override
    public Comment findById(int id) {
        return repoImpl.findById(id);
    }

    public boolean existsById(int id) {
        return repoImpl.existsById(id);
    }

    @Override
    public Comment create(Comment o) {
        return repoImpl.create(o);
    }

    @Override
    public Comment update(Comment o) {
        return repoImpl.update(o);
    }

    @Override
    public boolean delete(int id) {
        return repoImpl.delete(id);
    }

}
