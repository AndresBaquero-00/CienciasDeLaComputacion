
public class Nodo{
	String info;
	int edad;
	int bal;
	Nodo izq;
	Nodo der;
	
	Nodo (String n, int e){
		edad = e;
		info = n;
		bal = 0;
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
