package forms;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;


public class VentanaPrincipal extends JFrame{
	
	public JButton comienzoDelJuego;
	static public boolean finDelJuego;
	
	public VentanaPrincipal() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finDelJuego = false;
		
		setTitle("Luces Fuera Version Alpha");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		comienzoDelJuego = new JButton("Comenzar el juego");
		comienzoDelJuego.setBounds(136, 100, 196, 29);
		getContentPane().add(comienzoDelJuego);		
	}
}
