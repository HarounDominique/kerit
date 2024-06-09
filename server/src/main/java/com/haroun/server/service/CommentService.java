package com.haroun.server.service;

import com.haroun.server.model.Comment;
import com.haroun.server.model.User;
import com.haroun.server.repository.ICommentMyBatisRepository;
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

    private final ICommentMyBatisRepository commentMyBatisRepository;;
    @Autowired
    public CommentService(ICommentMyBatisRepository commentMyBatisRepository) {
        this.commentMyBatisRepository = commentMyBatisRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getAllCommentsByUserId(Long id) {
        return commentRepository.findAll();
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
            commentMyBatisRepository.deleteCommentsByUser(userId);
        }
    }
}
