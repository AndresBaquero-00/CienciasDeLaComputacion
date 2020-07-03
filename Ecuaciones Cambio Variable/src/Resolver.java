/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author leeyn
 */
public class Resolver {
    
    double matriz[][];

    public Resolver(double[][] Matriz) {
        this.matriz = Matriz;
    }
    
    public double[][] calcular(){
        for (int i = 0; i < matriz.length; i++) {
            double pivote = matriz[i][i]; 
            
            
      
            for (int j = i; j < matriz[i].length; j++) {
                matriz[i][j] /= pivote;
            }
            
            for (int j = 0; j < matriz.length; j++) {
                
                if (i != j) {
                    double cero = matriz[j][i] * -1;
                    for (int k = i; k < matriz[j].length; k++) {
                        matriz[j][k] = matriz[j][k] + (cero * matriz[i][k]);
                    }
                }
            }
            
        } 
        return matriz;
    }

}
