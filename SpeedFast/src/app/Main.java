package main;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import service.GestorPedidos;
import ui.VentanaPrincipal;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorPedidos gestor = new GestorPedidos();

            gestor.registrar(new PedidoComida(
                    101, "Avenida Alemania 450", 4
            ));

            gestor.registrar(new PedidoEncomienda(
                    102, "Calle Independencia 820", 6
            ));

            gestor.registrar(new PedidoExpress(
                    103, "Avenida Pedro Montt 1200", 8
            ));

            gestor.registrar(new PedidoComida(
                    104, "Calle Los Robles 350", 3
            ));

            gestor.registrar(new PedidoEncomienda(
                    105, "Avenida Francia 740", 5
            ));

            gestor.registrar(new PedidoExpress(
                    106, "Calle Simpson 225", 2
            ));

            VentanaPrincipal ventana = new VentanaPrincipal(gestor);
            ventana.setVisible(true);
        });
    }
}