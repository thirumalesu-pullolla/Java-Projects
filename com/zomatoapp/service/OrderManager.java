package com.zomatoapp.service;

import com.zomatoapp.model.FoodItem;
import com.zomatoapp.utils.OrderStatus;
import com.zomatoapp.utils.PaymentMode;

import java.util.*;

public class  OrderManager {
    private List<FoodItem> orders = new ArrayList<>();
    private Map<String, Double> coupons = new HashMap<>();

    public OrderManager() {
        coupons.put("ZOMATO50", 0.5);
        coupons.put("WELCOME10", 0.1);
    }

    public void addOrder(FoodItem food) {
        orders.add(food);
        System.out.println("[SUCCESS] Order added successfully!");
    }

    public void showAllOrders() {
        System.out.println("\n========= All Orders =========");
        for (FoodItem food : orders) {
            System.out.println("Order ID: " + food.getOrderId() +
                    " | " + food.getName() +
                    " | ₹" + food.getPrice() +
                    " | Status: " + food.getStatus());
        }
        System.out.println("===============================\n");
    }

    public void applyCoupon(int orderId, String couponCode) {
        for (FoodItem food : orders) {
            if (food.getOrderId() == orderId) {
                if (coupons.containsKey(couponCode)) {
                    double discount = coupons.get(couponCode);
                    double newPrice = food.getPrice() - (food.getPrice() * discount);
                    System.out.println("[COUPON APPLIED] New price: ₹" + newPrice);
                } else {
                    System.out.println("[INVALID COUPON] No discount applied.");
                }
                return;
            }
        }
        System.out.println("[ERROR] Order not found for applying coupon.");
    }

    public void deliverOrder(int orderId) {
        for (FoodItem food : orders) {
            if (food.getOrderId() == orderId) {
                if (food instanceof Deliverable) {
                    ((Deliverable) food).deliverOrder();
                    return;
                }
            }
        }
        System.out.println("[ERROR] Order not found for delivery.");
    }

    public void cancelOrder(int orderId) {
        for (FoodItem food : orders) {
            if (food.getOrderId() == orderId) {
                food.setStatus(OrderStatus.CANCELLED);
                System.out.println("[CANCELLED] Order ID #" + orderId + " has been cancelled.");
                return;
            }
        }
        System.out.println("[ERROR] Order not found for cancellation.");
    }

    public void simulatePayment(int orderId, PaymentMode paymentMode) {
        for (FoodItem food : orders) {
            if (food.getOrderId() == orderId) {
                System.out.println("[PAYMENT] Payment of ₹" + food.getPrice() + " received via " + paymentMode);
                return;
            }
        }
        System.out.println("[ERROR] Order not found for payment.");
    }
}
