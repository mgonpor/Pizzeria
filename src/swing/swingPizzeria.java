package swing;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;
import main.*;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class swingPizzeria extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingPizzeria frame = new swingPizzeria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public swingPizzeria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		TextArea textArea = new TextArea("Bienvenido Soldado."
				+ "\nEstas dentro de la pagina web del Equipo A");
		textArea.setBackground(new Color(255, 255, 0));
		textArea.setForeground(new Color(128, 0, 0));
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Pizzeria Equipo A");
		lblNewJgoodiesLabel.setBackground(new Color(255, 255, 0));
		lblNewJgoodiesLabel.setForeground(new Color(128, 0, 0));
		contentPane.add(lblNewJgoodiesLabel, BorderLayout.NORTH);
	}
}