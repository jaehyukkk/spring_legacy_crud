package org.example.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private int commentSeq;
    private String commentDescription;
    private int boardSeq;

    private String test;
}
