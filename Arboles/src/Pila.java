
public class Pila {
	final int MAXIMO = 20;
	int t;
	Nodo [] a;
	int []senal;
	
	Pila(){
		t = 0; a = new Nodo[MAXIMO];
		senal = new int[MAXIMO];
	}
	
	void initPila() {
		t = 0;
	}
	boolean pilaVacia() {
		return t==0;
	}
	
	int insPila(Nodo obj) {
		if(t == MAXIMO - 1)
			return -1;
		else {
			t++;
			a[t-1] = obj;
			senal[t-1] = 0;
		}
		return 1;
	}
	
	Nodo retiraPila() {
		if(pilaVacia())
			return null;
		else {
			t--;
			return a[t];
		}
	}
	
	int mirarPila(Nodo []s) {
		if(pilaVacia())
			return -1;
		else {
			s[0] = a[t-1];
			int i = senal[t-1];
			senal[t-1] = 1;
			return i;
		}
	}
}
