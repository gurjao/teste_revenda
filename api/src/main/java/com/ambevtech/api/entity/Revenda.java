package com.ambevtech.api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "revendas")
public class Revenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String email;

    @OneToMany(mappedBy = "revenda")
    private List<PedidoRevenda> pedidos;

    // Getters e Setters
}