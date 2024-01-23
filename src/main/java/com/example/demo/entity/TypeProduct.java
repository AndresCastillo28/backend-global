package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "type_product")
@Data
public class TypeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "El nombre del tipo de producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del tipo de producto no puede tener más de 100 caracteres")
    @Column(name = "name")
    private String name;

    @NotNull(message = "El tipo de transporte asociado no puede ser nulo")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_transport_id", referencedColumnName = "id")
    private TypeTransport typeTransport;

}
