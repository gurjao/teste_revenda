package com.ambevtech.api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoCliente> pedidos;

    // Getters e Setters
}