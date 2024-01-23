package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.MaritimeDeliveryPlan;

import java.util.Optional;

public interface MaritimeDeliveryPlanRepository extends JpaRepository<MaritimeDeliveryPlan, Integer> {

    Optional<MaritimeDeliveryPlan> findByGuideNumber(String guideNumber);
}
