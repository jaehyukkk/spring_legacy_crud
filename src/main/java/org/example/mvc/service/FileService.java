package org.example.mvc.service;

import org.example.mvc.dao.FileDao;
import org.example.mvc.dto.FileDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {
    private final FileDao fileDao;

    public FileService(FileDao fileDao){
        this.fileDao = fileDao;
    }
    static final String filePath = "/Users/jangjaehyeog/Documents/springFile";

    public int insertFile(MultipartFile file, int boardSeq) throws IOException {
        String uuid = UUID.randomUUID().toString();
        String origFilename = file.getOriginalFilename();
        String filename = uuid + origFilename;
        File converFile = new File(filePath, filename);
        file.transferTo(converFile);

        FileDto fileDto = FileDto.builder()
                .filePath(filePath)
                .originalFilename(origFilename)
                .filename(filename)
                .boardSeq(boardSeq)
                .build();

        return fileDao.insertFile(fileDto);
    }
}
