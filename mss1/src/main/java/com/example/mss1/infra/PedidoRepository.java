package com.example.mss1.infra;

import com.example.mss1.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
