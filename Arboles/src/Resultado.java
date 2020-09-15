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

public class Resultado extends JFrame implements ActionListener{
	private int diametro = 30;
    private int radio = diametro/2;
    private int ancho = 30;
    private Binario bin;
    private Nodo raiz;
    private int num = 0;
    private JLabel preorden;
    private JLabel posorden;
    private JLabel inorden;
    
    private String pre;
    private String pos;
    private String in = "";
    private String nivel = "";
    private JTextField eliminar;
    private JButton btnEliminar;
    private JLabel lblNewLabel;

    private JLabel niv;

	/**
	 * Create the frame.
	 */
	public Resultado(int []arr) {
		setBounds(100, 100, 1040, 500);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblPreorden = new JLabel("Preorden: ");
		
		preorden = new JLabel("");
				
		JLabel lblPosorden = new JLabel("Posorden:");
		JLabel lblInorden = new JLabel("Inorden:");
		
		posorden = new JLabel("");
		inorden = new JLabel("");
		
		eliminar = new JTextField();
		eliminar.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		
		lblNewLabel = new JLabel("Niveles");
		
		niv = new JLabel("");
		
		niv = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPreorden, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(preorden, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
									.addGap(43)
									.addComponent(eliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPosorden)
									.addGap(6)
									.addComponent(posorden, GroupLayout.PREFERRED_SIZE, 876, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(btnEliminar))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblInorden)
									.addGap(18)
									.addComponent(inorden, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(niv, GroupLayout.PREFERRED_SIZE, 836, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPreorden, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(preorden, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(eliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPosorden, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(posorden, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(inorden)
							.addGap(27))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblInorden, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(niv, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(52))
		);
		panel.setLayout(gl_panel);
		bin = new Binario();
		
		for(int i=0; i<arr.length; i++) {
			bin.insertarDato(arr[i]);
		}
		
		raiz = bin.returnRaiz();
		otro();
	}
	
	public void otro() {
		in = ""; pre = ""; pos = ""; nivel="";
		inorden(raiz);
		inorden.setText(in);
		
		preorden(raiz);
		preorden.setText(pre);
		
		posorden(raiz);
		posorden.setText(pos);
		
		niveles(raiz);
		niv.setText(nivel);
	}
	public void inordenBorrar(int num) {
		Nodo p, q, r;
		r = p = q = raiz;
		if(num == raiz.info) {
			// 8,4,7,5,9,3,2
			inorden(raiz);
			
			String [] a = in.split("  ");

			int [] b = new int [a.length];
			int temp = 0;
			
			for(int i=0; i<b.length; i++) {
				b[i] = Integer.parseInt(a[i]);
				if(b[i] == num) {
					temp = i+1;
				}
			}
			
			while(q != null && p.info != b[temp]) {
				r = p;
				p = q;
				if(b[temp] < p.info) {
					q = q.izq;
				}else {
					q = q.der;
				}
			}
			
			if(p.info == b[temp]) {
				p.izq = raiz.izq;
				if(r != raiz) {
					System.out.println(p.info);
					if(p.der == null) {
						p.der = raiz.der;
						r.izq = null;
						raiz = p;
					}else {
						r.izq = p.der;
						p.der = raiz.der;
						raiz = p;
					}
				}else {
					raiz = p;
				}
			}
			
		}else {
			while(q != null && p.info != num) {
				r = p;
				p = q;
				if(num < p.info) {
					q = q.izq;
				}else {
					q = q.der;
				}
			}
			if(p.info == num) {
				r = bin.borrarDato(r, p);
			}
		}
	}
	
	public void inorden(Nodo p) {
		Pila pila = new Pila();
		pila.initPila();
		while(p != null) {
			pila.insPila(p);
			p = p.izq;
		}
		System.out.println("LLega 1");
		while(!pila.pilaVacia()) {
			p = pila.retiraPila();
			in = in + p.info+"  ";
			p = p.der;
			while(p != null) {
				pila.insPila(p);
				p = p.izq;
			}
		}
	}
	
	public void preorden(Nodo p) {
		Pila pila = new Pila();
		
		pila.initPila();
		while(p != null) {
			pre = pre+"  "+p.info+"  ";
			pila.insPila(p);
			p = p.izq;
		}
		while(!pila.pilaVacia()) {
			p = pila.retiraPila();
			p = p.der;
			while(p != null) {
				pre = pre+"  "+p.info+"  ";
				pila.insPila(p);
				p = p.izq;
			}
		}
	}
	
	public void niveles(Nodo p) {
		Cola cola = null;
		if(p != null) {
			cola = new Cola();
			cola.sumar(p);
		}
		while(!cola.vacia()) {
			p = cola.atender();
			nivel = nivel +"  "+ p.info +"  ";
			if(p.izq != null) {
				cola.sumar(p.izq);
			}
			if(p.der != null) {
				cola.sumar(p.der);
			}
		}
	}
	
	public void posorden(Nodo p) {
		int i;
		Nodo []s = new Nodo[1];
		Pila pila = new Pila();
		pila.initPila();
		
		while(p != null) {
			pila.insPila(p);
			p = p.izq;
		}
		while(!pila.pilaVacia()) {
			i = pila.mirarPila(s);
			p = s[0];
			
			if(i==0) 
				p = p.der;
			else
				p = null;
			
			if(p != null) {
				while(p != null) {
					pila.insPila(p);
					p = p.izq;
				}
			}
			else {
				p = pila.retiraPila();
				pos = pos + "  "+p.info+"  ";
			}
		}
	}
	
	public void paint(Graphics g) {
    	super.paint(g);
    	dibujar(500, 220, raiz, g, 10);
	}
    
    public void dibujar(int x, int y, Nodo raiz, Graphics g, int num) {
		if(raiz != null) {

			int extra = num*raiz.completo(raiz)*ancho/2;
			
			g.drawOval(x, y, diametro, diametro);
			g.drawString(""+raiz.info, x+5, y+15);
			
			if(raiz.izq != null) {
				g.drawLine(x + radio, y + radio, x - ancho - extra + radio, y + ancho + radio);
			}
			if(raiz.der != null) {
				g.drawLine(x + radio, y + radio, x + ancho + extra + radio, y + ancho + radio);
			}
			
			dibujar(x - ancho - extra, y + ancho, raiz.izq, g, num-1);
			dibujar(x + ancho + extra, y + ancho, raiz.der, g, num-1);
		}
	}
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnEliminar) {
			inordenBorrar(Integer.parseInt(eliminar.getText()));
			otro();
			paint(getGraphics());
		}
    }
}

