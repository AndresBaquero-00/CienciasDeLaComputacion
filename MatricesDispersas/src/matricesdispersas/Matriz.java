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
public class Matriz {

//    int  col;
    String kk;
    Columna cab;
    int size_mat = 0;

    Matriz(String km) {
        this.kk = km;
    }

    void ingColumna(int n) {
        Columna q = cab;
        boolean exis = false;
        while (q != null && exis == false) {
            exis = (n == q.col);
            q = q.sig;
        }
        if (exis == true) {
//            System.out.println("La materia " + n + " se encuentra registrada");
//            JOptionPane.showMessageDialog(null, "La materia " + n + " se encuentra registrada");
        } else {
            Columna p = new Columna(n);
            q = cab;
            Columna s = null;
            while (q != null) {
                s = q;
                q = q.sig;
            }
            if (s == null) {
                cab = p;
            } else {
                s.sig = p;
            }
            size_mat++;
        }
    }

    void ingFila(int m, int n, int v) {
        Columna q = cab;
        int i = 0;
        while (q != null && (m == q.col) == false && i <= size_mat) {
            q = q.sig;
            i++;
        }

        if (i == size_mat) {
            System.out.println("No está registrada la materia " + m);
            JOptionPane.showMessageDialog(null, "No está registrada la materia " + m);
        } else {
            q.insFila(n, v);
        }
    }

    String[] escribir_lista() {
        String ss = "";
        String[] lista;
        Columna q = cab;
        ordenar_lista();
        while (q != null) {
//            System.out.println(q.cab.abajo);
//            if (q.cab.abajo != null) {
//                System.out.println(q.col + " ");
            ss += q.col + " - ";
//                System.out.println("- ");
            q.ordenar_lista();
            ss += q.listarColumna();
            System.out.println();
//            }
            q = q.sig;
        }
        System.out.println();
        lista = ss.split(" ");
        return lista;
    }

    void ordenar_lista() {
        Columna p, q;
        int temp;
        Fila temp1;
        for (q = cab; q != null; q = q.sig) {
            for (p = q; p != null; p = p.sig) {
//                int comp = q.col.compareTo(p.col);
                if (q.col > p.col) {
                    temp1 = q.cab;
                    temp = q.col;

                    q.cab = p.cab;
                    q.col = p.col;

                    p.cab = temp1;
                    p.col = temp;
                }
            }
        }
    }

    int traer(int x, int y) {
        Columna q = cab;

        int reg = 0;
        if (q != null) {
            while (q != null) {
//                    System.out.println(q.cab.fila);
                if (x == q.col) {
                    reg = q.traer(y);
//                        System.out.println(reg);
                }
                q = q.sig;
            }
        }

        return reg;
    }
}
