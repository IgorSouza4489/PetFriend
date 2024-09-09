package com.example.mss1.eventos;

import java.time.LocalDateTime;

public class PedidoCriado extends BaseEvent<String>{

    public final String produto;
    public final String preco;
    public final int quantidade;

    public PedidoCriado(String id, String produto, int quantidade, String preco) {
        super(id);
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
