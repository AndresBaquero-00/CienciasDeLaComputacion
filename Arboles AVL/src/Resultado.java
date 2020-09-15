import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;

public class Resultado extends JFrame{
	
	private int x = 1360;
	private JPanel contentPane;
	private int diametro = 40;
    private int radio = diametro/2;
    private int ancho = 40;
    private ArbolesAVL arbol;
    private Nodo raiz;
    private JLabel inorden;
    private JLabel preorden;
    private JLabel posorden;

	/**
	 * Create the frame.
	 */
	public Resultado(ArbolesAVL arbol) {
		setTitle("Diagrama Arbol");
		this.arbol = arbol;
    	this.raiz = arbol.raizArbol();
    	
		setBounds(0, 0, x, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[86px][69px][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[23px][][]"));
						
		JLabel lblPreorden = new JLabel("Preorden");
		panel.add(lblPreorden, "cell 0 1 2 1");
		
		preorden = new JLabel("");
		panel.add(preorden, "cell 3 1 34 1");
		
		JLabel lblPosorden = new JLabel("Posorden");
		panel.add(lblPosorden, "cell 0 2 2 1");
		
		posorden = new JLabel("");
		panel.add(posorden, "cell 3 2 34 1");
		
		JLabel lblInorden = new JLabel("Inorden");
		panel.add(lblInorden, "cell 0 0 2 1");
		
		inorden = new JLabel("");
		panel.add(inorden, "cell 2 0 35 1");
		orden(raiz);
	}
	
	public void paint(Graphics g) {
    	super.paint(g);
    	dibujar(x/2, 220, raiz, g);
    	
	}
	
	public void orden(Nodo raiz) {
		if(raiz != null) {
			
			preorden.setText(preorden.getText()+raiz.info+" ");
			
			orden(raiz.izq);
			
			inorden.setText(inorden.getText()+raiz.info+" ");
			
			orden(raiz.der);
			
			posorden.setText(posorden.getText()+raiz.info+" ");
		}
	}
	
	public void dibujar(int x, int y, Nodo raiz, Graphics g) {
		if(raiz != null) {

			int extra = raiz.completo(raiz)*ancho;
			
			//g.drawOval(x, y, diametro, diametro);
			g.drawString(""+raiz.info, x+10, y+15);
			
			if(raiz.izq != null) {
				g.drawLine(x + radio, y + radio, x - ancho - extra + radio, y + ancho + radio);
			}
			if(raiz.der != null) {
				g.drawLine(x + radio, y + radio, x + ancho + extra + radio, y + ancho + radio);
			}
			
			dibujar(x - ancho - extra, y + ancho, raiz.izq, g);
			dibujar(x + ancho + extra, y + ancho, raiz.der, g);
		}
	}

}
