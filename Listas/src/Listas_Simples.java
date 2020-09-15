import java.util.Arrays;

public class Listas_Simples {
	Nodo cab;
	Listas_Simples ordenada;
	int size;
	
	Listas_Simples(){
		cab = null;
	}
	
	void ins_final(int x) {
		Nodo p = new Nodo(x);
		Nodo q = cab;
		Nodo s = null;
		while(q != null) {
			s = q;
			q = q.siguiente;
			
		}
		if(s == null) {
			cab = p;
		}
		else {
			s.siguiente = p;
		}
		size++;
	}
	
	void ordenar_lista() {
		Nodo p, q;
		int temp;
		for(q = cab; q != null; q = q.siguiente) {
			for(p = q; p != null; p = p.siguiente) {
				if(q.info > p.info) {
					temp = q.info;
					q.info = p.info;
					p.info = temp;
				}
			}
		}
	}
	
	void escribir_lista() {
		Nodo q = cab;
		while(q != null) {
			System.out.print(q.info + " ");
			q = q.siguiente;
		}
		System.out.println();
	}
}
