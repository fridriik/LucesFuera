package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

@SuppressWarnings({ "serial", "unused" })
public class PantallaGanador extends JFrame{
	public JButton seguirJugando;
	public JButton salir;
	private JLabel cartelGanador;

	/**
	 * Constructor de la pantalla final
	 * Utilizamos GridBagLayout para organizar correctamente
	 * el Label de felicitaciones y los botones para volver a jugar
	 * y para salir del juego
	 */
	public PantallaGanador() {
		setTitle("Fin del juego!");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{125, 250, 125, 0};
		gridBagLayout.rowHeights = new int[]{250, 250, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		cartelGanador = new JLabel();
		cartelGanador.setText("G A N A S T E  ! ! !");
		cartelGanador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));
		GridBagConstraints gbc_cartelGanador = new GridBagConstraints();
		gbc_cartelGanador.gridx = 1;
		gbc_cartelGanador.gridy = 0;
		getContentPane().add(cartelGanador, gbc_cartelGanador);
		
		seguirJugando = new JButton("Jugar");
		seguirJugando.setFont(new Font("ArcadeClassic", Font.PLAIN, 16));
		GridBagConstraints gbc_seguirJugando = new GridBagConstraints();
		gbc_seguirJugando.anchor = GridBagConstraints.EAST;
		gbc_seguirJugando.gridx = 0;
		gbc_seguirJugando.gridy = 1;
		getContentPane().add(seguirJugando, gbc_seguirJugando);
		
		salir = new JButton("Salir");
		salir.setFont(new Font("ArcadeClassic", Font.PLAIN, 16));
		GridBagConstraints gbc_salir = new GridBagConstraints();
		gbc_salir.anchor = GridBagConstraints.WEST;
		gbc_salir.gridx = 2;
		gbc_salir.gridy = 1;
		getContentPane().add(salir, gbc_salir);
	}
}
