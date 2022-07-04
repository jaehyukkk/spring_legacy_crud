package org.example.mvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class BoardDto {

    private int seq;
    private String title;
    private String description;
    private String writer;
    private List<CommentDto> comments;
    private List<FileDto> files;

    private String test;
}
