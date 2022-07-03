package org.example.mvc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileDto {

    private int fileSeq;
    private String originalFilename;
    private String filename;
    private int boardSeq;
    private String filePath;

    @Builder
    public FileDto(String originalFilename, String filename, int boardSeq, String filePath) {
        this.originalFilename = originalFilename;
        this.filename = filename;
        this.boardSeq = boardSeq;
        this.filePath = filePath;
    }
}
