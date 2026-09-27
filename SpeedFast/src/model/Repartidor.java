package model;

public class Repartidor implements Runnable {

    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                System.out.println(
                        nombre + " no encontró más pedidos pendientes."
                );
                break;
            }

            System.out.println(
                    nombre + " retiró el pedido "
                            + pedido.getIdPedido()
                            + " - Estado: "
                            + pedido.getEstado()
            );

            try {
                System.out.println(
                        nombre + " está entregando el pedido "
                                + pedido.getIdPedido()
                                + " en "
                                + pedido.getDireccionEntrega()
                );

                Thread.sleep(2000);

                pedido.setEstado(EstadoPedido.ENTREGADO);

                System.out.println(
                        nombre + " entregó el pedido "
                                + pedido.getIdPedido()
                                + " - Estado: "
                                + pedido.getEstado()
                );

            } catch (InterruptedException e) {
                System.out.println(
                        "La entrega realizada por " + nombre
                                + " fue interrumpida."
                );

                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}