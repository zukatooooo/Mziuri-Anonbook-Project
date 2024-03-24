package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
