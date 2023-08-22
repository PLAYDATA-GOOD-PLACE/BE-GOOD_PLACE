package com.example.roty.food.controller;


import com.example.roty.domain.entity.Comment;
import com.example.roty.domain.request.CommentRequest;
import com.example.roty.domain.request.CommentUpdateRequest;
import com.example.roty.domain.response.CommentResponse;
import com.example.roty.food.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<Comment> findAllComment() {
        return commentService.findAllComment();
    }

    @PostMapping()
    public void saveComment(@RequestBody CommentRequest commentRequest) {
        commentService.saveComment(commentRequest);
    }

    @PutMapping("{commentSeq}")
    public CommentResponse updateComment(@PathVariable("commentSeq") Long commentSeq, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.updateComment(commentSeq, commentUpdateRequest);
    }

    @DeleteMapping("{commentSeq}")
    public void deleteComment(@PathVariable("commentSeq") Long commentSeq) {
        commentService.deleteComment(commentSeq);

    }


}
