import java.util.ArrayList;

public class Raices {
	
	static ArrayList<Double> raices;
	int iteraciones;
	public void CalcularRaices(double polinom[]) {
		// TODO Auto-generated method stub;
		double Xi = 0, y1 = 0, y2 = 0, Xi1;
		double temp;
		double derivado[], poli[] = polinom;
		
		raices = new ArrayList(poli.length - 1);
		boolean salir = true;
		
		if(poli.length == 3) {
			cuadratica(poli);
		}
		else {
			do{			
				iteraciones = 0;
				derivado = derivar(poli);
				do {
					y1 = polinomio(Xi, poli);
					y2 = polinomio(Xi, derivado);
					
					Xi1 = Xi - (y1/y2);
					temp = Xi1 - Xi;
					
					Xi = Xi1;
					iteraciones = iteraciones + 1;
					
				}while(Math.abs(temp) > 0.0000000001 && iteraciones < 100);
								
				raices.add(Xi);
				
				poli = divisionSintetica(poli, Xi);
								
				System.out.println();
				if(iteraciones == 100) {
					System.out.println("No tiene raices reales");
					salir = false;
				}
				
				if(poli.length == 3) {
					cuadratica(poli);
					salir = false;
				}	
			}while(salir);
		}

	}
	
	public double polinomio(double x, double[] poli) {
		double resul = 0;
		for(int i=0; i<poli.length; i++) {
			resul = resul + poli[i]*Math.pow(x, poli.length-i-1);
		}
		return resul;
	}
	
	public double[] derivar(double[] poli) {
		double temp[] = new double[poli.length-1];
		for(int i=0; i<poli.length-1; i++) {
			temp[i] = poli[i]*(poli.length-i-1);
		}
		return temp;
	}
	
	public double[] divisionSintetica(double[] poli, double x) {
		double [] reducido = new double[poli.length - 1];
		for(int i=0; i<poli.length - 1; i++) {
			if(i==0) {
				reducido[i] = poli[i];
			}
			else {
				reducido[i] = (reducido[i-1]*x) + poli[i];
			}
		}
		return reducido;
	}
	
	public void cuadratica(double[] poli) {
		double X0 = 0, X1 = 0;
		
		if(Math.pow(poli[1], 2) - 4*poli[0]*poli[2] >= 0) {
			X0 = ((-1)*poli[1] + Math.sqrt(Math.pow(poli[1], 2) - 4*poli[0]*poli[2]))/(2*poli[0]);
			X1 = ((-1)*poli[1] - Math.sqrt(Math.pow(poli[1], 2) - 4*poli[0]*poli[2]))/(2*poli[0]);
		}
		
		raices.add(X0);
		raices.add(X1);
	}
	
	public ArrayList getRaices() {
		return raices;
	}
	
	public int getIteraciones() {
		return iteraciones;
	}
}
