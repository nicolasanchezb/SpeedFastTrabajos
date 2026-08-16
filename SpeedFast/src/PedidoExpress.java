public class PedidoExpress extends Pedido {

    public PedidoExpress(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Compra Express");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido Express #" + idPedido);
        System.out.println("Buscando al repartidor más cercano.");
        System.out.println("Verificando disponibilidad inmediata.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido Express #" + idPedido);
        System.out.println("Repartidor asignado: " + nombreRepartidor);
        System.out.println("Validación: repartidor cercano y con disponibilidad inmediata.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor, String calle) {
        System.out.println("Pedido Express #" + idPedido);
        System.out.println("Repartidor: " + nombreRepartidor);
        System.out.println("Ubicación: cercano a " + calle);
        System.out.println("Validación: repartidor cercano y espacio disponible para realizar un doble pedido.");
    }
}