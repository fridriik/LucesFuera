package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comportamiento.Flow;

@SuppressWarnings("serial")
public class Tablero extends JFrame {
	
	private JButton[][] botonesDelTablero;
	private JPanel panelDelTablero, panelDePuntaje;
	private JLabel cartelMovimientos;

	/**
	 * Constructor del tablero y botones
	 */
	public Tablero() {
		setTitle("Luces Fuera!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Creamos un panel para poder colocar el Label de movimientos y organizarlo junto a la matriz de botones
		panelDePuntaje = new JPanel();
		panelDePuntaje.setLayout(new GridLayout(1, 1));
		panelDePuntaje.add(cartelMovimientos = new JLabel());
		cartelMovimientos.setText("Movimientos: " + "-");
		getContentPane().add(panelDePuntaje, BorderLayout.NORTH);
		
		//Creamos una matrtiz para botones
		botonesDelTablero = new JButton[Flow.columnas][Flow.filas];
		panelDelTablero = new JPanel();
		panelDelTablero.setLayout(new GridLayout(Flow.columnas, Flow.filas));
		
		//Seteamos los valores del alto y ancho del tablero
		panelDelTablero.setPreferredSize(new Dimension(400, 400));
		
		//Ciclo anidado para crear los botones para la matriz
		for(int i = 0; i < botonesDelTablero.length; i++) {
			for(int j = 0; j  < botonesDelTablero[i].length; j++) {
				
				//Colocamos los botones
				botonesDelTablero[i][j] = new JButton("");
				botonesDelTablero[i][j].setBackground(Color.magenta);
	
				//Le pasamos el Listener a cada boton
				botonesDelTablero[i][j].addActionListener(new Input());	
				panelDelTablero.add(botonesDelTablero[i][j]);
			}
		}
		
		//Random para calcular debajo los valores con los que tendriamos que cambiar los colores de los botones
		Random aleatorioParaColor = new Random();
		for (JButton[] col : botonesDelTablero) {
			for (JButton boton : col) {
				boolean temp = aleatorioParaColor.nextBoolean();
				if (temp) {
					boton.doClick();
				}
			}
		}
		
		//Finalmente agregamos el panel con botones
		getContentPane().add(panelDelTablero);
		getContentPane().repaint();
		setVisible(true);
	}

	/**
	 * Metodo que se utiliza para el cambio de colores de los botones
	 * @param boton
	 */
	private void cambiarColor(JButton button) {
		if (button.getBackground().equals(Color.black)) {
			button.setBackground(Color.magenta);
		} 
		else {
		button.setBackground(Color.black);
		}
	}
	
	/**
	 * Metodo que verifica si todos los botones de la matriz son del color ganador
	 */
	private boolean ganar() {
		for (int i = 0; i < botonesDelTablero.length; i++) {
			for (int j = 0; j < botonesDelTablero[i].length; j++) {
				if(botonesDelTablero[i][j].getBackground() == Color.magenta) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public class Input implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			Flow.cantMovimientos++;
			cartelMovimientos.setText("Movimientos: " + Flow.cantMovimientos);
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
				Flow.juegoTerminado = true;
				Flow.contador = 0;
			}
		}
	}
}
