package com.example.demo;

import com.example.demo.dao.TruckDeliveryPlanRepository;
import com.example.demo.entity.TruckDeliveryPlan;
import com.example.demo.service.CustomerService;
import com.example.demo.service.StoreService;
import com.example.demo.service.TypeProductService;
import com.example.demo.serviceImpl.TruckDeliveryPlanServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TruckDeliveryPlanServiceImplTest {

    @Mock
    private TruckDeliveryPlanRepository repository;
    @Mock
    private TypeProductService typeProductService;
    @Mock
    private CustomerService customerService;
    @Mock
    private StoreService storeService;

    @InjectMocks
    private TruckDeliveryPlanServiceImpl service;

    @Test
    void testFindAll() {
        MockitoAnnotations.openMocks(this);
        when(repository.findAll()).thenReturn(List.of(new TruckDeliveryPlan()));
        List<TruckDeliveryPlan> result = service.findAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testSave() {
        MockitoAnnotations.openMocks(this);
        TruckDeliveryPlan plan = new TruckDeliveryPlan();
        plan.setProductQuantity(11);
        plan.setShippingPrice(new BigDecimal("100"));

        when(repository.save(any(TruckDeliveryPlan.class))).thenReturn(plan);
        TruckDeliveryPlan savedPlan = service.save(plan);

        assertNotNull(savedPlan);
        assertEquals(0, savedPlan.getDiscount().compareTo(new BigDecimal("5.00")));
    }

    @Test
    void testUpdate() {
        MockitoAnnotations.openMocks(this);
        TruckDeliveryPlan existingPlan = new TruckDeliveryPlan();
        existingPlan.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(existingPlan));
        when(repository.save(any(TruckDeliveryPlan.class))).thenReturn(existingPlan);

        TruckDeliveryPlan updatedPlan = service.update(existingPlan);

        assertNotNull(updatedPlan);
    }

    @Test
    void testFindById() {
        MockitoAnnotations.openMocks(this);
        TruckDeliveryPlan plan = new TruckDeliveryPlan();
        plan.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(plan));
        TruckDeliveryPlan result = service.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void testDelete() {
        MockitoAnnotations.openMocks(this);
        TruckDeliveryPlan plan = new TruckDeliveryPlan();
        plan.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(plan));
        doNothing().when(repository).delete(plan);

        assertDoesNotThrow(() -> service.delete(1));
    }
}
