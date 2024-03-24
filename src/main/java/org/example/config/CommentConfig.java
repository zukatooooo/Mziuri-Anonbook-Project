package org.example.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.model.Comment;

import java.util.Arrays;

public class CommentConfig {
    private Comment[] comments;

    @JsonCreator
    public CommentConfig(@JsonProperty("comments")Comment[] comments) {
        this.comments = comments;
    }

    public CommentConfig() {
    }

    public Comment[] getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "CommentConfig{" +
                "comments=" + Arrays.toString(comments) +
                '}';
    }
}
