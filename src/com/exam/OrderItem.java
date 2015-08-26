package com.exam;

/**
 * Created by root on 8/26/15.
 */
public final class OrderItem {
    private final Item item;
    private final Integer quantity;

    public OrderItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
