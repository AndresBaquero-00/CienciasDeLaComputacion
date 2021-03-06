/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cambiomonedas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leeyn
 */
public class CambioMonedas {

    /**
     * @param args the command line arguments
     */
    int[] monedas;
    int n;
    int vueltas;

    public CambioMonedas(int[] iValores, int iNumeros, int vueltas) {
        this.monedas = iValores;
        this.n = iNumeros;
        this.vueltas = vueltas;
    }

    public void GenerarMatriz() {
        
        int matriz[][] = new int[n + 1][vueltas + 1];
        String imprimir[][] = new String[n + 1][vueltas + 1];        
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (monedas[i] > monedas[j]) {
                    int temp = monedas[i];
                    monedas[i] = monedas[j];
                    monedas[j] = temp;
                }
            }
        }

        for (int i = 0; i < vueltas + 1; i++) {
            matriz[0][i] = 32797;
            imprimir[0][i] = "inf";
        }

        for (int i = 0; i < n + 1; i++) {
            imprimir[i][0] = "0  0:0";
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < vueltas + 1; j++) {
                if (i == 1 && j < monedas[i]) {
                    matriz[i][j] = 32797;
                    imprimir[i][j] = "inf";
                } else if (i == 1) {
                    matriz[i][j] = 1 + matriz[i][j - monedas[i]];
                    if (matriz[i][j] < 32790) {
                        imprimir[i][j] = " " + matriz[i][j];
                        for (int z = 0; z < matriz[i][j]; z++) {
                            imprimir[i][j] += " ~1:" + monedas[i];
                        }
                    } else {
                        imprimir[i][j] = "inf";
                    }
                } else if (j < monedas[i]) {
                    matriz[i][j] = matriz[i - 1][j];
                    if (matriz[i][j] < 32790) {
                        imprimir[i][j] = imprimir[i - 1][j];
                    } else {
                        imprimir[i][j] = "inf";
                    }
                } else {
                    matriz[i][j] = minimo(matriz[i - 1][j], 1 + matriz[i][j - monedas[i]]);
                    if (matriz[i][j] == 1 + matriz[i][j - monedas[i]]) {

                        imprimir[i][j] = matriz[i][j] + " " + imprimir[i][j - monedas[i]] + " ~1:" + monedas[i];
                    } else {
                        imprimir[i][j] = matriz[i][j] + " " + imprimir[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < vueltas + 1; j++) {
                System.out.print(imprimir[i][j] + "           ");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < vueltas + 1; j++) {
                if(imprimir[n][vueltas].contains("32798")) {
                	imprimir[n][vueltas].replace("32798", "inf");
                }
            }

        }
        boolean bool = imprimir[n][vueltas].contains("inf");
        
        
        JTable tabla = new JTable();
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        for(int i=0; i<vueltas+1; i++) {
        	modelo.addColumn(i+1);
        }
        Object [] fila = new Object[vueltas+1];
        
        for(int i=0; i<n+1; i++) {
        	for(int j=0; j<vueltas+1; j++) {
        		fila[j] = imprimir[i][j];
        	}
        	modelo.addRow(fila);
        }
        
        Resultado res = new Resultado(imprimir,monedas, vueltas,n, bool, tabla);
        res.setLocationRelativeTo(null);
        res.setVisible(true);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabla);
        
        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 1129, 519);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        frame.add(tabla);
        tabla.setBounds (0,0,1000,1500);
        
        //create table with data
        frame.getContentPane().add(tabla);
        frame.setVisible(true);
        
        
 
    }
    
    public static int minimo(int a, int b) {

        int min = a < b ? a : b;
        return min;
    }

    public static void main(String[] args) {
        MonedasUI user = new MonedasUI();
        user.setLocationRelativeTo(null);
        user.setVisible(true);
    }

}
