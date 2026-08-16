public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Comida");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido de comida #" + idPedido);
        System.out.println("Buscando repartidor con mochila térmica.");
        System.out.println("Pedido listo para ser asignado.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido de comida #" + idPedido);
        System.out.println("Repartidor asignado: " + nombreRepartidor);
        System.out.println("Validación: el repartidor debe contar con mochila térmica.");
    }
}