package org.example.mvc.service;

import org.example.mvc.dao.CommentDao;
import org.example.mvc.dto.CommentDto;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public int insertComment(CommentDto commentDto) {
        return commentDao.insertComment(commentDto);
    }
}
