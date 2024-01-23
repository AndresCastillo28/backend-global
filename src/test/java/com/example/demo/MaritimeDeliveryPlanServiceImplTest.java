package com.example.demo;

import com.example.demo.dao.MaritimeDeliveryPlanRepository;
import com.example.demo.entity.MaritimeDeliveryPlan;
import com.example.demo.serviceImpl.MaritimeDeliveryPlanServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MaritimeDeliveryPlanServiceImplTest {

    @Mock
    private MaritimeDeliveryPlanRepository repository;

    @InjectMocks
    private MaritimeDeliveryPlanServiceImpl service;

    @Test
    void testFindAll() {
        MockitoAnnotations.openMocks(this);
        when(repository.findAll()).thenReturn(List.of(new MaritimeDeliveryPlan()));
        List<MaritimeDeliveryPlan> result = service.findAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testSave() {
        MockitoAnnotations.openMocks(this);
        MaritimeDeliveryPlan plan = new MaritimeDeliveryPlan();
        plan.setProductQuantity(11);
        plan.setShippingPrice(new BigDecimal("100"));

        when(repository.save(any(MaritimeDeliveryPlan.class))).thenReturn(plan);
        MaritimeDeliveryPlan savedPlan = service.save(plan);

        assertNotNull(savedPlan);
        assertEquals(0, savedPlan.getDiscount().compareTo(new BigDecimal("3.00")));
    }

    @Test
    void testUpdate() {
        MockitoAnnotations.openMocks(this);
        MaritimeDeliveryPlan existingPlan = new MaritimeDeliveryPlan();
        existingPlan.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(existingPlan));
        when(repository.save(any(MaritimeDeliveryPlan.class))).thenReturn(existingPlan);

        MaritimeDeliveryPlan updatedPlan = service.update(existingPlan);

        assertNotNull(updatedPlan);
    }

    @Test
    void testFindById() {
        MockitoAnnotations.openMocks(this);
        MaritimeDeliveryPlan plan = new MaritimeDeliveryPlan();
        plan.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(plan));
        MaritimeDeliveryPlan result = service.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void testDelete() {
        MockitoAnnotations.openMocks(this);
        MaritimeDeliveryPlan plan = new MaritimeDeliveryPlan();
        plan.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(plan));
        doNothing().when(repository).delete(plan);

        assertDoesNotThrow(() -> service.delete(1));
    }

}
