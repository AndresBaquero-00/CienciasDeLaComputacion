import java.awt.Graphics;

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
			return -1;
		}
		else if(n < p.info) {
			insIzq(p, n);
		}
		else{
			insDer(p, n);
		}
		return 1;
	}
	
	public Nodo borrarDato(Nodo q, Nodo p) {
		Nodo r,t,s;
		
		if(p.izq == null) {
			r = p.der;
		}
			
		else if(p.der == null) {
			r = p.izq;
		}
		
		else {
			s = p;
			r = p.der;
			t = r.izq;
			
			while(t != null) {
				s = r;
				r = t;
				t = t.izq;
			}
			if(p != s) {
				s.izq = r.der; 
				r.der = p.der;
			}
			r.izq = p.izq;
		}
		if(q == null) {
			raiz = r;
			return raiz;
		}
		else if(p == q.izq) {
			q.izq = r;
			return q.izq;
		}
		else {
			q.der = r;
			return q.der;
		}
		
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
