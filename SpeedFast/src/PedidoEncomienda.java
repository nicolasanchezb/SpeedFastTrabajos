public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Encomienda");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido de encomienda #" + idPedido);
        System.out.println("Validando peso y condiciones del embalaje.");
        System.out.println("Buscando repartidor disponible.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido de encomienda #" + idPedido);
        System.out.println("Repartidor asignado: " + nombreRepartidor);
        System.out.println("Validación: peso y embalaje de la encomienda verificados.");
    }
}