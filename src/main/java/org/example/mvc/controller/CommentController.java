package org.example.mvc.controller;

import org.example.mvc.dto.CommentDto;
import org.example.mvc.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/comment/create", method = RequestMethod.POST)
    public String commentCreate(CommentDto commentDto) {
        int boardId = commentDto.getBoard_seq();
        commentService.insertComment(commentDto);
        return "redirect:/board/" + boardId + "/detail";
    }
}
