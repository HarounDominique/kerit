package com.haroun.server.repository;

import com.haroun.server.model.CommentVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentVoteRepository extends JpaRepository<CommentVote, Long> {
    void deleteByCommentId(Long commentId);
    void deleteByUserId(Long userId);
}
