package com.example.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaritimeDeliveryPlanRequestDTO {
    private int productQuantity;
    private Date registrationDate;
    private Date deadLine;
    private BigDecimal shippingPrice;
    private String guideNumber;
    private int typeProductId;
    private int customerId;
    private int portId;
    private String fleetNumber;
}
