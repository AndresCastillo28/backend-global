package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "store")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "El nombre de la tienda no puede estar vacío")
    @Size(max = 100, message = "El nombre de la tienda no puede tener más de 100 caracteres")
    @Column(name = "name")
    private String name;

    @NotNull(message = "El nivel de alcance no puede ser nulo")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_scope_level", referencedColumnName = "id")
    private ScopeLevel scopeLevel;
}