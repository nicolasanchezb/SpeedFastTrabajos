public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("          SISTEMA SPEEDFAST");
        System.out.println("====================================");

        // Crear pedido de comida
        PedidoComida comida = new PedidoComida(
                101,
                "Av. Los Leones 123"
        );

        // Crear pedido de encomienda
        PedidoEncomienda encomienda = new PedidoEncomienda(
                102,
                "Av. Providencia 456"
        );

        // Crear primer pedido Express
        PedidoExpress express = new PedidoExpress(
                103,
                "Av. Apoquindo 789"
        );

        // Crear segundo pedido Express
        PedidoExpress expressCercano = new PedidoExpress(
                104,
                "Av. Providencia 100"
        );

        // ====================================
        // SOBRESCRITURA
        // ====================================

        System.out.println("\n--- SOBRESCRITURA ---");

        comida.asignarRepartidor();

        System.out.println();

        encomienda.asignarRepartidor();

        System.out.println();

        express.asignarRepartidor();

        // ====================================
        // SOBRECARGA
        // ====================================

        System.out.println("\n--- SOBRECARGA ---");

        // Sobrecarga con nombre del repartidor
        comida.asignarRepartidor("Carlos");

        System.out.println();

        encomienda.asignarRepartidor("Javier");

        System.out.println();

        express.asignarRepartidor("Felipe");

        System.out.println();

        // Sobrecarga con nombre y calle
        expressCercano.asignarRepartidor(
                "Juan",
                "Av. Providencia"
        );

        System.out.println("\n====================================");
        System.out.println("           FIN DEL SISTEMA");
        System.out.println("====================================");
    }
}