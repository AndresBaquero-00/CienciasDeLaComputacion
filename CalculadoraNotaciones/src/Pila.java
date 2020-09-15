
public class Pila {
	Nodo p;
	Pila(){
		p = null;
	}
	void initPila() {
		p = null;
	}
	boolean pilaVacia() {
		return (p==null);
	}
	void insPila(String s) {
		Nodo nuevo;
		
		nuevo = new Nodo(s);
		nuevo.info = s;
		nuevo.sig = p;
		p = nuevo;
	}
	String retiraPila() {
		Nodo q;
		
		if(pilaVacia()) {
			return "#";
		}
		else {
			String s;
			q = p.sig;
			s = p.info;
			p = q;
			return s;
		}
	}
}
