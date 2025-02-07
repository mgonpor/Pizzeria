package swing;

import main.*;
import javax.swing.*;
import java.awt.*;

	public class swingPizzeria extends JFrame {
		private JButton boton;
	    private JLabel Titulos;
		
		public swingPizzeria() {
		setTitle("Pizzería Equipo A");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        add(new JLabel("Elije la interfaz tuya"));
        String[] Menus = {};
        boton = new JButton("Interfaces");
        add(boton);
        
        
        
		}
	}