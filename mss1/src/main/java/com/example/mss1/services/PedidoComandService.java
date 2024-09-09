package com.example.mss1.services;

import com.example.mss1.domain.Pedido;

import java.util.concurrent.CompletableFuture;

public interface PedidoComandService {
    public CompletableFuture<String> criarPedido(Pedido pedido);

}
