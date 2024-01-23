package com.example.demo.restImpl;

import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.entity.Customer;
import com.example.demo.rest.CustomerRest;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerRestImpl implements CustomerRest {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<ApiResponse<Customer>> save(CustomerRequestDTO customerRequestDTO) {
        try {
            Customer newCustomer = customerService.save(customerRequestDTO);
            return ResponseEntity.ok(ApiResponse.success(newCustomer));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
