import br.edu.ifpb.Pedido;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Pedido pedido = new Pedido();

        System.out.printf("Escolha true para fazer pedido  e false para cancelar");
        Boolean isPedido = console.nextBoolean();
        if(isPedido.equals(Boolean.TRUE)){
            System.out.println("Pedido feito");
            // Em preparação
            Main.timeOut();
            pedido.atualizarStatus();
            pedido.enviarPedido();
            //Transportadora
            Main.timeOut();
            pedido.atualizarStatus();

            pedido.enviarPedido();
            Main.timeOut();// realiza a ação já com Estado de "transportadora" passando para Recebido
            pedido.atualizarStatus();
            System.out.println("Seu pedido obteve algum problema? digite true - sim e false - não");
            Boolean isProblem = console.nextBoolean();
            if(isProblem.equals(Boolean.TRUE)){
                pedido.setProblem(true);
                pedido.enviarPedido(); // realiza a ação com estado de "recebido para finalizado"
                Main.timeOut();
                pedido.enviarPedido(); // aqui ou ele vai para finalizado ou para em preparação novamente
                pedido.atualizarStatus();
            }else{
                Main.timeOut();
                pedido.enviarPedido(); // aqui ou ele vai para finalizado ou para em preparação novamente
                pedido.atualizarStatus();
            }

        }else{
            System.out.println("PEDIDO CANCELADO");
        }

    }
    private static  void timeOut(){
        System.out.println("Atualizando Pedido");
        for (int i = 1; i < 4; i++) {
            System.out.print(  "[*] ");
            try {
                TimeUnit.SECONDS.sleep(4L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}