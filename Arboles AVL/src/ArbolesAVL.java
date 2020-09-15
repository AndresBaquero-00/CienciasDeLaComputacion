import java.util.Stack;

public class ArbolesAVL{

	Nodo raiz;
	int fila;
	int cantNodos;
	
	ArbolesAVL(int c){
		cantNodos = c;
		raiz = null;
	}

	void rDerecha(Nodo p, Nodo q){

		p.bal = 0;
		q.bal = 0;
		p.izq = q.der;
		q.der = p;
	}

	void rIzquierda(Nodo p, Nodo q){

		p.bal = 0;
		q.bal = 0;
		p.der = q.izq;
		q.izq = p;
	}

	Nodo drDerecha(Nodo p, Nodo q){

		Nodo r;
		r = q.der;
		q.der = r.izq;
		r.izq = q;
		p.izq = r.der;
		r.der = p;

		switch(r.bal){

			case -1:
				q.bal = 1;
				p.bal = 0;
				break;
			case 0:
				q.bal = p.bal = 0;
				break;
			case 1:
				q.bal = 0;
				p.bal = -1;
				break;
		}
		r.bal = 0;
		return r;
	}
	Nodo drIzquierda(Nodo p, Nodo q){

		Nodo r;
		r = q.izq;
		q.izq = r.der;
		r.der = q;
		p.der = r.izq;
		r.izq = p;

		switch(r.bal){

			case -1:
				q.bal = 0;
				p.bal = 1;
				break;
			case 0:
				q.bal = p.bal = 0;
				break;
			case 1:
				q.bal = -1;
				p.bal = -0;
				break;
		}
		r.bal = 0;
		return r;
	}

	int insAVL(String n, int e){
		Nodo nuevo,p,q,s,pivote,pp;
		int altura;
		String llave;

		nuevo = new Nodo(n, e);

		if(raiz == null){
			
			raiz = nuevo;
			return 1; //El arbol tiene un solo nodo
		}
		pp = q = null;
		pivote = p = raiz;
		llave = nuevo.info;
		
		while(p != null){

			if(p.bal != 0){

				pp = q;
				pivote = p;
			}
			if(llave == p.info){

				return 2; //Ya existe el nodo
			}else{
				
				q = p;
				if(llave.compareTo(p.info) < 0)
					p = p.izq;
				else
					p = p.der;
			}
		}

		if(llave.compareTo(q.info) < 0)
			q.izq = nuevo;
		else
			q.der = nuevo;

		if(llave.compareTo(pivote.info) < 0){

			s = pivote.izq;
			altura = 1;
		}else{

			s = pivote.der;
			altura = -1;
		}
		p = s;
		
		while(p != nuevo){

			if(llave.compareTo(p.info) < 0){

				p.bal = 1;
				p = p.izq;
			}else{

				p.bal = -1;
				p = p.der;
			}


		}

		if(pivote.bal == 0)
			pivote.bal = altura;
		else if(pivote.bal + altura == 0)
			pivote.bal = 0;
		else{

			if(altura == 1){

				if(s.bal == 1)
					rDerecha(pivote,s);
				else
					s = drDerecha(pivote,s);
			}else{

				if(s.bal == -1)
					rIzquierda(pivote,s);
				else
					s = drIzquierda(pivote,s);
			}
			if(pp == null)
				raiz = s;
			else if(pp.izq == pivote)
				pp.izq = s;
			else
				pp.der = s;
		}
	return 1;

	}

	Nodo raizArbol(){
		return raiz;
	}
	
	void inorden(Nodo p) {
		if(p != null) {
			inorden(p.izq);
			System.out.println(p.info);
			inorden(p.der);
		}
	}
	
	void initFila(){
		fila = 0;
	}

	Nodo bal_der(Nodo q, int[] terminar){

		Nodo t = null;
		switch(q.bal){

			case 1: 
				q.bal = 0;
				break;

			case -1:
				t = q.der;
				switch(t.bal){

					case 1:
						t = drIzquierda(q, t);
						break;

					case -1:
						rIzquierda(q, t);
						break;
					
					case 0:
						q.der = t.izq;
						t.izq = q;
						t.bal = 1;
						terminar[0] = 1;
						break;
				}
				break;
			case 0:
				q.bal = -1;
				terminar[0] = 1;
				break;
		}
		return t;
	}

