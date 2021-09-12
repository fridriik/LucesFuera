package vistas;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings("serial")
public class PantallaInicial extends JFrame{
	
	public JButton botonInicioJuego, botonColumnas, botonFilas;
	private JLabel titulo;
	
	public PantallaInicial() {
		setTitle("Luces Fuera!");
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
            titulo = new JLabel("L U C E S   F U E R A  !");
    		titulo.setForeground(Color.CYAN);
    		titulo.setBounds(121, 32, 249, 21);
    		titulo.setFont(font.deriveFont(Font.PLAIN, 30f));
    		getContentPane().add(titulo);
    		
    		botonColumnas = new JButton("Columnas");
    		botonColumnas.setBackground(Color.CYAN);
    		botonColumnas.setBounds(21, 265, 130, 35);
    		botonColumnas.setFont(font.deriveFont(Font.PLAIN, 20f));
    		getContentPane().add(botonColumnas);
    		
    		botonFilas = new JButton("Filas");
    		botonFilas.setBackground(Color.CYAN);
    		botonFilas.setBounds(329, 265, 130, 35);
    		botonFilas.setFont(font.deriveFont(Font.PLAIN, 20f));
    		getContentPane().add(botonFilas);
    		
    		botonInicioJuego = new JButton("Jugar !");
    		botonInicioJuego.setBackground(Color.CYAN);
    		botonInicioJuego.setBounds(165, 350, 150, 35);
    		botonInicioJuego.setFont(font.deriveFont(Font.PLAIN, 20f));
    		getContentPane().add(botonInicioJuego);
    		
    		JTextArea txtBienvenida = new JTextArea();
    		txtBienvenida.setForeground(Color.WHITE);
    		txtBienvenida.setBounds(41, 113, 404, 79);
    		txtBienvenida.setText("  Ingresa  las columnas y filas con  las que \n                            quieras armar el tablero \n                  Cuando  termines  pulsa  Jugar !");
    		txtBienvenida.setFont(font.deriveFont(Font.PLAIN, 20f));
    		txtBienvenida.setEditable(false);
    		txtBienvenida.setOpaque(false);
    		getContentPane().add(txtBienvenida);
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