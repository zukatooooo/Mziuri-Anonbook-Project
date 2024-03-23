package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;
    @Column(name = "post_name")
    private String name;

    @Column(name = "post_text")
    private String text;

    @Column(name = "post_image")
    private String image;

    @JsonCreator
    public Post(@JsonProperty("post_id")int id, @JsonProperty("post_name")String name, @JsonProperty("post_text")String text, @JsonProperty("post_image")String image) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.image = image;
    }

    @JsonCreator
    public Post(@JsonProperty("post_id")int id, @JsonProperty("post_name")String name, @JsonProperty("post_text")String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Post() {
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

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
