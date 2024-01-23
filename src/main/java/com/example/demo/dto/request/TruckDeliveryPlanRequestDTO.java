package com.example.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckDeliveryPlanRequestDTO {

    private int productQuantity;
    private Date registrationDate;
    private Date deadLine;
    private BigDecimal shippingPrice;
    private String guideNumber;
    private int typeProductId; // ID del tipo de producto
    private int customerId; // ID del cliente
    private int storeId; // ID de la bodega
    private String vehiclePlate;
}
