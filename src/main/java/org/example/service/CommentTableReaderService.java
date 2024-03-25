package org.example.service;

import org.example.model.Comment;

import java.util.List;

public class CommentTableReaderService {
    private static CommentReaderService commentReaderServiceObject = null;

    public CommentTableReaderService() {
    }

    public static CommentReaderService instance() {
        if(commentReaderServiceObject == null) {
            commentReaderServiceObject = new CommentReaderService();
        }
        return commentReaderServiceObject;
    }

    public List<Comment> read() {
        return null;
    }

    public void write(Comment comment){

    }
}
