package com.myblog.comment.service;

import com.myblog.comment.config.RestTemplateConfig;
import com.myblog.comment.entity.Comment;
import com.myblog.comment.payload.Post;
import com.myblog.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RestTemplateConfig restTemplate;


    public Comment saveComment(Comment comment){

        //Check whether the post exist if yes the save the comment or else throws exception

       Post post = restTemplate.getRestTemplate().getForObject("http://POST-SERVICE/api/post/" + comment.getPostId(), Post.class);

       if(post!=null) {

           String radomCommentId = UUID.randomUUID().toString();
           comment.setCommentId(radomCommentId);
           comment.setPostId(post.getId());
           Comment savedComment = commentRepository.save(comment);
           return savedComment;
       }
       return null;
    }

    public List<Comment> getCommentByPostId(String postId){
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;
    }
}
