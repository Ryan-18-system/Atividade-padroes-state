package br.edu.ifpb;

import br.edu.ifpb.impl.EmPreparacao;

public class Pedido implements State {
    private State state;
    private boolean isProblem = false;
    public Pedido() {
        this.state = new EmPreparacao(this);
    }
    public void enviarPedido() {
        state.enviarPedido();
    }

    public boolean isProblem() {
        return isProblem;
    }

    public void setProblem(boolean problem) {
        isProblem = problem;
    }

    public void atualizarStatus() {
        state.atualizarStatus();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


}
