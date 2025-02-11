package com.ambevtech.api.repository;

import com.ambevtech.api.entity.PedidoRevenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRevendaRepository extends JpaRepository<PedidoRevenda, Long> {}