package br.edu.ifpb.impl;

import br.edu.ifpb.Pedido;
import br.edu.ifpb.State;
import br.edu.ifpb.impl.Finalizado;

public class Recebido implements State {
    private Pedido pedido;

    public Recebido(Pedido pedido) {
        this.pedido = pedido;
    }


    @Override
    public void enviarPedido() {

        pedido.setState(new Finalizado(this.pedido));
    }

    @Override
    public void atualizarStatus() {
        System.out.println("Status - Recebido");
    }
}
