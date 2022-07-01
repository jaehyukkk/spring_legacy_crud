package org.example.mvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
