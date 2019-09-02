package com.gmail.voikyfrenchguy;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {

    HttpListener httpListener;

    @Override
    public void onEnable() {
        super.onEnable();
        try {
            this.setupAndCheckConfig();
        } catch (Exception e) {
            this.getLogger().log(Level.SEVERE, "Config file error: please check your configuration");
        }
        this.httpListener = new HttpListener(this.getConfig().getInt("http_port"), this.getConfig().getString("http_auth_key"));
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
    }
}
