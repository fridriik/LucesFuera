package forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controls.Logica;

@SuppressWarnings("serial")
public class Tablero extends JFrame {
	
	private JButton[][] botonesDelTablero;
	private JPanel panelDelTablero;
	private int cantidadDeBotones = 4;
	private JLabel cartelMovimientos;
	private JPanel panelDePuntaje;

	/**
	 * Constructor del tablero y botones
	 */
	public Tablero() {
		setTitle("Luces Fuera!");
		
		//Creamos una matrtiz para botones
		botonesDelTablero = new JButton[cantidadDeBotones][cantidadDeBotones];
		panelDelTablero = new JPanel();
		panelDelTablero.setLayout(new GridLayout(cantidadDeBotones, cantidadDeBotones));
		
		//Seteamos los valores del alto y ancho del tablero
		panelDelTablero.setPreferredSize(new Dimension(400, 400));
		
		//Ciclo anidado para crear los botones para la matriz
		for(int i = 0; i < cantidadDeBotones; i++) {
			for(int j = 0; j  <cantidadDeBotones; j++) {
				
				//Random para calcular debajo los valores con los que tendriamos que cambiar los colores de los botones
				int random = (int)(Math.random()*3);
				
				//Colocamos los botones
				JButton nuevoBoton = new JButton();
				botonesDelTablero[i][j] = nuevoBoton;
				nuevoBoton.setBackground(Color.BLACK);
				
				//Cambiamos los colores si el random es igual a ese numero, entonces el tablero siempre es distinto
				if(random == 2)	{
					cambiarColor(nuevoBoton);
				}
				
				//Le pasamos el Listener a cada boton
				nuevoBoton.addActionListener(new Input());	
				panelDelTablero.add(nuevoBoton);
			}
		}
		//Creamos un panel para poder colocar el Label de movimientos y organizarlo junto a la matriz de botones
		panelDePuntaje = new JPanel();
		panelDePuntaje.setLayout(new GridLayout(1, 1));
		panelDePuntaje.add(cartelMovimientos = new JLabel());
		cartelMovimientos.setText("Movimientos: " + "-");
		getContentPane().add(panelDePuntaje, BorderLayout.NORTH);
		getContentPane().add(panelDelTablero);
		
	}

	/**
	 * Metodo que se utiliza para el cambio de colores de los botones
	 * @param boton
	 */
	private void cambiarColor(JButton button) {
		if (button.getBackground().equals(Color.black)) {
			button.setBackground(Color.white);
		} 
		else {
		button.setBackground(Color.black);
		}
	}
	
	/**
	 * Metodo que verifica si todos los botones de la matriz son del color ganador
	 * en este caso BLANCO
	 * @return
	 */
	private boolean ganar() {
		for (int i = 0; i < botonesDelTablero.length; i++) {
			for (int j = 0; j < botonesDelTablero[i].length; j++) {
				if(botonesDelTablero[i][j].getBackground() == Color.black) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public class Input implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			Logica.cantMovimientos++;
			cartelMovimientos.setText("Movimientos: " + Logica.cantMovimientos);
			boolean flag = false;
			int columna = 0;
			int filas = 0;
			for (int i = 0; i < botonesDelTablero.length; i++) {
				for (int j = 0; j < botonesDelTablero[i].length; j++) {
					if (((JButton)e.getSource()).equals(botonesDelTablero[i][j])) {
						flag = true;
						columna = i;
						filas = j;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			cambiarColor(botonesDelTablero[columna][filas]);
			if (columna > 0) {
				cambiarColor(botonesDelTablero[columna - 1][filas]);
			}
			if (columna < botonesDelTablero.length - 1) {
				cambiarColor(botonesDelTablero[columna + 1][filas]);
			}
			if (filas > 0) {
				cambiarColor(botonesDelTablero[columna][filas - 1]);
			}
			if (filas < botonesDelTablero[columna].length - 1) {
				cambiarColor(botonesDelTablero[columna][filas + 1]);
			}	
			if (ganar()) {
				Logica.juegoTerminado = true;
				Logica.contador = 0;
			}
		}
	}
}
