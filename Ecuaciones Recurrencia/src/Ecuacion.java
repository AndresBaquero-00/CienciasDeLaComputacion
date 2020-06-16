import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ecuacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ingresar = new Scanner(System.in);
		System.out.print("Digite el grado de la ecuacion: ");
		int gradoEcuacion = Integer.parseInt(ingresar.nextLine());
		ArrayList raiz = new ArrayList();
		
		//Condiciones iniciales
		double valorN[] = new double[gradoEcuacion];
		double valorFN[] = new double[gradoEcuacion];
				
		//Matriz de ecuaciones lineales
		double matriz[][] = new double[gradoEcuacion][gradoEcuacion+1];
		
		//Arreglo donde se guardan los coeficientes para la ecuacion reemplazada por n-1
		double temp[] = new double[gradoEcuacion+2];
				
		//Coeficientes de la ecuacion
		double coeficientes[] = new double[gradoEcuacion+1];
		
		for(int i=0; i<gradoEcuacion; i++) {
			System.out.print("Digite el "+(i+1)+" valor de n: ");
			valorN[i] = Double.parseDouble(ingresar.nextLine());
			System.out.print("Digite el "+(i+1)+" valor de fn: ");
			valorFN[i] = Double.parseDouble(ingresar.nextLine());
		}
		
		for(int i=0; i<=gradoEcuacion; i++) {
			System.out.print("Digite el coeficiente de X^"+(gradoEcuacion - i)+": ");
			coeficientes[i] = Double.parseDouble(ingresar.nextLine());
		}
		
		//Convierte la ecuación a homogenea
		/*
		if(coeficientes[gradoEcuacion] != 0) {
			temp[0] = 0;
			temp[gradoEcuacion+1] = coeficientes[gradoEcuacion]*(-1);
			for(int i=0; i<gradoEcuacion; i++) {				
				temp[i+1] = coeficientes[i]*(-1);
			}
			
			for(int i=0; i<=gradoEcuacion; i++) {				
				if(i!=gradoEcuacion) {
					temp[i] = coeficientes[i] + temp[i];
				}
			}
			
			temp[gradoEcuacion+1] = temp[gradoEcuacion+1] + coeficientes[gradoEcuacion];
		}
		*/
		
		//Asignando los valores de la ecuación homogenea a la ecuacion caracteristica
		/*double otroTemp[] = new double[temp.length - 1];
		
		for(int i=0; i<otroTemp.length; i++) {
			otroTemp[i] = temp[i];
			System.out.println(otroTemp[i]);
		}*/
		
		Raices calcRaiz = new Raices();
		calcRaiz.CalcularRaices(coeficientes);
		
		raiz = calcRaiz.getRaices();
		
		//Fn = C1*soluciones[0]^n + C2*soluciones[1]^n
		for(int i=0; i<gradoEcuacion; i++) {
			for(int j=0; j<=gradoEcuacion; j++) {
				if(j == gradoEcuacion) {
					matriz[i][j] = valorFN[i];
				}
				else {
					matriz[i][j] = Math.pow((double) raiz.get(j), valorN[i]);
				}
			}
		}
		
		int array[] = new int[raiz.size()];
		String resul = "";
		
		for(int j=0; j<raiz.size(); j++) {
			for(int i=j+1; i < raiz.size(); i++) {
				double error = (double) raiz.get(j) - (double) raiz.get(i);
				if(Math.abs(error) < 0.0001) {
					array[j] = array[j] + 1;
					array[i] = array[j];
				}
			}
		}
				
		if(calcRaiz.getIteraciones() == 100) {
			System.out.println("Raices complejas");
		}
		else {
			System.out.print("Fn = ");
			int j=0;
			for(int i=0; i<raiz.size(); i++) {
				if(array[i] == 0) {
					resul =  resul + "C"+(i+1)+"*"+raiz.get(i)+"^n"+" + ";
				}
				else {
					resul = resul + "C"+(i+1)+"*n^"+j+"*"+raiz.get(i)+"^n"+" + ";
					j++;
				}
			}
			
			System.out.println(resul);
		}
		
		for(int i=0; i<gradoEcuacion; i++) {
			for(int j=0; j<=gradoEcuacion; j++) {
				System.out.print(matriz[i][j]+"  ");
			}
			System.out.println();
		}
	}

}
