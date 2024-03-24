package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.config.CommentConfig;
import org.example.model.Comment;
import org.example.model.Post;

import java.io.File;
import java.io.IOException;

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
        try {
            File jsonFile = new File(path);
            ObjectMapper objectMapper = new ObjectMapper();
            CommentConfig commentConfig = objectMapper.readValue(jsonFile, CommentConfig.class);

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            for (int i = 0; i < commentConfig.getComments().length; i++){
                System.out.println(commentConfig.getComments()[i].toString());
                Comment comment = new Comment(commentConfig.getComments()[i].getId(), commentConfig.getComments()[i].getName(), commentConfig.getComments()[i].getText(), commentConfig.getComments()[i].getPostId());
                Comment managedComment = entityManager.merge(comment);
                entityManager.persist(managedComment);
            }

            entityTransaction.commit();

            entityManager.close();
            entityManagerFactory.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
