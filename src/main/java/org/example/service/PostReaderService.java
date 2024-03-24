package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Post;
import org.example.model.PostConfig;

import java.io.File;
import java.io.IOException;

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

    public void addPostFromJsonFile(String path) {
        try {
            File jsonFile = new File(path);
            ObjectMapper objectMapper = new ObjectMapper();
            PostConfig postConfig = objectMapper.readValue(jsonFile, PostConfig.class);

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            for (int i = 0; i < postConfig.getPosts().length; i++){
                System.out.println(postConfig.getPosts()[i].toString());
                Post post = new Post(postConfig.getPosts()[i].getId(), postConfig.getPosts()[i].getName(), postConfig.getPosts()[i].getText(), postConfig.getPosts()[i].getImage());
                Post managedPost = entityManager.merge(post);
                entityManager.persist(managedPost);
            }

            entityTransaction.commit();

            entityManager.close();
            entityManagerFactory.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
