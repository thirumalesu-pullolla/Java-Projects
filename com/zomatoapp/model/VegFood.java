package com.zomatoapp.model;

import com.zomatoapp.service.Deliverable;

public class VegFood extends FoodItem implements Deliverable {
    public VegFood(String name, double price) {
        super(name, price);
    }

    @Override
    public void placeOrder() {
        super.placeOrder();
        System.out.println("Delivering via Green Box for Veg Food...");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Veg Order ID #" + getOrderId() + " delivered successfully!");
        setStatus(com.zomatoapp.utils.OrderStatus.DELIVERED);
    }
}
