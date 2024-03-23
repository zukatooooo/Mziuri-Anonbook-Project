package org.example.service;

public class PostReaderService {
    private static PostReaderService postReaderServiceObject = null;

    public PostReaderService() {
    }

    public static PostReaderService instance(){
        if(postReaderServiceObject == null) {
            postReaderServiceObject = new PostReaderService();
        }
        return postReaderServiceObject;
    }
}
