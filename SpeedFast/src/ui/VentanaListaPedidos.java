package ui;

import model.Pedido;
import service.GestorPedidos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {

    private final GestorPedidos gestor;

    private final DefaultTableModel modelo = new DefaultTableModel(
            new String[]{
                    "ID", "Dirección", "Tipo", "Km",
                    "Repartidor", "Estado", "Minutos"
            },
            0
    ) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private final JTable tabla = new JTable(modelo);
    private final Timer temporizador;

    public VentanaListaPedidos(GestorPedidos gestor) {
        super("Listado de pedidos");

        this.gestor = gestor;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(950, 400);
        setLocationRelativeTo(null);

        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel acciones = new JPanel();

        JButton refrescar = new JButton("Refrescar");
        JButton asignar = new JButton(
                "Asignar repartidor al seleccionado"
        );

        acciones.add(refrescar);
        acciones.add(asignar);

        add(acciones, BorderLayout.SOUTH);

        refrescar.addActionListener(e -> actualizar());

        asignar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Selecciona un pedido de la tabla."
                );
                return;
            }

            int filaModelo = tabla.convertRowIndexToModel(fila);
            int id = (Integer) modelo.getValueAt(filaModelo, 0);

            for (Pedido pedido : gestor.listar()) {
                if (pedido.getIdPedido() == id) {
                    try {
                        gestor.asignar(pedido);
                        actualizar();

                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(
                                this,
                                ex.getMessage()
                        );
                    }

                    break;
                }
            }
        });

        temporizador = new Timer(500, e -> actualizar());
        temporizador.start();

        actualizar();
    }

    private void actualizar() {
        Integer idSeleccionado = null;
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            int filaModelo = tabla.convertRowIndexToModel(fila);
            idSeleccionado = (Integer) modelo.getValueAt(
                    filaModelo, 0
            );
        }

        modelo.setRowCount(0);

        List<Pedido> pedidos = gestor.listar();

        for (Pedido pedido : pedidos) {
            modelo.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    pedido.obtenerTipoEntrega(),
                    pedido.getDistanciaKm(),
                    pedido.getRepartidorAsignado(),
                    pedido.getEstado(),
                    pedido.calcularTiempoEntrega()
            });
        }

        if (idSeleccionado != null) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (idSeleccionado.equals(
                        modelo.getValueAt(i, 0)
                )) {
                    tabla.setRowSelectionInterval(i, i);
                    break;
                }
            }
        }
    }

    @Override
    public void dispose() {
        temporizador.stop();
        super.dispose();
    }
}