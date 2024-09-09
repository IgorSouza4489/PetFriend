package com.example.mss1.commands;


public class CriarPedidoCommand extends BaseCommand<String> {

    public String produto;
    public String preco;
    public int quantidade;

    public CriarPedidoCommand(String id, String produto, String preco, int quantidade) {
        super(id);
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
