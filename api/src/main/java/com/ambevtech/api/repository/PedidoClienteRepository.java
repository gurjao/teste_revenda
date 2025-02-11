package com.ambevtech.api.repository;

import com.ambevtech.api.entity.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoClienteRepository extends JpaRepository<PedidoCliente, Long> {}