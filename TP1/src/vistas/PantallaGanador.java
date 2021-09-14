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
	private JLabel cartelGanador, cartelMovFinales;

	
	public PantallaGanador() {
		
		setTitle("Fin del juego!");
		setSize(500, 500);
		setBounds(500, 200, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Le agregamos una imagen de fondo
		try {
			BufferedImage image = ImageIO.read(getClass().getResource("/externalMedia/fondo.png"));
			setContentPane(new ImagenFondo(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Cargamos una fuente personalizada y creamos lo necesario para la interfaz
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/externalMedia/ARCADEPI.ttf"));
            cartelGanador = new JLabel(); 
    		cartelGanador.setForeground(Color.CYAN);
    		cartelGanador.setBounds(121, 32, 249, 21);
    		cartelGanador.setText("G A N A S T E  ! ! !");
    		cartelGanador.setFont(font.deriveFont(Font.PLAIN, 18f));
    		getContentPane().add(cartelGanador);
    		
    		cartelMovFinales = new JLabel(); 
    		cartelMovFinales.setHorizontalAlignment(SwingConstants.CENTER);
    		cartelMovFinales.setForeground(Color.WHITE);
    		cartelMovFinales.setBounds(0, 110, 486, 31);
    		cartelMovFinales.setText("LO COMPLETASTE EN :  "+ Tablero.cantMovimientos + " MOVIMIENTO(S) !");
    		cartelMovFinales.setFont(font.deriveFont(Font.PLAIN, 16f));
    		getContentPane().add(cartelMovFinales);
    		
    		seguirJugando = new JButton("JUGAR");
    		seguirJugando.setBackground(Color.CYAN);
    		seguirJugando.setForeground(Color.BLACK);
    		seguirJugando.setBounds(33, 344, 130, 35);
    		seguirJugando.setFont(font.deriveFont(Font.PLAIN, 16f));
    		getContentPane().add(seguirJugando);
    		
    		salir = new JButton("SALIR");
    		salir.setBackground(Color.CYAN);
    		salir.setBounds(331, 344, 130, 35);
    		salir.setFont(font.deriveFont(Font.PLAIN, 16f));
    		getContentPane().add(salir);
		} catch (IOException | FontFormatException ex) {
            ex.printStackTrace();
        }
	}
	
	
	//Extendemos para poder personalizar el fondo con una imagen
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
