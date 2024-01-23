package com.example.demo.service;

import com.example.demo.dto.request.TruckDeliveryPlanRequestDTO;
import com.example.demo.entity.MaritimeDeliveryPlan;
import com.example.demo.entity.TruckDeliveryPlan;

import java.util.List;

public interface TruckDeliveryService {

    List<TruckDeliveryPlan> findAll();
    TruckDeliveryPlan save(TruckDeliveryPlan truckDeliveryPlan);
    TruckDeliveryPlan update(TruckDeliveryPlan maritimeDeliveryPlan);

    TruckDeliveryPlan findById(int id);
    void delete(int id);
}
