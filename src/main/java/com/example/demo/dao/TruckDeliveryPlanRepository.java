package com.example.demo.dao;

import com.example.demo.entity.TruckDeliveryPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TruckDeliveryPlanRepository extends JpaRepository<TruckDeliveryPlan, Integer> {

    Optional<TruckDeliveryPlan> findByGuideNumber(String guideNumber);
}
