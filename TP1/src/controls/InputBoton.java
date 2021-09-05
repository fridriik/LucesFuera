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
		JButton button = (JButton)e.getSource();		
		String location = button.getName();				
		char colChar = location.charAt(0);				
		char rowChar = location.charAt(1);				
		int col = Character.getNumericValue(colChar);	
		int row = Character.getNumericValue(rowChar);	
		
		JButton tempSelected = new JButton();			
		JButton tempTop = new JButton();				
		JButton tempLeft = new JButton();				
		JButton tempRight = new JButton();				
		JButton tempBottom = new JButton();				
		
		tempSelected = tablero.getBotonesDelTablero()[col][row];			
		tablero.backgroundColor(tempSelected);					
		
		try {
			tempTop = tablero.getBotonesDelTablero()[col-1][row];			
			tablero.backgroundColor(tempTop);				
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
		try {
			tempLeft = tablero.getBotonesDelTablero()[col][row-1];			
			tablero.backgroundColor(tempLeft);	
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
		try {
			tempRight = tablero.getBotonesDelTablero()[col][row+1];	
			tablero.backgroundColor(tempRight);					
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
		try {
			tempBottom = tablero.getBotonesDelTablero()[col+1][row];	
			tablero.backgroundColor(tempBottom);				
		}
		catch(ArrayIndexOutOfBoundsException i) {
			
		}
	}
}
