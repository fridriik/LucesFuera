package comportamiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vistas.PantallaGanador;
import vistas.PantallaInicial;
import vistas.Tablero;

public class Flow {
	
	//Utilizamos volatile ya que no registraba correctamente el boolean y es necesario poder mantenerla en la memoria principal
	public volatile static boolean juegoTerminado = false;
	public static boolean estaPreparado = true;
	public static int filas, columnas, cantMovimientos = 0, contador = 0;
	public Tablero juego;
	
	public Flow() {
		
		PantallaInicial inicio = new PantallaInicial();
		inicio.setVisible(true);
		
		inicio.botonInicioJuego.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(filas == 0 || columnas == 0) {
					JOptionPane.showMessageDialog(null, "El numero de columnas o filas no puede ser 0");
				}
				juegoTerminado = false;
				juego = new Tablero();
				juego.setBounds(500, 200, 500, 500);
				juego.setVisible(true);
				cantMovimientos = 0;
				inicio.dispose();
			}
		});
		
		inicio.botonColumnas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputColumna = null;
				try {
					inputColumna = JOptionPane.showInputDialog("Ingresa las columnas que desea");
					columnas = Integer.parseInt(inputColumna);
				} catch (NumberFormatException i) {
					if (inputColumna == null) {
						estaPreparado = false;
					}
				}
				if (columnas == 0) {
					JOptionPane.showMessageDialog(null, "El numero de columnas no puede ser 0");
				}
			}
		});
		
		inicio.botonFilas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputFila = null;
				try {
					inputFila = JOptionPane.showInputDialog("Ingresa las filas que desea");
					filas = Integer.parseInt(inputFila);
				} catch (NumberFormatException i) {
					if (inputFila == null) {
						estaPreparado = false;
					}
				}
				if (filas == 0) {
					JOptionPane.showMessageDialog(null, "El numero de filas no puede ser 0");
				}
			}
		});
		
		while (true) {
			if (juegoTerminado) {
				if (contador == 0) {
					PantallaGanador fin = new PantallaGanador();
					fin.setVisible(true);
					juego.dispose();
					
					fin.salir.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							fin.dispose();	
						}
					});
					
					fin.seguirJugando.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							juegoTerminado = false;
							juego = new Tablero();
							juego.setBounds(500, 200, 500, 500);
							juego.setVisible(true);
							cantMovimientos = 0;
							fin.dispose();
						}
					});					
					contador = 1;
				}
			}
		}
	}
}