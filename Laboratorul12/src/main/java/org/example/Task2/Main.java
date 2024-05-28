package org.example.Task2;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

import static org.example.Task2.HttpClient.createPost;
import static org.example.Task2.HttpClient.getPostById;

public class Main {
    public static void main(String[] args) {
        try {
            int id = new Random().nextInt(100) + 1;
            getPostById(id);

            JSONObject newPost = new JSONObject();
            newPost.put("userId", 1);
            newPost.put("title", "Sample Title");
            newPost.put("body", "Sample body");
            createPost(newPost);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
