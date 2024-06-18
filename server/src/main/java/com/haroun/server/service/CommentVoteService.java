package com.haroun.server.service;

import com.haroun.server.model.CommentVote;
import com.haroun.server.repository.ICommentVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CommentVoteService {

    @Autowired
    private ICommentVoteRepository commentVoteRepository;

    public List<CommentVote> getAllCommentVotes() {
        return commentVoteRepository.findAll();
    }

    public CommentVote getCommentVoteById(Long id) {
        return commentVoteRepository.findById(id).orElse(null);
    }

    @Transactional
    public CommentVote createCommentVote(CommentVote commentVote) {
        return commentVoteRepository.save(commentVote);
    }

    @Transactional
    public void deleteCommentVote(Long id) {
        commentVoteRepository.deleteById(id);
    }

    @Transactional
    public void deleteCommentVotesByComment(Long commentId) {
        commentVoteRepository.deleteByCommentId(commentId);
    }

    @Transactional
    public void deleteCommentVotesByUser(Long userId) {
        commentVoteRepository.deleteByUserId(userId);
    }
}
