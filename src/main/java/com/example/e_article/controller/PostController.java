package com.example.e_article.controller;

import com.example.e_article.entity.Post;
import com.example.e_article.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-article/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody Post post){
        Post response = postService.createPost(post);
        return new ResponseEntity<>("Article Successfully Added "+response.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/getPost/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post response=postService.getPostById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getPosts")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<String> updatePostById(@RequestBody Post post,@PathVariable Long id) {
    Post response = postService.updatePost(post,id);
    return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

}