	Nodo bal_izq(Nodo q, int[] terminar){

		Nodo t = null;
		switch(q.bal){

			case -1: 
				q.bal = 0;
				break;

			case 1:
				t = q.izq;
				switch(t.bal){

					case -1:
						t = drDerecha(q, t);
						break;

					case 1:
						rDerecha(q, t);
						break;
					
					case 0:
						q.izq = t.der;
						t.der = q;
						t.bal = 1;
						terminar[0] = 1;
						break;
				}
				break;
			case 0:
				q.bal = -1;
				terminar[0] = 1;
				break;
		}
		return t;
	}
	
	int consultarEdad(String n) {
		Stack pila = new Stack();
		boolean encontro = false;
		Nodo p = raiz;
	
		while(!encontro && p != null){
			pila.push(p);
			if(n.compareTo(p.info) < 0)
				p = p.izq;
			else if(n.compareTo(p.info) > 0)
				p = p.der;
			else encontro = true;
		}
		if(!encontro){
			return -1;
		}
		
		return p.edad;
	}
	
	int retirarAVIL(String n){
		Stack pila = new Stack();
		Nodo p,q,t,r;
		String llave;
		int accion;

		//Para trabajar terminar por referencia
		int []terminar = new int[1];

		boolean encontro = false;

		if(raiz == null){
			return 1;
		}
		terminar[0] = 0;
		p = raiz;

		while(!encontro && p != null){
			pila.push(p);
			if(n.compareTo(p.info) < 0)
				p = p.izq;
			else if(n.compareTo(p.info) > 0)
				p = p.der;
			else encontro = true;
		}

		if(!encontro){
			return 2;
		}

		t = null;
		p = (Nodo) pila.pop();
		llave = p.info;

		if(p.izq == null && p.der == null)
			accion = 0;
		else if(p.der == null)
			accion = 1;
		else if(p.izq == null)
			accion = 2;
		else accion = 3;

		if(accion == 0 || accion == 1 || accion == 2){
			if(!pila.empty()){
				q = (Nodo) pila.pop();
				if(llave.compareTo(q.info) < 0){
					switch(accion){
						case 0:
						
						case 1:
							q.izq = p.izq;
							t = bal_der(q,terminar);
							break;
						case 2:
							q.izq = p.der;
							t = bal_der(q,terminar);
							break;
					}
				}else{
					switch(accion){
						case 0:
						
						case 2:
							q.der = p.der;
							t = bal_izq(q,terminar);
							break;
						case 1:
							q.der = p.izq;
							t = bal_izq(q,terminar);
							break;
					}
				}
			}else{
				switch(accion){
					case 0:
						raiz = null;
						terminar[0] = 1;
						break;
					case 1:
						raiz = p.izq;
						break;
					case 2:
						raiz = p.der;
						break;
				}
			}
		}else{
			pila.push(p);
			r = p;
			p = r.der;
			q = null;

			while(p.izq != null){
				pila.push(p);
				q = p;
				p = p.izq;
			}
			llave = r.info = p.info;

			if(q != null){
				q.izq = p.der;
				t = bal_der(q, terminar);
			}else{
				r.der = p.der;
				t = bal_izq(r,terminar);
			}
			q = (Nodo) pila.pop();
		}
		while(!pila.empty() && terminar[0] == 0){
			q = (Nodo) pila.pop();
			if(llave.compareTo(q.info) < 0){
				if(t != null){
					q.izq = t;
					t = null;
				}
				t = bal_der(q, terminar);
			}
			else {
				if(t != null) {
					q.der = t;
					t = null;
				}
				t = bal_izq(q, terminar);
			}
		}
		if(t != null){
			if(pila.empty() == true)
				raiz = t;
			else{
				q = (Nodo) pila.pop();
				if(llave.compareTo(q.info) < 0)
					q.izq = t;
				else q.der = t;
			}
		}
		return 0;
	}

}