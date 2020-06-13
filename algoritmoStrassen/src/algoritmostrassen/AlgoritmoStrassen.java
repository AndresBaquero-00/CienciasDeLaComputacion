package algoritmostrassen;

/**
 *
 * @author leeynyker
 */
public class AlgoritmoStrassen {

    /**
     * @param args the command line arguments
     */
    //Variables necesarias
    private double matrizA[][];
    private double matrizB[][];
    private int fA;
    private int cA;
    private int fB;
    private int cB;
    public int N,Nn;
    private int otro = 0;
    public double temporal=0;//USAR ESTA VARIABLE PARA A ECUACION TEMPORAL
    public int contador=0;//USAR ESTA VARIABLE PARA EL CONTADOR

    public AlgoritmoStrassen(double[][] matrizA, double[][] matrizB, int fA, int cA, int fB, int cB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.fA = fA;
        this.cA = cA;
        this.fB = fB;
        this.cB = cB;
    }
    
    //Obtiene los daatos desde la gui y generas la matrices a oper
    public double[][] generarMAtriz(){
        int nmA,nmB;
        double dosn;
        contador = contador + 1;
        if(this.fA<this.cA){
        	contador = contador + 1;
            nmA=this.cA;
        }else{
        	contador = contador + 1;
            nmA=this.fA;
        }
        contador = contador + 1;
        if(this.fB<this.cB){
        	contador = contador + 1;
            nmB=this.cB;
        }else{
        	contador = contador + 1;
            nmB=this.fB;
        }
        
        contador = contador + 1;
        if(nmA>nmB){
        	contador = contador + 1;
            Nn=nmA;
        }else{
        	contador = contador + 1;
            Nn=nmB;
        }
        
        contador = contador + 2;
        N=Nn;
        dosn=1.5;
        //Analiza si el tamaño de la matriz es de 2^n
        while((dosn%1)!=0){
        	contador = contador + 7;
            dosn=log(N,2);
            if((dosn%1)!=0){
            	contador = contador + 1;
                N++;
            }
        }
        contador = contador + 3;
        
        temporal =  (double) (133.667*Math.pow(N, 2.807)) - 132.667;
        double matrizA1[][] = new double[N][N];
        double matrizB1[][] = new double[N][N];
        
        //Genera las matrices a operar
        contador = contador + 2;
        for(int i =0;i<N;i++){
        	contador = contador + 4;
            for(int j=0;j<N;j++){
            	contador = contador + 4;
                if((i<this.fA) && (j<this.cA)){
                	contador = contador + 5;
                    matrizA1[i][j]=matrizA[i][j];
                }else{
                	contador = contador + 3;
                    matrizA1[i][j]=0;
                }
            }
        }

        contador = contador + 2;
        for(int i =0;i<N;i++){
        	contador = contador + 4;
            for(int j=0;j<N;j++){
            	contador = contador + 4;
                if((i<this.fB) && (j<this.cB)){
                	contador = contador + 5;
                    matrizB1[i][j]=matrizB[i][j];
                }else{
                	contador = contador + 3;
                    matrizB1[i][j]=0;
                }
            }
        }
        
        
        //llama al metodo multiplicar
        contador = contador + 1;
        double MatrizC[][]=multiplicar(matrizA1,matrizB1);
        
        return MatrizC;
    }
    
