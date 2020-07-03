/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuacionesrecurrencia;

/**
 *
 * @author leeyn
 */
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ecuacion {

    int gradoEcuacion;
    double valorN[];
    double valorFN[];
    double coeficientes[];
    double matriz[][];
    Resolver rs;

    public Ecuacion(int gradoEcuacion, double[] valorN, double[] valorFN, double[] coeficientes) {
        this.gradoEcuacion = gradoEcuacion;
        this.valorN = valorN;
        this.valorFN = valorFN;
        this.coeficientes = coeficientes;
    }

    public void Ecuacio() {

        // TODO Auto-generated method stub
//        Scanner ingresar = new Scanner(System.in);
//        System.out.print("Digite el grado de la ecuacion: ");
//        int gradoEcuacion = Integer.parseInt(ingresar.nextLine());
        ArrayList raiz = new ArrayList();

        //Condiciones iniciales
//        double valorN[] = new double[gradoEcuacion];
//        double valorFN[] = new double[gradoEcuacion];

        //Matriz de ecuaciones lineales
        double matriz[][] = new double[gradoEcuacion][gradoEcuacion + 1];

        //Arreglo donde se guardan los coeficientes para la ecuacion reemplazada por n-1
        double temp[] = new double[gradoEcuacion + 2];

        //Coeficientes de la ecuacion
//        double coeficientes[] = new double[gradoEcuacion + 1];

//        for (int i = 0; i < gradoEcuacion; i++) {
//            System.out.print("Digite el " + (i + 1) + " valor de n: ");
//            valorN[i] = Double.parseDouble(ingresar.nextLine());
//            System.out.print("Digite el " + (i + 1) + " valor de fn: ");
//            valorFN[i] = Double.parseDouble(ingresar.nextLine());
//        }

//        for (int i = 0; i <= gradoEcuacion; i++) {
//            System.out.print("Digite el coeficiente de X^" + (gradoEcuacion - i) + ": ");
//            coeficientes[i] = Double.parseDouble(ingresar.nextLine());
//        }

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

        int array[] = new int[raiz.size()];
        String resul = "";

        for (int j = 0; j < raiz.size(); j++) {
            for (int i = j + 1; i < raiz.size(); i++) {
                double error = (double) raiz.get(j) - (double) raiz.get(i);
                if (Math.abs(error) < 0.0001) {
                    array[j] = array[j] + 1;
                    array[i] = array[j] + 1;
                }
            }
        }
        
        for(int i=0; i<raiz.size(); i++) {
        	System.out.println(array[i]);
        }
        //Fn = C1*soluciones[0]^n + C2*soluciones[1]^n
        for (int i = 0; i < gradoEcuacion; i++) {
            for (int j = 0; j <= gradoEcuacion; j++) {
                if (j == gradoEcuacion) {
                    matriz[i][j] = valorFN[i];
                } else {
                    if (array[j] == 0) {
                        matriz[i][j] = Math.pow((double) raiz.get(j), valorN[i]);
                    } else{
                        matriz[i][j] = Math.pow(valorN[i], array[j]-1) * Math.pow((double) raiz.get(j), valorN[i]);
                    }
                }
            }
        }

        if (calcRaiz.getIteraciones() == 100) {
            System.out.println("Raices complejas");
        } else {
            System.out.print("Fn = ");
<<<<<<< HEAD
=======
            int j = 0;
>>>>>>> 9041d9ca5fb8eec0a156fbd61706d6a72857ba2c
            for (int i = 0; i < raiz.size(); i++) {
                if (array[i] == 0) {
                    resul = resul + "C" + (i + 1) + "*" + raiz.get(i) + "^n" + " + ";
                } else {
<<<<<<< HEAD
                    resul = resul + "C" + (i + 1) + "*n^" + (array[i]-1) + "*" + raiz.get(i) + "^n" + " + ";
=======
                    resul = resul + "C" + (i + 1) + "*n^" + j + "*" + raiz.get(i) + "^n" + " + ";
                    j++;
>>>>>>> 9041d9ca5fb8eec0a156fbd61706d6a72857ba2c
                }
            }

            System.out.println(resul);
        }

        for (int i = 0; i < gradoEcuacion; i++) {
            for (int j = 0; j <= gradoEcuacion; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
        
        rs = new Resolver(matriz);
        double despeje[][] = rs.calcular();

        for (int i = 0; i < despeje.length; i++) {
            System.out.println("");
            for (int j = 0; j < despeje[0].length; j++) {
                System.out.print(despeje[i][j] + "\t");
            }
        }
        System.out.println("");
//        System.out.print("Fn = ");
        String s = "Fn = ";
        DecimalFormat ff = new DecimalFormat("#.###");
        for (int i = 0; i < raiz.size(); i++) {
            s += "" + ff.format(despeje[i][despeje.length])  + " (" + ff.format(raiz.get(i)) + ")^n" + " + ";
        }
        System.out.println(s);
        JOptionPane.showMessageDialog(null, s);
<<<<<<< HEAD
=======

>>>>>>> 9041d9ca5fb8eec0a156fbd61706d6a72857ba2c
    }

}
