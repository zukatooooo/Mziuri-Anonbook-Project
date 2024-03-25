package org.example.request;

public class AddPostRequest {
    private String name;
    private String text;
    private String image;

    public AddPostRequest(String name, String text, String image) {
        this.name = name;
        this.text = text;
        this.image = image;
    }
}
