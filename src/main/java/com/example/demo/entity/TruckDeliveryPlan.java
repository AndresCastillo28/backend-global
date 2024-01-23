package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "truck_delivery_plan")
@Data
public class TruckDeliveryPlan extends DeliveryPlan {

    @NotNull(message = "La bodega asociada no puede ser nula")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @Pattern(regexp = "^[A-Z]{3}\\d{3}$", message = "La placa debe tener 3 letras seguidas de 3 números")
    private String vehiclePlate;
}
