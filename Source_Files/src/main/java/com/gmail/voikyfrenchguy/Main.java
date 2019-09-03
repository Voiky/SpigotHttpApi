package com.gmail.voikyfrenchguy;

import com.gmail.voikyfrenchguy.server.HttpListener;
import com.gmail.voikyfrenchguy.utils.TaskExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {

    TaskExecutor taskExecutor;
    HttpListener httpListener;

    @Override
    public void onEnable() {
        super.onEnable();
        try {
            this.setupAndCheckConfig();
        } catch (Exception e) {
            this.getLogger().log(Level.SEVERE, "Config file error: please check your configuration");
        }
        this.taskExecutor = new TaskExecutor((JavaPlugin) this);
        this.httpListener = new HttpListener(this.getConfig().getInt("http_port"), this.getConfig().getString("http_auth_key"), this.taskExecutor);
    }

    private void setupAndCheckConfig() throws Exception {
        this.saveDefaultConfig();
        if (!this.getConfig().contains("http_port") || !this.getConfig().contains("http_auth_key")) {
            throw new Exception();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.httpListener.stop();
    }
}
