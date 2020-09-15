import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Cliente extends JFrame{
	
	private static int diametro = 30;
    private static int radio = diametro/2;
    private static int ancho = 30;
    private static String[] inorden = {"d","z","p","w","c","e","g","f","a","b"};
    private static String[] preorden = null; /*{"a","g","c","d","z","w","p","e","f","b"};*/
    private static String[] posorden = {"p","w","z","d","e","c","f","g","b","a"};
        
    public Cliente() {
		setBounds(100, 100, 1040, 500);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
	}
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
	public void paint(Graphics g) {
    	super.paint(g);
    	if(preorden != null) {
    		System.out.println("entra");
    		reconstruir(500, 150, inorden, preorden, g);
    	}
    	if(posorden != null) {
    		reconstruirP(500, 150, inorden, posorden, g);
    	}
	}
	
	public static void reconstruir(int x, int y, String[] inorden, String[] preorden, Graphics g) {
		String raiz = preorden[0];
		int temp = 0;
		
		int extra = inorden.length*ancho/2;
		
		for(int i=0; i<inorden.length; i++) {
			if(inorden[i].equals(raiz)) {
				temp = i;
			}
		}
		
		String []izquierdaI = new String[temp];
		String []derechaI = new String[inorden.length - temp - 1];
		String []izquierdaP = new String[temp];
		String []derechaP = new String[inorden.length - temp - 1];
			
		for(int i=0; i < temp; i++) {
			izquierdaI[i] = inorden[i];
			izquierdaP[i] = preorden[i+1];
		}

		for(int i=0, j=temp+1; (i < inorden.length-temp) && (j < inorden.length); i++, j++) {
			derechaI[i] = inorden[j];
			derechaP[i] = preorden[j];
		}
		
		if(izquierdaI.length >= 1) {
			g.drawLine(x + radio, y + radio, x - ancho - extra + radio, y + ancho + radio);
			reconstruir(x - ancho - extra, y + ancho,izquierdaI, izquierdaP, g);
		}
		g.drawOval(x, y, diametro, diametro);
		g.drawString(""+raiz, x+5, y+15);
		if(derechaI.length >= 1) {
			g.drawLine(x + radio, y + radio, x + ancho + extra + radio, y + ancho + radio);
			reconstruir(x + ancho + extra, y + ancho,derechaI, derechaP, g);
		}
	}
	
	public static void reconstruirP(int x, int y, String[] inorden, String[] posorden, Graphics g) {
		String raiz = posorden[posorden.length-1];
		int temp = 0;
		//System.out.println(raiz);
		
		int extra = inorden.length*ancho/2;
		
		for(int i=0; i<inorden.length; i++) {
			if(inorden[i].equals(raiz)) {
				temp = i;
			}
		}
		
		String []izquierdaI = new String[temp];
		String []derechaI = new String[inorden.length - temp - 1];
		
		String []izquierdaP = new String[temp];
		String []derechaP = new String[inorden.length - temp - 1];
			
		for(int i=0; i < temp; i++) {
			izquierdaI[i] = inorden[i];
			izquierdaP[i] = posorden[i];
		}

		for(int i=0, j=temp; (i < inorden.length-temp) && (j < inorden.length-1); i++, j++) {
			derechaI[i] = inorden[j+1];
			derechaP[i] = posorden[j];
		}
		
		if(izquierdaI.length >= 1) {
			g.drawLine(x + radio, y + radio, x - ancho - extra + radio, y + ancho + radio);
			reconstruirP(x - ancho - extra, y + ancho,izquierdaI, izquierdaP, g);
		}
		g.drawOval(x, y, diametro, diametro);
		g.drawString(""+raiz, x+5, y+15);
		if(derechaI.length >= 1) {
			g.drawLine(x + radio, y + radio, x + ancho + extra + radio, y + ancho + radio);
			reconstruirP(x + ancho + extra, y + ancho,derechaI, derechaP, g);
		}
		
	}
}
