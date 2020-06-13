import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class merge {
	
	private int N;
	private int a[];
	private int c=0;
	private double formula;
	
	public merge(String n) throws IOException {
		this.N = Integer.parseInt(n); 
		this.a = new int[N];

	}
	
	public void llenarArreglo(int orden) {
		if(orden == 1) {
			//Mejor caso
			this.formula = 70 - 68*N + 39*N*Math.log(N);
			for(int i = 0; i < N; i++) {
				this.a[i] = i;
			}
		}
		
		else if(orden == 2) {
			//Peor caso
			this.formula = 70 - 68*N + 39*N*Math.log(N);
			
			int f = 1;
			for(int i = N-1; i > -1; i--) {
				this.a[i] = f;
				f++;
			}
		}
		
		else if(orden == 3) {
			//Caso medio
			this.formula = 70 - 68*N + 39*N*Math.log(N);
			
			Random aleatorio = new Random(System.currentTimeMillis());
			for(int i = 0; i < N; i++) {
				this.a[i] = aleatorio.nextInt(2*N);
			}
		}
	}
	public void dividir(int arr[], int izqu, int der){
		c = c + 1;
	    if(izqu < der){
	    	//Encuentra el punto medio del vector.
	    	c = c + 3;
	    	int mitad = (izqu + der) / 2;
	      
	    	//Divide la primera y segunda mitad (llamada recursiva).
	    	c = c + 1;
	    	dividir(arr, izqu, mitad);
	    	c = c + 1;
	    	dividir(arr, mitad+1, der);

	    	//Une las mitades.
	    	c = c + 1;
	    	mezclar(arr, izqu, mitad, der);
	    }
	}
	
	public void mezclar(int arr[], int izqu, int mitad, int der) {
		//Encuentra el tamaño de los sub-vectores para unirlos.
		c = c + 5;
		int n1 = mitad - izqu + 1;
		int n2 = der - mitad;

		//Vectores temporales.
		c = c + 2;
		int izquierdo[] = new int [n1];
		int derecho[] = new int [n2];

		//Copia los datos a los arrays temporales.
		c = c + 1;
		for (int i=0; i < n1; i++) {
			c = c + 6;
			izquierdo[i] = arr[izqu+i];
		}
		c = c + 2;
		for (int j=0; j < n2; j++) {
			c = c + 7;
			derecho[j] = arr[mitad + j + 1];
		}
		/* Une los vectorestemporales. */

		//Índices inicial del primer y segundo sub-vector.
		c = c + 2;
		int i = 0, j = 0;

		//Índice inicial del sub-vector arr[].
		c = c + 1;
		int k = izqu;

		//Ordenamiento.
		while (i < n1 && j < n2) {
			c = c + 2;
			c = c + 3;
			if (izquierdo[i] <= derecho[j]) {
				c = c + 4;
				arr[k] = izquierdo[i];
				i++;
		    } else {
		    	c = c + 4;
		        arr[k] = derecho[j];
		        j++;
		    }
			c = c + 1;
		    k++;
		}
		c = c + 2;
		
		/* Si quedan elementos por ordenar */
		//Copiar los elementos restantes de leftArray[].
		while (i < n1) {
			c = c + 5;
			arr[k] = izquierdo[i];
		    i++;
		    k++;
		}
		c = c + 1;
		//Copiar los elementos restantes de rightArray[].
		c = c + 1;
		while (j < n2) {
			c = c + 5;
		    arr[k] = derecho[j];
		    j++;
		    k++;
		}
	}
	
	public int[] devolverArreglo() {
		return a;
	}
	
	public void devolverDatos() {	
		System.out.println("");
		System.out.println("Por contador se obtuvo "+this.c+" operaciones elementales.");
		System.out.println("Por formula se obtuvo "+this.formula+" operaciones elementales.");
	}
}

