package com.example.e_article.service;

import com.example.e_article.dao.PostDao;
import com.example.e_article.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public Post createPost(Post post){
        return postDao.save(post);
    }

    public Post getPostById(Long id){
        return postDao.findById(id).orElseThrow(() -> new RuntimeException(id + " Not Found"));
    }

    public List<Post> getAllPost(){
        return postDao.findAll();
    }

    public Post updatePost(Post post,Long id){
        if(postDao.findById(id).isPresent()){
            Post newPost = new Post();
            newPost.setId(id);
            newPost.setAuthor(post.getAuthor());
            newPost.setTitle(post.getTitle());
            newPost.setDescription(post.getDescription());

            return postDao.save(newPost);
        }else{
            throw  new RuntimeException(id+" Does not exist ");
        }
    }

    public void deletePostById(Long id){
        if(postDao.findById(id).isPresent()){
            postDao.deleteById(id);
        }else{
            throw new RuntimeException(id+" Does not exist");
        }
    }

}
