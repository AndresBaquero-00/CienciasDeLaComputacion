
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class Cliente extends JFrame {

    private JPanel contentPane;
    private static int diametro = 30;
    private static int radio = diametro/2;
    private static int ancho = 30;
    private static Binario bin;
    private static Nodo raiz;
    
    /**
     * Create the frame.
     */
    public Cliente(int[] arr) {
    	
    	bin = new Binario();
		for(int i=0; i<arr.length; i++) {
			bin.insertarDato(arr[i]);
		}
		raiz = bin.returnRaiz();
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,600);
        /*
        Container c = getContentPane();
        JScrollPane jsp = new JScrollPane(contentPane);
        c.add(jsp);*/
    }
    
    public void paint(Graphics g) {
    	super.paint(g);
    	inorden(500, 150, raiz, g);
	}
    
    public void inorden(int x, int y, Nodo raiz, Graphics g) {
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
			
			inorden(x - ancho - extra, y + ancho, raiz.izq, g);
			inorden(x + ancho + extra, y + ancho, raiz.der, g);
		}
	}
}