package com.example.e_article.dao;

import com.example.e_article.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {
    public List<Comment> findByPostId(Long postId);//bcz through post i will get many comments
}
