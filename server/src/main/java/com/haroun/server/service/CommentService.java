package com.haroun.server.service;

import com.haroun.server.model.Comment;
import com.haroun.server.model.User;
import com.haroun.server.repository.ICommentRepository;
import com.haroun.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Autowired
    private IUserRepository userRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getAllCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    public void deleteCommentsByUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            commentRepository.deleteByUserId(userId);
        }
    }
}
