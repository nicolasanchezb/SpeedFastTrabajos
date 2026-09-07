package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidosAsignados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPedido(Pedido pedido) {
        pedidosAsignados.add(pedido);
    }

    @Override
    public void run() {
        System.out.println(nombre + " comenzó su jornada de entregas.");

        for (Pedido pedido : pedidosAsignados) {
            System.out.println(
                    nombre + " está entregando el pedido "
                            + pedido.getIdPedido()
                            + " en "
                            + pedido.getDireccionEntrega()
            );

            try {
                int tiempoEspera =
                        ThreadLocalRandom.current().nextInt(1000, 3001);

                Thread.sleep(tiempoEspera);

                System.out.println(
                        nombre + " completó el pedido "
                                + pedido.getIdPedido()
                                + ". Tiempo estimado: "
                                + pedido.calcularTiempoEntrega()
                                + " minutos."
                );

            } catch (InterruptedException e) {
                System.out.println(
                        "La entrega de " + nombre + " fue interrumpida."
                );

                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(nombre + " terminó todas sus entregas.");
    }
}