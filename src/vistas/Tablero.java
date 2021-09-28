package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import comportamiento.Flow;
import externalMedia.JMusic;

@SuppressWarnings("serial")
public class Tablero extends JFrame {
	
	private JButton[][] botonesDelTablero;
	private JPanel panelDelTablero, panelDePuntaje;
	private JLabel cartelMovimientos;
	public static int cantMovimientos;
	private Clip sonidoBoton = JMusic.cargarSonido("externalMedia/boton.wav");

	
	/**
	 * Constructor del tablero y botones
	 */
	public Tablero() {
		
		setTitle("Luces Fuera!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creamos un panel para poder colocar el Label de movimientos y organizarlo junto a la matriz de botones
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/externalMedia/ARCADEPI.ttf"));
            panelDePuntaje = new JPanel();
            panelDePuntaje.setLayout(new GridLayout(1, 1));
            panelDePuntaje.add(cartelMovimientos = new JLabel());
            cartelMovimientos.setText("MOVIMIENTOS: " + "-");
            cartelMovimientos.setFont(font.deriveFont(Font.PLAIN, 14f));
            getContentPane().add(panelDePuntaje, BorderLayout.NORTH);
		} catch (IOException | FontFormatException ex) {
            ex.printStackTrace();
        }
		
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
		
		//Random para los botones y su posicion en el tablero
		Random aleatorioParaColor = new Random();
		for (JButton[] col : botonesDelTablero) {
			for (JButton boton : col) {
				boolean temp = aleatorioParaColor.nextBoolean();
				if (temp) {
					boton.doClick();
					cantMovimientos = -1;
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
	private void cambiarColor(JButton boton) {
		if (boton.getBackground().equals(Color.black)) {
			boton.setBackground(Color.magenta);
		} 
		else {
		boton.setBackground(Color.black);
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
	
	
	//Implementamos los listener para las acciones de los botones del tablero y que responda a lo que pide el juego
	public class Input implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cantMovimientos++;
			cartelMovimientos.setText("Movimientos: " + cantMovimientos);
			if(cantMovimientos > 0) {
				sonidoBoton.loop(1);
			}
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
