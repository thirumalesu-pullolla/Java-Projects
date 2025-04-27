package com.zomatoapp.model;

import com.zomatoapp.service.Deliverable;

public class NonVegFood extends FoodItem implements Deliverable {
    public NonVegFood(String name, double price) {
        super(name, price);
    }

    @Override
    public void placeOrder() {
        super.placeOrder();
        System.out.println("Delivering via Red Box for Non-Veg Food...");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Non-Veg Order ID #" + getOrderId() + " delivered successfully!");
        setStatus(com.zomatoapp.utils.OrderStatus.DELIVERED);
    }
}
