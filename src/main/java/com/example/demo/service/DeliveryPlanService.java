package com.example.demo.service;
import com.example.demo.entity.DeliveryPlan;

public interface DeliveryPlanService<T extends DeliveryPlan> {
    T saveDeliveryPlan(T deliveryPlan);
}

