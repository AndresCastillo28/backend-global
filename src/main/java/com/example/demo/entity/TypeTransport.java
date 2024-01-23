package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "type_transport")
@Data
public class TypeTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "El nombre del tipo de transporte no puede estar vacío")
    @Size(max = 100, message = "El nombre del tipo de transporte no puede tener más de 100 caracteres")
    @Column(name = "name")
    private String name;
}
