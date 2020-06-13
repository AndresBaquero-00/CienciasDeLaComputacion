import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class quick {
	
	private int N;
	private int a[];
	private int c=0;
	private double formula;
	
	public quick(String n) throws IOException {
		this.N = Integer.parseInt(n); 
		this.a = new int[N];

	}
	
	public void llenarArreglo(int orden) {
		if(orden == 1) {
			//Mejor caso
			this.formula = 44 - 23*N + 13*N*Math.log(N);
			for(int i = 0; i < N; i++) {
				this.a[i] = i;
			}
		}
		
		else if(orden == 2) {
			//Peor caso
			this.formula = 44 - 23*N + 13*N*Math.log(N);
			
			int f = 1;
			for(int i = N - 1; i > -1; i--) {
				this.a[i] = f;
				f++;
			}
		}
		
		else if(orden == 3) {
			//Caso medio
			this.formula = 44 - 23*N + 13*N*Math.log(N);
			
			Random aleatorio = new Random(System.currentTimeMillis());
			for(int i = 0; i < N; i++) {
				this.a[i] = aleatorio.nextInt(2*N);
			}
		}
	}
	
	public int[] devolverArreglo() {
		return a;
	}
	public void ordenarArreglo(int a[], int primero, int ultimo) {
		int i,j, pivote, aux;
		c = c + 6;
		i=primero;
		j=ultimo;
		pivote = a[(primero+ultimo)/2];
		do {
			
			while(a[i]<pivote) {
				c = c + 3;
				i++;
			}
			c = c + 2;
			while(a[j]>pivote) {
				c = c + 3;
				j--;
			}
			c = c + 2;
			
			c = c + 1;
			if(i<=j) {
				c = c + 9;
				aux = a[i];
				a[i] = a[j];
				a[j] = aux;
				i++;
				j--;
			}
			c = c + 1;
		}while(i<=j);
		c = c + 1;
				
		c = c + 1;
		if(primero<j) {
			c = c + 1;
			ordenarArreglo(a, primero, j);
		}
		c = c + 1;
		if(i<ultimo) {
			c = c + 1;
			ordenarArreglo(a, i, ultimo);
		}
	}
	public void devolverDatos() {		
		System.out.println("");
		System.out.println("Por contador se obtuvo "+this.c+" operaciones elementales.");
		System.out.println("Por formula se obtuvo "+this.formula+" operaciones elementales.");
	}
}

