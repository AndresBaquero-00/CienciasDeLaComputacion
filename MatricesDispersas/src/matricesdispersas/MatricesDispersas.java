/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricesdispersas;

/**
 *
 * @author leeyn
 */
public class MatricesDispersas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Launcher user = new Launcher();
        user.setLocationRelativeTo(null);
        user.setVisible(true);
        
//        Colunna k = new Colunna();
//        Matriz mm = new Matriz("hi");
//        mm.ingColumna(1);
//        mm.ingFila(1, 1, 5);
//        mm.ingFila(1, 1, 6);
//        k.ins_final(1, 1);
//        mm.ingFila(1, 2, 3);
//        k.ins_final(1, 2);
//
//        mm.ingColumna(4);
//        mm.ingFila(4, 1, 5);
//        k.ins_final(4, 1);
//
//        mm.ingColumna(3);
//        mm.ingFila(3, 567, 787);
//        k.ins_final(3, 567);
////        mm.ingColumna(5);
////        mm.ingColumna(5);
////        k.ins_final(5, 3);
//        mm.escribir_lista();
//
//        System.out.println("----------------------------");
//
//        Matriz m = new Matriz("B");
//
//        m.ingColumna(1);
//        m.ingFila(1, 1, 5);
//        m.ingFila(1, 2, 3);
//        k.ins_final(1, 2);
//
//        m.ingColumna(2);
//        m.ingFila(2, 1, 5);
//        k.ins_final(2, 1);
//
//        m.ingColumna(3);
//        m.ingFila(3, 567, 7);
//        k.ins_final(3, 567);
//
//        m.ingColumna(5);
//        k.ins_final(5, 3);
//
//        m.escribir_lista();
//        System.out.println("-----aca------");
//        k.escribir_lista();
//
//        System.out.println("-.-.-.-.-.-.-.-");
//
////        
////        int f = mm.traer(9, 567);
////        System.out.println(f);
//        Sumar(mm, m, k);
    }

    public static void Sumar(Matriz A, Matriz B, Colunna x) {
        Matriz C = new Matriz("C");
        int a, b, c;
        System.out.println(x.size + " size");
        for (int i = 0; i < x.size - 1; i++) {
            if (x.cab != null) {

                a = A.traer(x.cab.fila, x.cab.valor);
                b = B.traer(x.cab.fila, x.cab.valor);
                c = a+b;
                if(c != 0){                    
                    C.ingColumna(x.cab.fila);
                    C.ingFila(x.cab.fila, x.cab.valor, c);
                }

                System.out.println("(" + x.cab.fila + " , " + x.cab.valor + ")");
                System.out.println(a + "<--");
                System.out.println(b + "-->");
                x.sigui();
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        C.escribir_lista();
    }

}
