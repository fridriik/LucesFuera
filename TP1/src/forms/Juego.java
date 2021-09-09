package forms;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controls.Tablero;

@SuppressWarnings("serial")
public class Juego extends JFrame {
	
	private JLabel labelCantMovimientos;
	private int cantMovimientos;
	private Tablero botonesDelTablero;

	/*
	 * Constructor de la vista del juego
	 */
	public Juego() {
		botonesDelTablero = new Tablero();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Luces Fuera!");
		setSize(500, 500);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		
		//Falta terminar esto para mostrar la cantidad de movimientos
		JPanel label = new JPanel();
		label.setLayout(new GridLayout(1, 1));
		label.add(labelCantMovimientos = new JLabel());	
		labelCantMovimientos.setText("Cantidad de movimientos: " + cantMovimientos);
		
		panelPrincipal.add(label, BorderLayout.NORTH);
		panelPrincipal.add(botonesDelTablero);
		setContentPane(panelPrincipal);
	}
	
	public static void main(String[] args) {
		Juego lucesFuera = new Juego();
		lucesFuera.setVisible(true);
	}
}