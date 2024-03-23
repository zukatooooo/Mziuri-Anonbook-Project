package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @Column(name = "comment_name")
    private String name;

    @Column(name = "comment_text")
    private String text;

    @Column(name = "post_id")
    private int postId;

    @JsonCreator
    public Comment(@JsonProperty("comment_id")int id, @JsonProperty("comment_name")String name, @JsonProperty("comment_text")String text, @JsonProperty("post_id")int postId) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.postId = postId;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", postId=" + postId +
                '}';
    }
}
