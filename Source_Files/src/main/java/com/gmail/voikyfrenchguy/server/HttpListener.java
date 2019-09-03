package com.gmail.voikyfrenchguy.server;

import com.gmail.voikyfrenchguy.utils.TaskExecutor;

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
    }


    public void stop() {
    }
}
