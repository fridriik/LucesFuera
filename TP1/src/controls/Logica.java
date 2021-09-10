package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import forms.PantallaGanador;
import forms.Tablero;

public class Logica {
	
	//Utilizamos volatile ya que no registraba correctamente el boolean y es necesario poder mantenerla en la memoria principal
	public volatile static boolean juegoTerminado = false;
	public static int cantMovimientos = 0;
	public static Tablero juego;
	public static int contador = 0;
	
	public static void main(String[] args) {
		
		juego = new Tablero();
		juego.setBounds(0, 0, 500, 500);
		juego.setVisible(true);
		
		while(true) {
			if(juegoTerminado) {
				if(contador == 0) {
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
							juego.setBounds(0, 0, 500, 500);
							juego.setVisible(true);
							fin.dispose();
							cantMovimientos = 0;
						}
					});					
					contador = 1;
				}
			}
		}
	}
}