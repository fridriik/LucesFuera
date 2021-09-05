package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controls.InputBoton;


@SuppressWarnings("serial")
public class Juego extends JFrame {
	
	private JLabel labelCantMovimientos;
	private int cantMovimientos;
	private JButton[][] botonesDelTablero;
	private JPanel panelDelTablero;
	private int cantidadDeBotones = 4;

	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Luces Fuera!");
		setSize(500, 500);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		
		JPanel label = new JPanel();
		label.setLayout(new GridLayout(1, 1));
		label.add(labelCantMovimientos = new JLabel());	
		labelCantMovimientos.setText("Cantidad de movimientos: " + cantMovimientos);
		panelPrincipal.add(label, "North");
		
		panelDelTablero= new JPanel();
		panelDelTablero.setLayout(new GridLayout(cantidadDeBotones, cantidadDeBotones));
		botonesDelTablero = new JButton[cantidadDeBotones][cantidadDeBotones];
		for(int i = 0; i < cantidadDeBotones; i++) {
			System.out.println("Columna: " + i);
			for(int j = 0; j  <cantidadDeBotones; j++) {
				System.out.println("Fila: " + j);
				JButton nuevoBoton = new JButton();
				botonesDelTablero[i][j] = nuevoBoton;
				nuevoBoton.setName(""+i+j);
				nuevoBoton.setBackground(Color.black);
				nuevoBoton.addActionListener(new InputBoton());	
				panelDelTablero.add(nuevoBoton);
			}
		}
		panelPrincipal.add(panelDelTablero);
		
		setContentPane(panelPrincipal);
		
	}
	
	public JButton[][] getBotonesDelTablero() {
		return botonesDelTablero;
	}
	
	public void backgroundColor(JButton b)
	{
		if(b.getBackground()==Color.BLACK)			//the button b is black, then it is changed to yellow, otherwise it is
		{											//changed to black.
			b.setBackground(Color.YELLOW);
		}
		else
		{
			b.setBackground(Color.BLACK);
		}
	}
	
	public static void main(String[] args) {
		Juego lucesFuera = new Juego();
		lucesFuera.setVisible(true);
	}
}