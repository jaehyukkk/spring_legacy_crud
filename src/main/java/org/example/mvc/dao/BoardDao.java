package org.example.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.mvc.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    private final SqlSession sqlSession;

    public BoardDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertBoard(BoardDto boardDto) {
        return sqlSession.insert("Board.insertBoard", boardDto);
    }

    public List<BoardDto> getBoardList() {
        return sqlSession.selectList("Board.getBoardList");
    }

    public BoardDto getBoard(int seq) {
        return sqlSession.selectOne("Board.getBoard", seq);
    }

    public void deleteBoard(int seq) {
        sqlSession.delete("Board.deleteBoard", seq);
    }

    public void editBoard(BoardDto boardDto) {
        sqlSession.update("Board.editBoard", boardDto);
    }

}
