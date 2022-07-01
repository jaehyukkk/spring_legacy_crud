package org.example.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private int comment_seq;
    private String comment_description;
    private int board_seq;
}
