package com.example.mss1.services;

import com.example.mss1.commands.CriarPedidoCommand;
import com.example.mss1.domain.Pedido;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandServiceImpl implements PedidoComandService{

    @Autowired
    private final CommandGateway commandGateway;

    public PedidoCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> criarPedido(Pedido pedido) {
        return commandGateway.send(new CriarPedidoCommand(
                UUID.randomUUID().toString(),
                pedido.getProduto(),
                pedido.getPreco(),
                pedido.getQuantidade()));

    }


}
