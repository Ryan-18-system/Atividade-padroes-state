package br.edu.ifpb.impl;

import br.edu.ifpb.Pedido;
import br.edu.ifpb.State;

public class Finalizado implements State {
    Pedido pedido;

    public Finalizado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void enviarPedido() {
        if(this.pedido.isProblem()){
            System.out.println("Desculpe pelo transtorno, enviaremos um novo pedido");
            this.pedido.setProblem(false);
            pedido.setState(new EmPreparacao(this.pedido));
        }else{
            System.out.println("Pedido foi Finalizado com Sucesso");
        }

    }

    @Override
    public void atualizarStatus() {
        System.out.println("Status - Finalizado");
    }
}
