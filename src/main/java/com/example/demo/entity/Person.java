package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "La cédula no puede estar vacía")
    @Column(name = "cedula")
    private String cedula;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "El número de teléfono no puede estar vacío")
    @Column(name = "phone_number")
    private String phoneNumber;

}
