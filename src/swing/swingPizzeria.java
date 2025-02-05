package swing;
import javax.swing.*;

import pizzeria.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class swingPizzeria<LocalDate> extends JFrame {
    private JTextField nombreClienteField;
    private JTextField direccionClienteField;
    private JTextField emailClienteField;
    private JTextField telefonoClienteField;
    private JTextArea pedidosArea;
    private LocalDate Fecha;

    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;

    public swingPizzeria() {
        clientes = new ArrayList<>();
        pedidos = new ArrayList<>();

        setTitle("Pizzeria Equipo A");
        setSize(910, 752);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel clientePanel = new JPanel(new GridLayout(4,4));
        JLabel label = new JLabel("Nombre del Cliente:");
        label.setForeground(new Color(255, 128, 0));
        label.setBackground(new Color(255, 0, 0));
        clientePanel.add(label);
        nombreClienteField = new JTextField();
        clientePanel.add(nombreClienteField);
        clientePanel.add(new JLabel("Direción del Cliente:"));
        direccionClienteField = new JTextField();
        clientePanel.add(direccionClienteField);
        clientePanel.add(new JLabel("Email del Cliente:"));
        emailClienteField = new JTextField();
        clientePanel.add(emailClienteField);
        clientePanel.add(new JLabel("Teléfono del Cliente:"));
        telefonoClienteField = new JTextField();
        clientePanel.add(telefonoClienteField);
        

        JButton agregarClienteButton = new JButton("Agregar Cliente");
        clientePanel.add(agregarClienteButton);
        agregarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreClienteField.getText();
                String telefono = telefonoClienteField.getName();
                String direccion = direccionClienteField.getText();
                String email = emailClienteField.getText();
                Cliente cliente = new Cliente(nombre, direccion, email, telefono);
                clientes.add(cliente);
                actualizarPedidosArea();
            }
        });

        getContentPane().add(clientePanel, BorderLayout.NORTH);

        pedidosArea = new JTextArea();
        pedidosArea.setBackground(new Color(255, 255, 0));
        getContentPane().add(new JScrollPane(pedidosArea), BorderLayout.CENTER);

        JPanel pedidoPanel = new JPanel(new BorderLayout());
        JTextField descripcionField = new JTextField();
        JTextField FechaField = new JTextField();

        pedidoPanel.add(descripcionField, BorderLayout.CENTER);
        JButton agregarPedidoButton = new JButton("Agregar Pedido");
        pedidoPanel.add(agregarPedidoButton, BorderLayout.EAST);
        agregarPedidoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                @SuppressWarnings("unchecked")
				LocalDate Fecha = (LocalDate) FechaField.getText();
                if (!clientes.isEmpty() && !descripcion.isEmpty()) {
                    Cliente cliente = clientes.get(clientes.size() - 1);
                    Pedido pedido = new Pedido(cliente, (java.time.LocalDate) Fecha, descripcion);
                    pedidos.add(pedido);
                    actualizarPedidosArea();
                }
            }
        });

        getContentPane().add(pedidoPanel, BorderLayout.SOUTH);
    }

    private void actualizarPedidosArea() {
        StringBuilder sb = new StringBuilder();
        for (Pedido pedido : pedidos) {
            sb.append(pedido.toString()).append("\n");
        }
        pedidosArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new swingPizzeria().setVisible(true);
            }
        });
    }

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}
}
