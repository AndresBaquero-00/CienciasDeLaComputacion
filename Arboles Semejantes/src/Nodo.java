
public class Nodo {
	int info;
	Nodo izq;
	Nodo der;
	
	Nodo(int info){
		this.info = info;
		izq = der = null;
	}
	
	
	public int completo(Nodo n) {
		if(n == null) {
			return 0;
		}
		else {
			if(n.izq != null && n.der != null) {
				return completo(n.izq) + completo(n.der) + 1;
			}
			return completo(n.izq) + completo(n.der);
		}
	}
	
}
