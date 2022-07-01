package org.example.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.mvc.dto.CommentDto;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {

    private final SqlSession sqlSession;

    public CommentDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertComment(CommentDto commentDto) {
        return sqlSession.insert("Comment.insertComment", commentDto);
    }

}
