package org.example.service;

import org.example.model.Post;

import java.util.List;

public class PostTableReaderService {
    private static PostTableReaderService postTableReaderServiceObject = null;

    public PostTableReaderService() {
    }

    public static PostTableReaderService Instance() {
        if(postTableReaderServiceObject == null) {
            postTableReaderServiceObject = new PostTableReaderService();
        }
        return postTableReaderServiceObject;
    }

    public List<Post> read(){

        return null;
    }

    public void write(Post post){

    }
}
