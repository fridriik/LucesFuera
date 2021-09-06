package controls;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import forms.Juego;


public class InputBoton implements ActionListener{
	
	private Juego tablero;

	@Override
	public void actionPerformed(ActionEvent e) {
		tablero = new Juego();
		JButton boton = (JButton)e.getSource();		
		String lugarDelBoton = boton.getName();				
		char charDeColumna = lugarDelBoton.charAt(0);				
		char charDeFila = lugarDelBoton.charAt(1);				
		int columna = Character.getNumericValue(charDeColumna);	
		int fila = Character.getNumericValue(charDeFila);	
		
		JButton botonTemporalSeleccionado = new JButton();			
		JButton botonTemporalArriba = new JButton();				
		JButton botonTemporalIzquierda = new JButton();				
		JButton botonTemporalDerecha = new JButton();				
		JButton botonTemporalAbajo = new JButton();				
		
		botonTemporalSeleccionado = tablero.getBotonesDelTablero()[columna][fila];			
		tablero.colorDeFondo(botonTemporalSeleccionado);					
		
		try {
			botonTemporalArriba = tablero.getBotonesDelTablero()[columna-1][fila];			
			tablero.colorDeFondo(botonTemporalArriba);				
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
		try {
			botonTemporalIzquierda = tablero.getBotonesDelTablero()[columna][fila-1];			
			tablero.colorDeFondo(botonTemporalIzquierda);	
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
		try {
			botonTemporalDerecha = tablero.getBotonesDelTablero()[columna][fila+1];	
			tablero.colorDeFondo(botonTemporalDerecha);					
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
		try {
			botonTemporalAbajo = tablero.getBotonesDelTablero()[columna+1][fila];	
			tablero.colorDeFondo(botonTemporalAbajo);				
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
	}
}
