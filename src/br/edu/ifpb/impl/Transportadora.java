package br.edu.ifpb.impl;

import br.edu.ifpb.Pedido;
import br.edu.ifpb.State;
import br.edu.ifpb.impl.Recebido;

public class Transportadora implements State {
    private Pedido pedido;

    public Transportadora(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void enviarPedido() {
        System.out.println("Enviando pedido para o cliente....");
        pedido.setState(new Recebido(this.pedido));
    }

    @Override
    public void atualizarStatus() {
        System.out.println("Status - Na Transportadora");
    }
}
