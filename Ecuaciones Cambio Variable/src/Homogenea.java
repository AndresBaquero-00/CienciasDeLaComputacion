
public class Homogenea {
	
	//Arreglo donde se guardan los coeficientes para la ecuacion reemplazada por n-1
    double temp[];
    
	Homogenea(double [] coeficientes, int gradoEcuacion, double divis){
		
		temp = new double[gradoEcuacion + 2];
        
        if(coeficientes[gradoEcuacion] != 0) {
        	temp[0] = 0;
        	temp[gradoEcuacion+1] = coeficientes[gradoEcuacion]*(-1);
        	for(int i=0; i<gradoEcuacion; i++) {				
        		temp[i+1] = divis*coeficientes[i]*(-1);
        	}
			
        	for(int i=0; i<=gradoEcuacion; i++) {				
        		if(i!=gradoEcuacion) {
        			temp[i] = coeficientes[i] + temp[i];
        		}
        	}
			
        	temp[gradoEcuacion+1] = temp[gradoEcuacion+1] + coeficientes[gradoEcuacion];
        }  
	}
	
	public double[] devolverEcuacion() {
		
		double otroTemp[] = new double[temp.length-1];
		for(int i=0; i<temp.length - 1; i++) {
			otroTemp[i] = temp[i];
		}
		return otroTemp;
	}
}
