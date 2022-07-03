package org.example.mvc.controller;

import org.example.mvc.dto.BoardDto;
import org.example.mvc.dto.Criteria;
import org.example.mvc.dto.PageDto;
import org.example.mvc.service.BoardService;
import org.example.mvc.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

   private final BoardService boardService;
   private final FileService fileService;

    public HomeController(BoardService boardService, FileService fileService) {
        this.boardService = boardService;
        this.fileService = fileService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/board")
    public String getBoardList(Criteria criteria, Model model) {
        int totalRecord = boardService.getBoardTotalRecord();
        model.addAttribute("list", boardService.getListWithPaging(criteria));
        model.addAttribute("pageMaker", new PageDto(criteria, totalRecord));
        return "board/list";
    }

    @RequestMapping(value = "/board/store", method = RequestMethod.POST)
    public String boardInsert(@Valid BoardDto boardDto, @RequestParam MultipartFile file) throws IOException {
        int boardSeq = boardService.insertBoard(boardDto,file);
//        fileService.insertFile(file, boardSeq);
        return "redirect:/board";
    }

    @RequestMapping(value = "board/create", method = RequestMethod.GET)
    public String boardCreate(){
        return "board/create";
    }

    @RequestMapping(value = "board/{seq}/detail", method = RequestMethod.GET)
    public String boardDetail(@PathVariable("seq") int seq, Model model) {
        model.addAttribute("board", boardService.getBoardByCommentList(seq));
        return "board/detail";
    }

    @ResponseBody
    @RequestMapping(value = "board/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteBoard(@RequestParam("seq") int seq) {
        boardService.deleteBoard(seq);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "board/{seq}/update", method = RequestMethod.GET)
    public String updateBoard(@PathVariable("seq") int seq, Model model) {
        model.addAttribute("board", boardService.getBoard(seq));
        return "board/update";
    }

    @RequestMapping(value = "board/edit", method= RequestMethod.POST)
    public String editBoard(BoardDto boardDto) {
        System.out.println(boardDto.getTitle());
        boardService.editBoard(boardDto);
        return "redirect:/board";
    }

}
