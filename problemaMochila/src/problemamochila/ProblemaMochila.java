/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemamochila;

import static java.lang.Integer.max;

/**
 *
 * @author leeyn
 */
public class ProblemaMochila {

    /**
     * @param args the command line arguments
     */
    int[] Pesos;
    int[] valores;
    int articulos;
    int pesoMax;

    public ProblemaMochila(int[] Pesos, int[] valores, int articulos, int pesoMax) {
        this.Pesos = Pesos;
        this.valores = valores;
        this.articulos = articulos;
        this.pesoMax = pesoMax;
    }

    public void GenerarMAtriz() {
        int cP = this.articulos + 1;
        int cA = this.pesoMax + 1;
        int[][] mal = new int[cP][cA];
        String [][] mtx  = new String[cP][cA];
        int [] co=new int[cP-1];
        
        for(int o = 0; o <cP-1;o++){
            co[o]=o+1;
            System.out.println(co[o]);
        }
        
        for (int i = 0; i<cP;i++){
            
            for (int j =0; j<cA;j++){
                mtx[i][j]="0:0";
            }
        }

        for (int i = 1; i < cP; i++) {
            for (int j = 1; j < cA; j++) {
                if (j - Pesos[i - 1] >= 0) {
                    mal[i][j] = max(mal[i - 1][j], mal[i - 1][j - Pesos[i - 1]] + valores[i - 1]);
                    if (mal[i][j]==mal[i - 1][j]){
                        mtx[i][j]=mtx[i-1][j];
                    }else{
                        String cad = mtx[i - 1][j - Pesos[i - 1]];
                        cad=cad+"+"+valores[i - 1]+":"+co[i - 1];
                        mtx[i][j]=cad;
                    }
                } else {
                    mal[i][j] = mal[i - 1][j];
                    mtx[i][j] = mtx[i-1][j];
                }
            }
        }

        for (int i = 0; i < cP; i++) {
            System.out.println("");
            for (int j = 0; j < cA; j++) {
                System.out.print("\t" + mal[i][j]);
            }
        }
        System.out.println("");
        Resultado res = new Resultado(mal,mtx,articulos,pesoMax,co,Pesos,valores);
        res.setLocationRelativeTo(null);
        res.setVisible(true);
        
    }

    public static void main(String[] args) {
        LauncherMochila user = new LauncherMochila();
        user.setLocationRelativeTo(null);
        user.setVisible(true);
    }

}
