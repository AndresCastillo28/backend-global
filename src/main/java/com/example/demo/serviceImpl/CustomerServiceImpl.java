package com.example.demo.serviceImpl;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Person;
import com.example.demo.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer save(CustomerRequestDTO customerRequestDTO) {

        Customer customer = convertToCustomer(customerRequestDTO);
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            // Lanzar una excepción o manejar el caso de "no encontrado" como lo consideres adecuado
            throw new EntityNotFoundException("Customer no encontrado con ID: " + id);
        }
    }

    public Customer convertToCustomer(CustomerRequestDTO customerRequestDTO) {

        Person person = new Person();
        person.setName(customerRequestDTO.getName());
        person.setLastName(customerRequestDTO.getLastName());
        person.setPhoneNumber(customerRequestDTO.getPhoneNumber());
        person.setCedula(customerRequestDTO.getCedula());

        Customer customer = new Customer();

        customer.setPerson(person);
        return customer;
    }

}

