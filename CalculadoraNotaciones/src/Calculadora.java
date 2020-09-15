
public class Calculadora {
	
	void inAPos(String []infijo, String []posfijo) {
		int i, j;
		String elemento;
		Pila pila = new Pila();
		i=0;
		j=-1;
		pila.initPila();
		
		while(infijo[i].equals("#") == false) {
			if(operando(infijo[i])) {
				posfijo[++j] = infijo[i++];
			}
			else {
				
				while(!pila.pilaVacia() && prioridad(pila.p.info, infijo[i]).equals("1")) {
					
					elemento = pila.retiraPila();
					posfijo[++j] = elemento;
				}
				
				if(infijo[i].equals(")")) {	
					elemento = pila.retiraPila();
				}
				
				else {
					//System.out.println(infijo[i]);
					pila.insPila(infijo[i]);
				}
				i++;
			}
			
		}
				
		while(!pila.pilaVacia()) {
			elemento = pila.retiraPila();
			posfijo[++j] = elemento;
		}
		posfijo[++j] = "\0";
		
		for(int k=0; k<posfijo.length; k++) {
			System.out.print(posfijo[k]+"   ");
		}
	}
	
	boolean operando(String op) {
		try {
			Double.parseDouble(op);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	
	String prioridad(String fila, String columna) {
		String matriz[][] = {{".", "+", "-", "*", "/", "^", "(", ")"},
						{"+","1","1","0","0","0","0","1"},
						{"-","1","1","0","0","0","0","1"},
						{"*","1","1","1","1","0","0","1"},
						{"/","1","1","1","1","0","0","1"},
						{"^","1","1","1","1","0","0","1"},
						{"(","0","0","0","0","0","0","0"}};
		
		
		int col = 0;
		int fil = 0;
		
		for(int i=0; i<8; i++) {
			if(matriz[0][i].equals(columna)) {
				col = i;
			}
		}
		
		for(int i=0; i<7; i++) {
			if(matriz[i][0].equals(fila)) {
				fil = i;
			}
		}
		
		return matriz[fil][col];
	}
}
