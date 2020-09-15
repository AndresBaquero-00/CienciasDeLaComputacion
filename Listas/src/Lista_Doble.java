
public class Lista_Doble {
	
	Nodo_Doble cab;
	Lista_Doble(){
		cab = null;
	}
	
	void ins_final(int x) {
		Nodo_Doble p = new Nodo_Doble(x);
		Nodo_Doble q = cab;
		Nodo_Doble s = null;
		while(q != null) {
			s = q;
			q = q.siguiente;
		}
		if(s == null) {
			cab = p;
		}
		else {
			s.siguiente = p;
			p.anterior = s;
		}
	}
	
	void escribir_lista() {
		Nodo_Doble q = cab;
		while(q != null) {
			System.out.print(q.info + " ");
			q = q.siguiente;
		}
		System.out.println();
	}
}
