package com.ambevtech.api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedidos_revenda")
public class PedidoRevenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "revenda_id")
    private Revenda revenda;

    @ManyToMany
    @JoinTable(
            name = "pedido_revenda_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    // Getters e Setters
}