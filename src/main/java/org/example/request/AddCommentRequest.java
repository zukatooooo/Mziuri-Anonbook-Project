package org.example.request;

public class AddCommentRequest {
    private String name;
    private String text;

    public AddCommentRequest(String name, String text) {
        this.name = name;
        this.text = text;
    }
}
