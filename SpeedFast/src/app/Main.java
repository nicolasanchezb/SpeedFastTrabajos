package app;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;
import model.ZonaDeCarga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("       SISTEMA SPEEDFAST");
        System.out.println("==================================");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        zonaDeCarga.agregarPedido(
                new PedidoComida(
                        101,
                        "Avenida Alemania 450",
                        4
                )
        );

        zonaDeCarga.agregarPedido(
                new PedidoEncomienda(
                        102,
                        "Calle Independencia 820",
                        6
                )
        );

        zonaDeCarga.agregarPedido(
                new PedidoExpress(
                        103,
                        "Avenida Pedro Montt 1200",
                        8
                )
        );

        zonaDeCarga.agregarPedido(
                new PedidoComida(
                        104,
                        "Calle Los Robles 350",
                        3
                )
        );

        zonaDeCarga.agregarPedido(
                new PedidoEncomienda(
                        105,
                        "Avenida Francia 740",
                        5
                )
        );

        zonaDeCarga.agregarPedido(
                new PedidoExpress(
                        106,
                        "Calle Simpson 225",
                        2
                )
        );

        Repartidor repartidorJuan =
                new Repartidor("Juan", zonaDeCarga);

        Repartidor repartidorMaria =
                new Repartidor("María", zonaDeCarga);

        Repartidor repartidorAlexis =
                new Repartidor("Alexis", zonaDeCarga);

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        executor.execute(repartidorJuan);
        executor.execute(repartidorMaria);
        executor.execute(repartidorAlexis);

        executor.shutdown();

        try {
            boolean procesoFinalizado =
                    executor.awaitTermination(1, TimeUnit.MINUTES);

            if (procesoFinalizado) {
                System.out.println("==================================");
                System.out.println(
                        "Todos los pedidos han sido entregados correctamente"
                );
                System.out.println("==================================");
            } else {
                System.out.println(
                        "El tiempo de espera terminó antes de completar las entregas."
                );
            }

        } catch (InterruptedException e) {
            System.out.println(
                    "El proceso principal fue interrumpido."
            );

            Thread.currentThread().interrupt();
        }
    }
}