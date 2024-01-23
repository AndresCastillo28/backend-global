package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "maritime_delivery_plan")
@Data
public class MaritimeDeliveryPlan extends DeliveryPlan {

    @NotNull(message = "El puerto asociada no puede ser nula")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "port_id", referencedColumnName = "id")
    private Port port;

    @Pattern(regexp = "^[A-Z]{3}\\d{4}[A-Z]$", message = "El número de flota debe tener 3 letras, seguidas de 4 números y finalizar con una letra")
    private String fleetNumber;
}
