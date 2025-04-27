package com.zomatoapp;

import com.zomatoapp.model.NonVegFood;
import com.zomatoapp.model.VegFood;
import com.zomatoapp.service.OrderManager;
import com.zomatoapp.utils.PaymentMode;

import java.util.Scanner;

public class ZomatoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderManager manager = new OrderManager();

        VegFood veg1 = new VegFood("Paneer Butter Masala", 250);
        NonVegFood nonVeg1 = new NonVegFood("Chicken Biryani", 350);

        manager.addOrder(veg1);
        manager.addOrder(nonVeg1);

        manager.showAllOrders();

        manager.deliverOrder(100);
        manager.applyCoupon(101, "ZOMATO50");
        manager.simulatePayment(100, PaymentMode.ONLINE);
        manager.cancelOrder(101);

        manager.showAllOrders();

        sc.close();
    }
}
