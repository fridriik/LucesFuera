package controls;

import forms.VentanaPrincipal;
import java.awt.Font;


public class Juego {

	public static VentanaPrincipal inicio;
	
	public static void main(String[] args) {
		inicio = new VentanaPrincipal();
		inicio.comienzoDelJuego.setText("Comenzar  el juego!");
		// no creo que tengas la fuente ArcadeClassic, cualquier cosa dejo link de descarga
		// https://www.dafont.com/arcade-classic-2.font
		inicio.comienzoDelJuego.setFont(new Font("ArcadeClassic", Font.PLAIN, 15));
		inicio.setVisible(true);
	}
}