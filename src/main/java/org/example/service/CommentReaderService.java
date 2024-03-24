package org.example.service;

public class CommentReaderService {
    private static CommentReaderService commentReaderServiceObject = null;

    public CommentReaderService() {
    }

    public static CommentReaderService instance() {
        if (commentReaderServiceObject == null) {
            commentReaderServiceObject = new CommentReaderService();
        }
        return commentReaderServiceObject;
    }

    public void addCommentFromJsonFile(String path) {

    }
}
