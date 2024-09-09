package com.example.mss1.services;

import com.example.mss1.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoQueryService {
    public Optional<Pedido> getById(String id);
    public List<Object> listEvents(String id);
}
