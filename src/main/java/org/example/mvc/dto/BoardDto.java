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
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private String writer;
    private List<CommentDto> comments;
}
