import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Resultado extends JFrame{
	private int diametro = 30;
    private int radio = diametro/2;
    private int ancho = 30;
    
    private Binario arbol_1;
    private Binario arbol_2;
    
    private Nodo raiz_1;
    private Nodo raiz_2;
   

	/**
	 * Create the frame.
	 */
	public Resultado(int []arbol1, int[]arbol2) {
		setBounds(100, 100, 1040, 500);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		arbol_1 = new Binario();
		arbol_2 = new Binario();
		
		for(int i=0; i<arbol1.length; i++) {
			arbol_1.insertarDato(arbol1[i]);
		}
		
		for(int i=0; i<arbol2.length; i++) {
			arbol_2.insertarDato(arbol2[i]);
		}
		
		raiz_1 = arbol_1.returnRaiz();
		raiz_2 = arbol_2.returnRaiz();
		
		if(arbol1.length == arbol2.length) {
			//preorden(raiz_1, raiz_2) && 
			if(parentesco(raiz_1, raiz_2)) {
				if(inorden(raiz_1, raiz_2) && preorden(raiz_1, raiz_2)) {
					System.out.println("Iguales");
				}else {
					System.out.println("Similares");
				}
			}else if(preorden(raiz_1, raiz_2)){
				System.out.println("Semejantes");
			}else {
				System.out.println("Distintos");
			}
			
		}else {
			System.out.println("Distintos");
		}
		
		//paint(getGraphics(), 300, raiz_1);
		//paint(getGraphics(), 600, raiz_2);
	}
	
	
	public boolean inorden(Nodo p, Nodo q) {
		if(p == null || q == null) {
			return true;
		}
		
		if(inorden(p.izq, q.izq)) {
			if(p.info != q.info) {
				return false;
			}
			
			if(inorden(p.der, q.der)) {
				return true;
			}else return false;
			
		}else return false;
	}
	
	public boolean preorden(Nodo p, Nodo q) {
		if(p == null || q == null) {
			return true;
		}
		if(p.info != q.info) {
			return false;
		}else {
			if(preorden(p.izq, q.izq)) {
				if(preorden(p.der, q.der)) {
					return true;
				}else return false;
			}else return false;
			
		}

	}
	
	public boolean parentesco(Nodo p, Nodo q) {
		if(p == null && q == null) {
			return true;
		}else if(p == null || q == null){
			return false;
		}else {
			if(parentesco(p.izq, q.izq)) {
				if(parentesco(p.der, q.der)) {
					return true;
				}else return false;
			}else return false;
		}
		
	}
	public void paint(Graphics g) {
    	super.paint(g);
    	dibujar(200, 220, raiz_1, g);
    	dibujar(600, 220, raiz_2, g);
	}
    
    public void dibujar(int x, int y, Nodo raiz, Graphics g) {
		if(raiz != null) {

			int extra = raiz.completo(raiz)*ancho/2;
			
			g.drawOval(x, y, diametro, diametro);
			g.drawString(""+raiz.info, x+5, y+15);
			
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

