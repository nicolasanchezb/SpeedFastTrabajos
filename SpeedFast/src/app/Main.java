package app;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        // Pedidos de comida
        Pedido pedido101 = new PedidoComida(
                101,
                "Avenida Alemania 450",
                4.0
        );

        Pedido pedido102 = new PedidoComida(
                102,
                "Calle Picarte 750",
                3.5
        );

        // Pedidos de encomienda
        Pedido pedido103 = new PedidoEncomienda(
                103,
                "Calle Independencia 820",
                6.0
        );

        Pedido pedido104 = new PedidoEncomienda(
                104,
                "Avenida Francia 340",
                5.0
        );

        // Pedidos express
        Pedido pedido105 = new PedidoExpress(
                105,
                "Avenida Pedro Montt 1200",
                8.0
        );

        Pedido pedido106 = new PedidoExpress(
                106,
                "Calle Los Robles 230",
                2.5
        );

        // Creación de los repartidores
        Repartidor juan = new Repartidor("Juan");
        Repartidor maria = new Repartidor("María");
        Repartidor alexis = new Repartidor("Alexis");

        // Asignación de dos pedidos a cada repartidor
        juan.agregarPedido(pedido101);
        juan.agregarPedido(pedido102);

        maria.agregarPedido(pedido103);
        maria.agregarPedido(pedido104);

        alexis.agregarPedido(pedido105);
        alexis.agregarPedido(pedido106);

        System.out.println("==================================");
        System.out.println("   SIMULACIÓN DE ENTREGAS");
        System.out.println("==================================");

        // Grupo de tres hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Los tres repartidores comienzan simultáneamente
        executor.submit(juan);
        executor.submit(maria);
        executor.submit(alexis);

        // No se aceptarán más tareas
        executor.shutdown();

        try {
            // Espera hasta que todos los repartidores terminen
            boolean finalizaron = executor.awaitTermination(
                    1,
                    TimeUnit.MINUTES
            );

            if (finalizaron) {
                System.out.println("==================================");
                System.out.println("TODAS LAS ENTREGAS FUERON COMPLETADAS");
                System.out.println("==================================");
            } else {
                System.out.println("La simulación superó el tiempo máximo.");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            System.out.println("La simulación principal fue interrumpida.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}