package vistas;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PantallaInicial extends JFrame{
	
	public JButton botonInicioJuego, botonColumnas, botonFilas;
	private JLabel titulo;
	
	
	public PantallaInicial() {
		
		setTitle("Luces Fuera!");
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
            titulo = new JLabel("L U C E S   F U E R A  !");
            titulo.setHorizontalAlignment(SwingConstants.CENTER);
    		titulo.setForeground(Color.CYAN);
    		titulo.setBounds(21, 32, 438, 21);
    		titulo.setFont(font.deriveFont(Font.PLAIN, 18f));
    		getContentPane().add(titulo);
    		
    		botonColumnas = new JButton("COLUMNAS");
    		botonColumnas.setBackground(Color.CYAN);
    		botonColumnas.setBounds(21, 265, 138, 35);
    		botonColumnas.setFont(font.deriveFont(Font.PLAIN, 16f));
    		getContentPane().add(botonColumnas);
    		
    		botonFilas = new JButton("FILAS");
    		botonFilas.setBackground(Color.CYAN);
    		botonFilas.setBounds(324, 265, 135, 35);
    		botonFilas.setFont(font.deriveFont(Font.PLAIN, 16f));
    		getContentPane().add(botonFilas);
    		
    		botonInicioJuego = new JButton("JUGAR !");
    		botonInicioJuego.setBackground(Color.CYAN);
    		botonInicioJuego.setBounds(175, 337, 135, 35);
    		botonInicioJuego.setFont(font.deriveFont(Font.PLAIN, 16f));
    		getContentPane().add(botonInicioJuego);
    		
    		JTextArea txtBienvenida = new JTextArea();
    		txtBienvenida.setForeground(Color.WHITE);
    		txtBienvenida.setBounds(0, 105, 486, 79);
    		txtBienvenida.setText("       INGRESA LAS COLUMNAS Y LAS FILAS \n     CON LAS QUE QUIERAS ARMAR EL TABLERO \n        CUANDO TERMINES PULSA JUGAR !");
    		txtBienvenida.setFont(font.deriveFont(Font.PLAIN, 14f));
    		txtBienvenida.setEditable(false);
    		txtBienvenida.setOpaque(false);
    		getContentPane().add(txtBienvenida);
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