package comportamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import externalMedia.JMusic;
import vistas.PantallaGanador;
import vistas.PantallaInicial;
import vistas.Tablero;

public class Flow {
	
	//Utilizamos volatile ya que no registraba correctamente el boolean y es necesario poder mantenerla en la memoria principal
	public volatile static boolean juegoTerminado = false;
	public static boolean noPreparado = true;
	public static int filas, columnas, contador = 0;
	public Tablero juego;
	private Clip musica = JMusic.cargarSonido("externalMedia/musica.wav");

	
	public Flow() {
		
		columnasYFilas();
		
		//Si aparece la pantalla de ganador
		while (true) {
			if (juegoTerminado) {
				if (contador == 0) {
					
					//Creamos la pantalla final
					PantallaGanador fin = new PantallaGanador();
					fin.setVisible(true);
					juego.dispose();
					
					//Listener para el boton de salir del juego
					fin.salir.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							musica.stop();
							fin.dispose();
						}
					});
					
					//Listener para el boton de jugar de nuevo
					fin.seguirJugando.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Tablero.cantMovimientos = 0;
							columnasYFilas();
							fin.dispose();
						}
					});					
					contador = 1;
				}
			}
		}
	}
	
	
	/**
	 * Metodo para que el usuario coloque las columas y filas que desee
	 */
	private void columnasYFilas() {
	
		//Creamos la pantalla inicial
		PantallaInicial inicio = new PantallaInicial();
		musica.loop(Clip.LOOP_CONTINUOUSLY);
		inicio.setVisible(true);
	
		//Listener para el boton de personalizacion de columnas
		inicio.botonColumnas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputColumna = null;
				try {
					inputColumna = JOptionPane.showInputDialog("Ingresa las columnas que desea");
					columnas = Integer.parseInt(inputColumna);
				} catch (NumberFormatException i) {
					if (inputColumna == null) {
						noPreparado = false;
					}
				}
				if (columnas == 0) {
					JOptionPane.showMessageDialog(null, "El numero de columnas no puede ser 0");
				}
			}
		});
		
		//Listener para el boton de personalizacion de filas
		inicio.botonFilas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputFila = null;
				try {
					inputFila = JOptionPane.showInputDialog("Ingresa las filas que desea");
					filas = Integer.parseInt(inputFila);
				} catch (NumberFormatException i) {
					if (inputFila == null) {
						noPreparado = false;
					}
				}
				if (filas == 0) {
					JOptionPane.showMessageDialog(null, "El numero de filas no puede ser 0");
				}
			}
		});
		
		//Listener para el boton de comienzo del juego
		inicio.botonInicioJuego.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(filas == 0 || columnas == 0) {
					JOptionPane.showMessageDialog(null, "El numero de columnas o filas no puede ser 0");
				}
				juegoTerminado = false;
				juego = new Tablero();
				juego.setBounds(500, 200, 500, 500);
				inicio.dispose();
				Tablero.cantMovimientos = 0;
			}
		});
	}
}