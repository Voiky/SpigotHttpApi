package com.gmail.voikyfrenchguy.utils;

import com.gmail.voikyfrenchguy.utils.entities.ItemRef;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TaskExecutor {
    private JavaPlugin plugin;

    public enum TaskResponse {
        INTERNAL_ERROR,
        USER_NOT_FOUND,
        USER_NOT_CONNECTED,
        ITEM_NOT_EXIST,
        SUCCESS
    };

    public TaskExecutor(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public TaskResponse newVote(String playerName, ItemRef item) {
        // First work for future feature doesn't work don't use it
        Object itemConfig;
        if (item.getItemConfig() != null) {
            itemConfig = getConfigItem(item.getItemConfig());
        }

        if (Material.matchMaterial(item.getItemId()) == null) {
            return TaskResponse.ITEM_NOT_EXIST;
        }

        if (this.plugin.getServer().getPlayerExact(playerName) == null) {
            return TaskResponse.USER_NOT_CONNECTED;
        }

        try {

            this.plugin.getServer().getPlayer(playerName).getInventory().addItem(new ItemStack(Material.matchMaterial(item.getItemId()), item.getQuantity()));
        } catch (Exception e) {
            this.plugin.getLogger().log(Level.SEVERE, "Error occured when giving " + item.getQuantity() + " " + item.getItemId() + " to " + playerName + " after voted.");
        }

        return TaskResponse.SUCCESS;
    }

    private Object getConfigItem(String name) {
        if (this.plugin.getConfig().get(name) != null) {
            return this.plugin.getConfig().get("item-config." + name);
        }

        return null;
    }
}
