package com.gmail.voikyfrenchguy.utils.entities;

public class ItemRef {
    private int quantity;
    private String itemId;
    private String itemConfig;

    //@TODO: check quantitity > 0
    public ItemRef(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public ItemRef(String itemId, int quantity, String itemConfig) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemConfig = itemConfig;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemConfig() {
        return itemConfig;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
