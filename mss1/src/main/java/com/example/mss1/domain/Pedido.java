package com.example.mss1.domain;

import com.example.mss1.commands.CriarPedidoCommand;
import com.example.mss1.eventos.PedidoCriado;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Entity
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private String produto;
    private String preco;
    private int quantidade;

    public Pedido() {
    }

    @CommandHandler
    public Pedido(CriarPedidoCommand comando) {
        AggregateLifecycle.apply(new PedidoCriado(comando.id, comando.produto, comando.quantidade, comando.preco));
    }


    @EventSourcingHandler
    protected void on(PedidoCriado evento) {
        this.id = evento.id;
        this.produto = evento.produto;
        this.quantidade = evento.quantidade;
        this.preco = evento.preco;

        AggregateLifecycle.apply(new PedidoCriado(this.id, this.produto, this.quantidade, this.preco));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
