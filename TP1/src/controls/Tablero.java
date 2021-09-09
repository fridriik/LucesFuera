package controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tablero extends JPanel {
	
	private JButton[][] botonesDelTablero;
	private JPanel panelDelTablero;
	private int cantidadDeBotones = 4;
	
	/*
	 * Constructor del tablero con sus botones
	 */
	public Tablero() {
		botonesDelTablero = new JButton[cantidadDeBotones][cantidadDeBotones];
		panelDelTablero = new JPanel();
		panelDelTablero.setLayout(new GridLayout(cantidadDeBotones, cantidadDeBotones));
		//Seteamos los valores del alto y ancho del tablero
		panelDelTablero.setPreferredSize(new Dimension(400, 400));
		for(int i = 0; i < cantidadDeBotones; i++) {
			for(int j = 0; j  <cantidadDeBotones; j++) {
				//Random para calcular debajo los valores con los que tendriamos que cambiar los colores de los botones
				int random = (int)(Math.random()*3);
				JButton nuevoBoton = new JButton();
				botonesDelTablero[i][j] = nuevoBoton;
				nuevoBoton.setName("" + i + j);
				nuevoBoton.setBackground(Color.BLACK);
				//Cambiamos los colores si el random es igual a ese numero, entonces el tablero siempre es distinto
				if(random == 2)	{
					cambiarColor(nuevoBoton);
				}
				nuevoBoton.addActionListener(new Input());	
				panelDelTablero.add(nuevoBoton);
				//Aca faltaba agregar esto para agregar todo el panel de botones al constructor del tablero
				add(panelDelTablero);
			}
		}
	}
	
	private void cambiarColor(JButton button) {
		if (button.getBackground().equals(Color.black)) {
			button.setBackground(Color.white);
		} 
		else {
		button.setBackground(Color.black);
		}
	}
	
	public class Input implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean done = false;
			int columna = 0;
			int filas = 0;
			for (int i = 0; i < botonesDelTablero.length; i++) {
				for (int j = 0; j < botonesDelTablero[i].length; j++) {
					if (((JButton)e.getSource()).equals(botonesDelTablero[i][j])) {
						done = true;
						columna = i;
						filas = j;
						break;
					}
				}
				if (done) {
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
		}
	}
}
