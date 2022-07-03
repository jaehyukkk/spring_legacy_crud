package org.example.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.mvc.dto.BoardDto;
import org.example.mvc.dto.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDao {

    private final SqlSession sqlSession;

    public BoardDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertBoard(BoardDto boardDto) {
        sqlSession.insert("Board.insertBoard", boardDto);
        return boardDto.getSeq();
    }

    public List<BoardDto> getBoardList() {
        return sqlSession.selectList("Board.getBoardList");
    }

    public List<BoardDto> getListWithPaging(Criteria criteria) {
        return sqlSession.selectList("Board.getListWithPaging", criteria);
    }

    public int boardTotalRecord() {
        return sqlSession.selectOne("Board.totalRecord");
    }

    public BoardDto getBoardByCommentList(int seq) {
        return sqlSession.selectOne("Board.getBoardById", seq);
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
