package org.example.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.mvc.dto.FileDto;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao {

    private final SqlSession sqlSession;

    public FileDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertFile(FileDto fileDto) {
        return sqlSession.insert("File.insertFile", fileDto);
    }
}
