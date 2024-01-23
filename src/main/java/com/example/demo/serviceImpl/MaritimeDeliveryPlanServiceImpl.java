package com.example.demo.serviceImpl;

import com.example.demo.dao.MaritimeDeliveryPlanRepository;
import com.example.demo.dao.PortRepository;
import com.example.demo.entity.Customer;
import com.example.demo.entity.MaritimeDeliveryPlan;
import com.example.demo.entity.Port;
import com.example.demo.entity.TypeProduct;
import com.example.demo.service.CustomerService;
import com.example.demo.service.DeliveryPlanService;
import com.example.demo.service.MaritimeDeliveryService;
import com.example.demo.service.TypeProductService;
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
public class MaritimeDeliveryPlanServiceImpl implements MaritimeDeliveryService {

    private final MaritimeDeliveryPlanRepository repository;
    private final TypeProductService typeProductService;
    private final CustomerService customerService;
    private final PortRepository portRepository;

    @Override
    public List<MaritimeDeliveryPlan> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public MaritimeDeliveryPlan save(MaritimeDeliveryPlan maritimeDeliveryPlan) {

        if (maritimeDeliveryPlan.getProductQuantity() > 10) {
            BigDecimal factor = BigDecimal.valueOf(0.03);
            BigDecimal discount = maritimeDeliveryPlan.getShippingPrice().multiply(factor);
            maritimeDeliveryPlan.setDiscount(discount);
        } else {
            maritimeDeliveryPlan.setDiscount(BigDecimal.valueOf(0));
        }
        maritimeDeliveryPlan.setShippingPrice(maritimeDeliveryPlan.getShippingPrice());

        String guideNumber;
        do {
            guideNumber = GuideNumberGenerator.generateGuideNumber();
        } while (repository.findByGuideNumber(guideNumber).isPresent());

        maritimeDeliveryPlan.setGuideNumber(guideNumber);

        TypeProduct typeProduct = typeProductService.findById(maritimeDeliveryPlan.getTypeProduct().getId());
        maritimeDeliveryPlan.setTypeProduct(typeProduct);

        Customer customer = customerService.findById(maritimeDeliveryPlan.getCustomer().getId());
        maritimeDeliveryPlan.setCustomer(customer);
        Optional<Port> optionalPort = portRepository.findById(maritimeDeliveryPlan.getPort().getId());
        if (optionalPort.isPresent()) {
            maritimeDeliveryPlan.setPort(optionalPort.get());
        } else {
            throw new EntityNotFoundException("Port with ID " + maritimeDeliveryPlan.getPort().getId() + " not found");
        }
        return repository.save(maritimeDeliveryPlan);
    }

    @Override
    public MaritimeDeliveryPlan update(MaritimeDeliveryPlan maritimeDeliveryPlan) {
        Optional<MaritimeDeliveryPlan> maritimeDeliveryPlan1 = repository.findById(maritimeDeliveryPlan.getId());
        if(maritimeDeliveryPlan1.isPresent()) {
            maritimeDeliveryPlan1.get().setProductQuantity(maritimeDeliveryPlan.getProductQuantity());
            maritimeDeliveryPlan1.get().setRegistrationDate(maritimeDeliveryPlan.getRegistrationDate());
            maritimeDeliveryPlan1.get().setDeadLine(maritimeDeliveryPlan.getDeadLine());
            maritimeDeliveryPlan1.get().setShippingPrice(maritimeDeliveryPlan.getShippingPrice());
            maritimeDeliveryPlan1.get().setDiscount(maritimeDeliveryPlan.getDiscount());
            maritimeDeliveryPlan1.get().setGuideNumber(maritimeDeliveryPlan.getGuideNumber());
            maritimeDeliveryPlan1.get().setTypeProduct(maritimeDeliveryPlan.getTypeProduct());
            maritimeDeliveryPlan1.get().setCustomer(maritimeDeliveryPlan.getCustomer());
            maritimeDeliveryPlan1.get().setPort(maritimeDeliveryPlan.getPort());
            maritimeDeliveryPlan1.get().setFleetNumber(maritimeDeliveryPlan.getFleetNumber());
        } else {
            throw new EntityNotFoundException("Port with ID " + maritimeDeliveryPlan.getId() + " not found");
        }
        return maritimeDeliveryPlan;
    }

    @Override
    public MaritimeDeliveryPlan findById(int id) {
        Optional<MaritimeDeliveryPlan> maritimeDeliveryPlan = repository.findById(id);
        if(maritimeDeliveryPlan.isPresent()) {
            return maritimeDeliveryPlan.get();
        } else {
            throw new EntityNotFoundException("Port with ID " + id + " not found");
        }
    }

    @Override
    public void delete(int id) {
        Optional<MaritimeDeliveryPlan> maritimeDeliveryPlan = repository.findById(id);
        if(maritimeDeliveryPlan.isPresent()) {
            repository.delete(maritimeDeliveryPlan.get());
        } else {
            throw new EntityNotFoundException("Port with ID " + id + " not found");
        }
    }

}