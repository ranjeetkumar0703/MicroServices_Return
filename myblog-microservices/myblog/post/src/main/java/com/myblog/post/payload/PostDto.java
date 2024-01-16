package com.myblog.post.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String id;

    private String title;

    private String description;

    private String content;

    private List<Comment> comments;
}
