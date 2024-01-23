package com.example.demo.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TruckerDeliveryPlanRequestDTO {
    private int productQuantity;
    private Date deadLine;
    private BigDecimal shippingPrice;
    private int typeProduct;
    private int customer;
    private int store;
    private String vehiclePlate;
}
