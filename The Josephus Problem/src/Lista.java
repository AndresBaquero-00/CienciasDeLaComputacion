import java.util.Arrays;

public class Lista {
	Nodo cab;
	Nodo ult;
	Nodo temp = cab;
	int size;
	
	Lista(){
		cab = null;
	}
	
	void ins_final(String x) {
		if(x.equals("final") == false){
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
				ult = p;
			}
			size++;
		}
		else {
			Nodo q = ult;
			q.siguiente = cab;
		}
	}

	void escribir_lista(int c) {
		Nodo q = cab;
		while(q != null && c != 0) {
			System.out.println(q.info + " ");
			q = q.siguiente;
			c--;
		}
		System.out.println();
	}

	void eliminar(int n){
	    for (int i = 0; i < n-1; i++) {
	    	cab = cab.siguiente;
	    }
	    cab.siguiente = cab.siguiente.siguiente;
	    cab = cab.siguiente;
	    size--;
	}
	
	int size() {
		return size;
	}
}