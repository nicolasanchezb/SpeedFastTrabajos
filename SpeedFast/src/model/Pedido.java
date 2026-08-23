package model;

public abstract class Pedido {

    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void mostrarResumen() {
        System.out.println("ID del pedido: " + idPedido);
        System.out.println("Dirección de entrega: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Tipo de entrega: " + obtenerTipoEntrega());
        System.out.println("Factores que afectan su duración: "
                + obtenerFactoresDuracion());
    }

    public abstract int calcularTiempoEntrega();

    public abstract String obtenerTipoEntrega();

    public abstract String obtenerFactoresDuracion();
}