package org.example.mvc.service;

import org.example.mvc.dao.BoardDao;
import org.example.mvc.dto.BoardDto;
import org.example.mvc.dto.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    public final BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public int insertBoard(BoardDto boardDto) {
        return boardDao.insertBoard(boardDto);
    }

    public List<BoardDto> getBoardList() {
        return boardDao.getBoardList();
    }

    public BoardDto getBoard(int seq) {
        return boardDao.getBoard(seq);
    }

    public List<BoardDto> getListWithPaging(Criteria criteria) {
        return boardDao.getListWithPaging(criteria);
    }

    public int getBoardTotalRecord() {
        return boardDao.boardTotalRecord();
    }

    public BoardDto getBoardByCommentList(int seq) {
        return boardDao.getBoardByCommentList(seq);
    }

    public void deleteBoard(int seq) {
        boardDao.deleteBoard(seq);
    }

    public void editBoard(BoardDto boardDto) {
        boardDao.editBoard(boardDto);
    }
}
