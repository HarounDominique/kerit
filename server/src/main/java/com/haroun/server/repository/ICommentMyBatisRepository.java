package com.haroun.server.repository;

import com.haroun.server.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICommentMyBatisRepository {

    //List<Comment> findAll();

    Comment deleteCommentsByUser(Long id);
}
