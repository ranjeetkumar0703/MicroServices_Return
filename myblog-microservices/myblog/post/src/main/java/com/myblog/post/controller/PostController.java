package com.myblog.post.controller;

import com.myblog.post.entity.Post;
import com.myblog.post.payload.PostDto;
import com.myblog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post){

        Post savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);

    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable String postId){
        Post post = postService.getPostById(postId);
        return post;
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostDto> getAllCommentsForParticularPost(@PathVariable String postId){

       PostDto postDto =  postService.getAllCommentsForParticularPost(postId);

       return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
}
