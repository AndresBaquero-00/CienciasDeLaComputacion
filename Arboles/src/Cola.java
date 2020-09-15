
class Cola {
	NodoCola cola;
	
	Cola(){
		cola = new NodoCola(null);
		cola.sig = cola;
	}
	
	void sumar(Nodo objeto) {
		NodoCola nuevo = new NodoCola(objeto);
		nuevo.sig = cola.sig;
		cola.sig = nuevo;
		cola = nuevo;
	}
	
	Nodo atender() {
		NodoCola q,r;
		Nodo temp;
		if(cola == cola.sig) {
			return null;
		}
		q = cola.sig;
		r = q.sig;
		temp = r.info;
		q.sig = r.sig;
		if(q == q.sig) {
			cola = q;
		}
		return temp;
	}
	
	boolean vacia() {
		return cola == cola.sig;
	}
}

class NodoCola{
	Nodo info;
	
	NodoCola(Nodo info){
		this.info = info;
	}
	
	NodoCola sig;
}
