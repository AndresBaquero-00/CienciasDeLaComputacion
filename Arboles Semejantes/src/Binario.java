import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Binario {
	
	Nodo raiz;
	int fila = 0;
	
	public Binario() {
		raiz = null;
	}
	
	public void filaCero() {
		fila = 0;
	}
	
	public int insertarDato(int n) {
		Nodo p, q;
		if(raiz == null) {
			raiz = new Nodo(n);
			return 1;
		}
		p = q = raiz;
		while(q != null && p.info != n) {
			p = q;
			if(n < p.info) {
				q = q.izq;
			}else {
				q = q.der;
			}
		}
		if(p.info == n) {
			String [] opcion = {"Izquierda","Derecha"};
			String resp = (String) JOptionPane.showInputDialog(null, "En que lado se inserta el numero "+n, "Insertar", JOptionPane.DEFAULT_OPTION, null, opcion, opcion[0]);
			
			if(resp.equals("Izquierda")) {
				insIzq(p, n);
			}else {
				insDer(p, n);
			}
		}
		else if(n < p.info) {
			insIzq(p, n);
		}
		else{
			insDer(p, n);
		}
		return 1;
	}
	
	public void insIzq(Nodo p, int izq) {
		Nodo nuevo = new Nodo(izq);
		p.izq = nuevo;
	}
	
	public void insDer(Nodo p, int der) {
		Nodo nuevo = new Nodo(der);
		p.der = nuevo;
	}
	
	public Nodo returnRaiz() {
		return raiz;
	}
	
	
}
