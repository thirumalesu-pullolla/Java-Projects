package com.zomatoapp.model;

import com.zomatoapp.utils.OrderStatus;

public abstract class FoodItem {
    private static int idCounter = 100;
    private final int orderId;
    private String name;
    private double price;
    private OrderStatus status;

    public FoodItem(String name, double price) {
        this.orderId = idCounter++;
        this.name = name;
        this.price = price;
        this.status = OrderStatus.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void placeOrder() {
        System.out.println("Order ID #" + orderId + ": " + name + " | ₹" + price);
    }
}