    //Hace las operaciones necesarias
    public double[][] multiplicar(double[][]A,double[][]B){
    	otro = 0;
    	contador = contador + 2;
        int t = A.length;  
        double[][] Resul = new double [t][t];
        
        contador = contador + 1;
        if(t==1){
        	contador = contador + 8;
            Resul[0][0]=A[0][0]*B[0][0];
        }else{
        	contador = contador + 48;
            double[][] A11 = new double[t/2][t/2];
            double[][] A12 = new double[t/2][t/2];
            double[][] A21 = new double[t/2][t/2];
            double[][] A22 = new double[t/2][t/2];
            double[][] B11 = new double[t/2][t/2];
            double[][] B12 = new double[t/2][t/2];
            double[][] B21 = new double[t/2][t/2];
            double[][] B22 = new double[t/2][t/2];
            
            cpara(A, A11, 0 , 0);
            cpara(A, A12, 0 , t/2);
            cpara(A, A21, t/2, 0);
            cpara(A, A22, t/2, t/2);
            
            
            cpara(B, B11, 0 , 0);
            cpara(B, B12, 0 , t/2);
            cpara(B, B21, t/2, 0);
            cpara(B, B22, t/2, t/2);
            
            contador = contador + 1;
            double [][] M1 = multiplicar(sumar(A11, A22), sumar(B11, B22));
            contador = contador + 1;
            double [][] M2 = multiplicar(sumar(A21, A22), B11);
            contador = contador + 1;
            double [][] M3 = multiplicar(A11, restar(B12, B22));
            contador = contador + 1;
            double [][] M4 = multiplicar(A22, restar(B21, B11));
            contador = contador + 1;
            double [][] M5 = multiplicar(sumar(A11, A12), B22);
            contador = contador + 1;
            double [][] M6 = multiplicar(restar(A21, A11), sumar(B11, B12));
            contador = contador + 1;
            double [][] M7 = multiplicar(restar(A12, A22), sumar(B21, B22));
            
            contador = contador + 1;
            double [][] C11 = sumar(restar(sumar(M1, M4), M5), M7);
            contador = contador + 1;
            double [][] C12 = sumar(M3, M5);
            contador = contador + 1;
            double [][] C21 = sumar(M2, M4);
            contador = contador + 1;
            double [][] C22 = sumar(restar(sumar(M1, M3), M2), M6);
            
            armar(C11, Resul, 0 , 0);
            armar(C12, Resul, 0 , t/2);
            armar(C21, Resul, t/2, 0);
            armar(C22, Resul, t/2, t/2);
            otro = otro + 70;
        }  
        System.out.println(otro);
        return Resul;
    }
    
    //Une las submatrices para volver a forfar la matriz
    public void armar(double[][] C, double[][] P, int iB, int jB) 
    {
    	otro = otro + 3;
    	contador = contador + 3;
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
        	contador = contador + 6;
        	otro = otro + 6;
        	for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
        		otro = otro + 8;
        		contador = contador + 8;
            	P[i2][j2] = C[i1][j1];
            }
        }    
    }  
    
    //Resta las matrices
    public double[][] restar(double[][] A, double[][] B)
    {
    	contador = contador + 4;
    	otro = otro + 4;
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++) {
        	contador = contador + 4;
        	otro = otro + 4;
        	for (int j = 0; j < n; j++) {
        		otro = otro + 10;
        		contador = contador + 10;
            	C[i][j] = A[i][j] - B[i][j];
            }
        }   
        
        return C;
    }
    
    //Suma las matrices
    public double[][] sumar(double[][] A, double[][] B)
    {
    	contador = contador + 4;
    	otro = otro + 4;
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++){
        	otro = otro + 4;
        	contador = contador + 4;
            for (int j = 0; j < n; j++){
            	otro = otro + 10;
            	contador = contador + 10;
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
    
    //Divide la matriz en submatrices
    public void cpara(double[][] P, double[][] C, int iB, int jB) 
    {
    	contador = contador + 3;
    	otro = otro + 3;
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
        	otro = otro + 6;
        	contador = contador + 6;
        	for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
        		otro = otro + 8;
        		contador = contador + 8;
            	C[i1][j1] = P[i2][j2];
            }
        }
                
    }
    
    //Calcula logaritmo
    private static Double log(double num, int base) {
      return (Math.log10(num) / Math.log10(base));
   }
    
    //Funcion principal que abre la gui
    public static void main(String[] args) {
        LauncherUI user = new LauncherUI();
        user.setLocationRelativeTo(null);
        user.setVisible(true);        
    }

}
