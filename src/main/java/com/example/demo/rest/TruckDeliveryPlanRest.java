package com.example.demo.rest;

import com.example.demo.entity.MaritimeDeliveryPlan;
import com.example.demo.entity.TruckDeliveryPlan;
import com.example.demo.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/truck-deliveries")
public interface TruckDeliveryPlanRest {

    @PostMapping
    ResponseEntity<ApiResponse<TruckDeliveryPlan>> save(@Valid @RequestBody(required = true) TruckDeliveryPlan truckDeliveryPlan);

    @PutMapping
    ResponseEntity<ApiResponse<TruckDeliveryPlan>> update(@Valid @RequestBody TruckDeliveryPlan truckDeliveryPlan);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id);

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<TruckDeliveryPlan>> findById(@PathVariable int id);

    @GetMapping
    ResponseEntity<ApiResponse<List<TruckDeliveryPlan>>> findAll();

}
