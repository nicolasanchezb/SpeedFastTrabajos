package ui;

import service.GestorPedidos;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private final GestorPedidos gestor;

    public VentanaPrincipal(GestorPedidos gestor) {
        super("SpeedFast - Gestión de entregas");

        this.gestor = gestor;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(460, 240);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel(
                "Sistema SpeedFast",
                SwingConstants.CENTER
        );
        titulo.setFont(
                titulo.getFont().deriveFont(Font.BOLD, 22f)
        );
        add(titulo, BorderLayout.NORTH);

        JPanel botones = new JPanel(
                new GridLayout(3, 1, 8, 8)
        );
        botones.setBorder(
                BorderFactory.createEmptyBorder(10, 24, 18, 24)
        );

        JButton registrar = new JButton("Registrar pedido");
        JButton listar = new JButton("Listar pedidos");
        JButton iniciar = new JButton("Iniciar entregas");

        botones.add(registrar);
        botones.add(listar);
        botones.add(iniciar);

        add(botones, BorderLayout.CENTER);

        registrar.addActionListener(e ->
                new VentanaRegistroPedido(gestor).setVisible(true)
        );

        listar.addActionListener(e ->
                new VentanaListaPedidos(gestor).setVisible(true)
        );

        iniciar.addActionListener(e -> {
            try {
                gestor.iniciarEntregas();

                JOptionPane.showMessageDialog(
                        this,
                        "Entregas iniciadas. Consulta el listado para ver su estado."
                );

            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
    }
}