package com.example.demo.service;

import com.example.demo.entity.MaritimeDeliveryPlan;

import java.util.List;

public interface MaritimeDeliveryService {

    List<MaritimeDeliveryPlan> findAll();

    MaritimeDeliveryPlan save(MaritimeDeliveryPlan maritimeDeliveryPlan);

    MaritimeDeliveryPlan update(MaritimeDeliveryPlan maritimeDeliveryPlan);

    MaritimeDeliveryPlan findById(int id);

    void delete(int id);
}
