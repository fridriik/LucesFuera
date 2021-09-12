package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vistas.PantallaInicial.ImagenFondo;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class PantallaGanador extends JFrame{
	public JButton seguirJugando, salir;
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
		setBounds(500, 200, 500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/externalMedia/fondo.png"));
			setContentPane(new ImagenFondo(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/externalMedia/ArcadeClassic.ttf"));
            cartelGanador = new JLabel(); 
    		cartelGanador.setForeground(Color.CYAN);
    		cartelGanador.setBounds(140, 91, 220, 31);
    		cartelGanador.setText("G A N A S T E  ! ! !");
    		cartelGanador.setFont(font.deriveFont(Font.PLAIN, 30f));
    		getContentPane().add(cartelGanador);
    		
    		seguirJugando = new JButton("Jugar");
    		seguirJugando.setBackground(Color.CYAN);
    		seguirJugando.setForeground(Color.BLACK);
    		seguirJugando.setBounds(33, 344, 130, 35);
    		seguirJugando.setFont(font.deriveFont(Font.PLAIN, 20f));
    		getContentPane().add(seguirJugando);
    		
    		salir = new JButton("Salir");
    		salir.setBackground(Color.CYAN);
    		salir.setBounds(331, 344, 130, 35);
    		salir.setFont(font.deriveFont(Font.PLAIN, 20f));
    		getContentPane().add(salir);
		} catch (IOException | FontFormatException ex) {
            ex.printStackTrace();
        }
	}
	
		public class ImagenFondo extends JComponent {
		
			private Image image;
		
			public ImagenFondo(Image image) {
				this.image = image;
			}
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, this);
			}
		}
}
