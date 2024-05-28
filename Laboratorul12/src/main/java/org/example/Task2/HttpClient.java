package org.example.Task2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class HttpClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final java.net.http.HttpClient httpClient = java.net.http.HttpClient.newHttpClient();

    public static void getPostById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET Response:");
        System.out.println(response.body());
    }

    public static void createPost(JSONObject post) throws IOException, InterruptedException {
        String requestBody = post.toString();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("POST Request:");
        System.out.println(requestBody);

        System.out.println("POST Response:");
        System.out.println(response.body());
    }
}
