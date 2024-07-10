package com.example.e_article.dao;

import com.example.e_article.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post,Long> {



}
