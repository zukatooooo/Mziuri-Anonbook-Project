package org.example.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.model.Post;

public class PostConfig {
    private Post[] posts;

    @JsonCreator
    public PostConfig(@JsonProperty("posts")Post[] posts) {
        this.posts = posts;
    }

    public PostConfig() {
    }

    public Post[] getPosts() {
        return posts;
    }
}
