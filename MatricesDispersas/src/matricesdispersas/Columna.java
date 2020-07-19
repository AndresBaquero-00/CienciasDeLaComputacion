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
public class Columna {

    int col, existe;
    Columna sig;
    Fila cab;

    public Columna(int col) {
        this.col = col;
        this.sig = null;
    }

    void insFila(int fil, int valor) {
        Fila q = cab;
        boolean flag = false;
        while (q != null && flag == false) {
            flag = (fil == q.fila);
            q = q.abajo;
        }
        if (flag == false) {
            Fila p = new Fila(fil, valor);
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
            existe++;
        } else {
//            System.out.println("El cabdiante " + fil + " se encuentra flag");
//            JOptionPane.showMessageDialog(null, "El cabdiante " + fil + " se encuentra flag");
            int fllop = JOptionPane.showConfirmDialog(null, "Desea editar valor de la casilla?");
            if (fllop == 0) {
                eliminar(fil);
                insFila(fil, valor);
            }
            // 0=yes, 1=no, 2=cancel
        }
    }

    void eliminar(int n) {
        Fila q = cab;
        Fila k = null;
        while (q != null && (n != q.fila)) {
            k = q;
            q = q.abajo;
        }

        if (q != cab) {
            k.abajo = q.abajo;
        } else {
            cab = q.abajo;
        }

//        System.out.println("El estudiante " + q.nombre + " ha cancelado la materia " + nombre);
//        JOptionPane.showMessageDialog(null, "El estudiante " + q.nombre + " ha cancelado la materia " + nombre);
    }

    String listarColumna() {
        String ss = "";
        Fila p = cab;
        while (p != null) {
            if (p.valor != 0) {
                System.out.print(p.fila + ":" + p.valor + " ");
                ss += p.fila + ":" + p.valor + " ";
            }else{
                eliminar(p.fila);
            }
            p = p.abajo;
        }
        ss += "+ ";
        System.out.println();
        return ss;
    }

    void ordenar_lista() {
        Fila p, q;
        int temp;
        for (q = cab; q != null; q = q.abajo) {
            for (p = q; p != null; p = p.abajo) {
//                int comp = q.fil.compareTo(p.nombre);
                if (q.fila > p.fila) {
                    temp = q.fila;
                    q.fila = p.fila;
                    p.fila = temp;
                }
            }
        }
    }

    int traer(int y) {
        Fila q = cab;

        int reg = 0;
        if (q != null) {
            while (q != null) {
                if (y == q.fila) {
                    reg = q.valor;
                }
                q = q.abajo;
            }
        }
        return reg;
    }
}
