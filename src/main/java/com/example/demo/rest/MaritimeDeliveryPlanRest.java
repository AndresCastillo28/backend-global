package com.example.demo.rest;

import com.example.demo.entity.MaritimeDeliveryPlan;
import com.example.demo.entity.TruckDeliveryPlan;
import com.example.demo.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/v1/maritime-deliveries")
public interface MaritimeDeliveryPlanRest {

    @PostMapping
    ResponseEntity<ApiResponse<MaritimeDeliveryPlan>> save(@Valid @RequestBody MaritimeDeliveryPlan maritimeDeliveryPlan);

    @PutMapping
    ResponseEntity<ApiResponse<MaritimeDeliveryPlan>> update(@Valid @RequestBody MaritimeDeliveryPlan maritimeDeliveryPlan);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id);

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<MaritimeDeliveryPlan>> findById(@PathVariable int id);

    @GetMapping
    ResponseEntity<ApiResponse<List<MaritimeDeliveryPlan>>> findAll();
}

