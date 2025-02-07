package swing;
import main.*;
import pizzeria.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class swingPizzeria extends JFrame {

	// Atributos
	private JButton orderButton;
	
	// constructor
	public swingPizzeria(JButton orderButton) {
		setTitle("Pizzeria Equipo A");
		setSize(400,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// Boton para el menu del Jefe.
		orderButton = new JButton("Menu Admin");
		
		
	}
}