package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
@Data
public class DeliveryPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Min(value = 1, message = "La cantidad del producto debe ser al menos 1")
    @Column(name = "product_quantity")
    private int productQuantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate = new Date();

    @NotNull(message = "La fecha límite no puede ser nula")
    @Column(name = "dead_line")
    private Date deadLine;

    @NotNull(message = "El precio de envío no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio de envío debe ser mayor a cero")
    @Column(name = "shipping_price")
    private BigDecimal shippingPrice;

    @Column(name = "discount")
    private BigDecimal discount;


    @Size(min = 10, max = 10, message = "El número de guía debe tener 10 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "El número de guía debe ser alfanumérico")
    @Column(name = "guide_number")
    private String guideNumber;

    @NotNull(message = "El tipo de producto asociado no puede ser nulo")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_product_id", referencedColumnName = "id")
    private TypeProduct typeProduct;

    @NotNull(message = "El cliente asociado no puede ser nulo")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
