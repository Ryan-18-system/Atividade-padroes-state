package br.edu.ifpb.impl;

import br.edu.ifpb.Pedido;
import br.edu.ifpb.State;

public class EmPreparacao implements State {
    private Pedido pedido;

    public EmPreparacao(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void enviarPedido() {
        System.out.println("Enviando pedido para Transportadora....");
        pedido.setState(new Transportadora(this.pedido));

    }

    @Override
    public void atualizarStatus() {
        System.out.println("Status - EM PREPARAÇÃO");
    }
}
