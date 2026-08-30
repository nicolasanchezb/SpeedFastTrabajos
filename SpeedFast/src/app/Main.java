package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import service.ControladorDeEnvios;

public class Main {

    public static void main(String[] args) {

        Pedido pedidoComida = new PedidoComida(
                101,
                "Avenida Alemania 450",
                4
        );

        Pedido pedidoEncomienda = new PedidoEncomienda(
                102,
                "Calle Independencia 820",
                6
        );

        Pedido pedidoExpress = new PedidoExpress(
                103,
                "Avenida Pedro Montt 1200",
                8
        );

        Pedido[] pedidos = {
                pedidoComida,
                pedidoEncomienda,
                pedidoExpress
        };

        pedidoComida.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor();
        pedidoExpress.asignarRepartidor("Felipe");

        ControladorDeEnvios controlador = new ControladorDeEnvios();

        controlador.reservarPedido(pedidoComida);
        controlador.despachar();

        controlador.reservarPedido(pedidoExpress);
        controlador.cancelar();


        System.out.println("==================================");
        System.out.println("       SISTEMA SPEEDFAST");
        System.out.println("==================================");

        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();

            System.out.println(
                    "Tiempo estimado de entrega: "
                            + pedido.calcularTiempoEntrega()
                            + " minutos"
            );

            System.out.println("----------------------------------");
        }

        System.out.println();
        System.out.println("COMPARACIÓN DE TIEMPOS");
        System.out.println("----------------------------------");

        for (Pedido pedido : pedidos) {
            System.out.println(
                    "Pedido " + pedido.getIdPedido()
                            + " | " + pedido.obtenerTipoEntrega()
                            + " | " + pedido.calcularTiempoEntrega()
                            + " minutos"
            );
        }
        System.out.println();
        System.out.println("HISTORIAL DE ENVÍOS");
        System.out.println("----------------------------------");
        controlador.verHistorial();
    }
}