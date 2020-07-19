/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricesdispersas;

import javax.swing.JOptionPane;

/**
 *
 * @author leeyn
 */
public class Colunna {

    Fila cab;
    int size = 0;

    Colunna() {
        cab = null;
    }

    void ins_final(int x, int y) {
        Fila q = cab;
        boolean flag = false;
        while (q != null && flag == false) {
            flag = (x == q.fila && y == q.valor);
            q = q.abajo;
        }
        if (flag == false) {
            Fila p = new Fila(x, y);
            q = cab;
            Fila s = null;
            while (q != null) {
                s = q;
                q = q.abajo;
            }
            if (s == null) {
                cab = p;
            } else {
                s.abajo = p;
            }
//            existe++;
        } else {
            System.out.println("El cabdiante " + x + " se encuentra flag");
//            JOptionPane.showMessageDialog(null, "El cabdiante " + y + " se encuentra flag");
        }
        size++;
    }

    void escribir_lista() {
        Fila q = cab;
        while (q != null) {
            System.out.print(q.fila + " " + q.valor + "\n");
            q = q.abajo;
        }
        System.out.println();
    }

//    int[] FC() {
//        int[] fc = new int[2];
//        Fila q = cab;
//        while (q != null) {
//            System.out.print(q.fila + " " + q.valor + "\n");
//            fc[0]=q.fila;
//            q = q.abajo;
//        }
//        return fc;
//    }
    void sigui(){
        cab=cab.abajo;
    }
}
