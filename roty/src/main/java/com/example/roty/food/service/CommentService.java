package com.example.roty.food.service;


import com.example.roty.domain.entity.Comment;
import com.example.roty.food.domain.request.CommentRequest;
import com.example.roty.food.domain.request.CommentUpdateRequest;
import com.example.roty.food.domain.response.CommentResponse;
import com.example.roty.food.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    public void saveComment(CommentRequest commentRequest) {
        commentRepository.save(commentRequest.toEntity());
    }

    public CommentResponse updateComment(Long commentSeq, CommentUpdateRequest commentUpdateRequest) {
        Comment comment = findById(commentSeq);
        comment.update(commentUpdateRequest.getContent());
        return new CommentResponse(comment);
    }

    public void deleteComment(Long commentSeq) {
        commentRepository.deleteById(commentSeq);
    }

    private Comment findById(Long commentSeq) {
        return commentRepository.findById(commentSeq).orElseThrow(()->new RuntimeException());
    }
}
