package com.ambevtech.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;

    // Getters e Setters
}