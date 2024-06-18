package com.haroun.server.controller;

import com.haroun.server.model.CommentVote;
import com.haroun.server.service.CommentVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment-votes")
public class CommentVoteController {

    @Autowired
    private CommentVoteService commentVoteService;

    @GetMapping
    public List<CommentVote> getAllCommentVotes() {
        return commentVoteService.getAllCommentVotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentVote> getCommentVoteById(@PathVariable Long id) {
        CommentVote commentVote = commentVoteService.getCommentVoteById(id);
        return commentVote != null ? ResponseEntity.ok(commentVote) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CommentVote createCommentVote(@RequestBody CommentVote commentVote) {
        return commentVoteService.createCommentVote(commentVote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentVote(@PathVariable Long id) {
        commentVoteService.deleteCommentVote(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<Void> deleteCommentVotesByComment(@PathVariable Long commentId) {
        commentVoteService.deleteCommentVotesByComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteCommentVotesByUser(@PathVariable Long userId) {
        commentVoteService.deleteCommentVotesByUser(userId);
        return ResponseEntity.noContent().build();
    }
}
