package com.gmail.voikyfrenchguy.server;

import com.gmail.voikyfrenchguy.server.interfaces.NewVote;
import com.gmail.voikyfrenchguy.utils.TaskExecutor;
import com.gmail.voikyfrenchguy.utils.entities.ItemRef;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Request;

import static spark.Spark.*;


public class HttpListener {
    private final int port;
    private final String authKey;
    private final TaskExecutor taskExecutor;

    public HttpListener(int httpPort, String httpAuthKey, TaskExecutor taskExecutor) {
        this.port = httpPort;
        this.authKey = httpAuthKey;
        this.taskExecutor = taskExecutor;

        this.startRouting();
    }

    private void startRouting() {
        path("/mine-api", () -> {
            path("/vote", () -> {
                post("/new", (request, response) -> {
                    Gson gson = new GsonBuilder().create();
                    NewVote body = gson.fromJson(request.body(), NewVote);
                    ItemRef item = new ItemRef();
                });
            });
        });
    }


    public void stopListener() {
        stop();
    }
}
