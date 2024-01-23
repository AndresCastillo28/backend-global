package com.example.demo.serviceImpl;

import com.example.demo.dao.PortRepository;
import com.example.demo.dao.TruckDeliveryPlanRepository;
import com.example.demo.dto.request.TruckDeliveryPlanRequestDTO;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.utils.GuideNumberGenerator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TruckDeliveryPlanServiceImpl implements TruckDeliveryService {

    private final TruckDeliveryPlanRepository repository;
    private final TypeProductService typeProductService;
    private final CustomerService customerService;
    private final StoreService storeService;

    @Override
    public List<TruckDeliveryPlan> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public TruckDeliveryPlan save(TruckDeliveryPlan truckDeliveryPlan) {

        if (truckDeliveryPlan.getProductQuantity() > 10) {
            BigDecimal factor = BigDecimal.valueOf(0.05);
            BigDecimal discount = truckDeliveryPlan.getShippingPrice().multiply(factor);
            truckDeliveryPlan.setDiscount(discount);
        } else {
            truckDeliveryPlan.setDiscount( BigDecimal.valueOf(0) );
        }
        truckDeliveryPlan.setShippingPrice(truckDeliveryPlan.getShippingPrice());

        String guideNumber;
        do {
            guideNumber = GuideNumberGenerator.generateGuideNumber();
        } while (repository.findByGuideNumber(guideNumber).isPresent());

        truckDeliveryPlan.setGuideNumber(guideNumber);

        TypeProduct typeProduct = typeProductService.findById(truckDeliveryPlan.getTypeProduct().getId());
        truckDeliveryPlan.setTypeProduct(typeProduct);

        Customer customer = customerService.findById(truckDeliveryPlan.getCustomer().getId());
        truckDeliveryPlan.setCustomer(customer);
        Store store = storeService.findById(truckDeliveryPlan.getStore().getId());
        truckDeliveryPlan.setStore(store);

        return repository.save(truckDeliveryPlan);
    }

    @Override
    public TruckDeliveryPlan update(TruckDeliveryPlan truckDeliveryPlan) {
        Optional<TruckDeliveryPlan> truckDeliveryPlan1 = repository.findById(truckDeliveryPlan.getId());
        if(truckDeliveryPlan1.isPresent()) {
            truckDeliveryPlan1.get().setProductQuantity(truckDeliveryPlan.getProductQuantity());
            truckDeliveryPlan1.get().setRegistrationDate(truckDeliveryPlan.getRegistrationDate());
            truckDeliveryPlan1.get().setDeadLine(truckDeliveryPlan.getDeadLine());
            truckDeliveryPlan1.get().setShippingPrice(truckDeliveryPlan.getShippingPrice());
            truckDeliveryPlan1.get().setDiscount(truckDeliveryPlan.getDiscount());
            truckDeliveryPlan1.get().setGuideNumber(truckDeliveryPlan.getGuideNumber());
            truckDeliveryPlan1.get().setTypeProduct(truckDeliveryPlan.getTypeProduct());
            truckDeliveryPlan1.get().setCustomer(truckDeliveryPlan.getCustomer());
            truckDeliveryPlan1.get().setStore(truckDeliveryPlan.getStore());
            truckDeliveryPlan1.get().setVehiclePlate(truckDeliveryPlan.getVehiclePlate());
        } else {
            throw new EntityNotFoundException("Port with ID " + truckDeliveryPlan.getId() + " not found");
        }
        return truckDeliveryPlan;
    }

    @Override
    public TruckDeliveryPlan findById(int id) {
        Optional<TruckDeliveryPlan> truckDeliveryPlan = repository.findById(id);
        if(truckDeliveryPlan.isPresent()) {
            return truckDeliveryPlan.get();
        } else {
            throw new EntityNotFoundException("Port with ID " + id + " not found");
        }
    }

    @Override
    public void delete(int id) {
        Optional<TruckDeliveryPlan> truckDeliveryPlan = repository.findById(id);
        if(truckDeliveryPlan.isPresent()) {
            repository.delete(truckDeliveryPlan.get());
        } else {
            throw new EntityNotFoundException("Port with ID " + id + " not found");
        }
    }
}
