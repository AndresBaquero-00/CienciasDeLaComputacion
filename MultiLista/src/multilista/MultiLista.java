/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilista;

import javax.swing.JOptionPane;

/**
 *
 * @author leeyn
 */
public class MultiLista {

    /**
     * @param args the command line arguments
     */
    String nombre;
    Materia cab;
    int size_mat = 0;

    MultiLista(String n) {
        this.nombre = n;
    }

    void ingresarMateria(String n) {
        Materia q = cab;
        boolean inscrito = false;
        while (q != null && inscrito == false) {
            inscrito = n.equals(q.nombre);
            q = q.sig;
        }
        if (inscrito == true) {
            System.out.println("La materia " + n + " se encuentra registrada");
            JOptionPane.showMessageDialog(null, "La materia " + n + " se encuentra registrada");
        } else {
            Materia p = new Materia(n);
            q = cab;
            Materia s = null;
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

    void ingresarEstudiante(String m, String n) {
        Materia q = cab;
        int i = 0;
        while (q != null && m.equals(q.nombre) == false && i <= size_mat) {
            q = q.sig;
            i++;
        }

        if (i == size_mat) {
            System.out.println("No está registrada la materia " + m);
            JOptionPane.showMessageDialog(null, "No está registrada la materia " + m);
        } else {
            q.inscribirEstudiante(n);
        }
    }

    void eliminarMateria(String n) {
        Materia q = cab;
        Materia k = null;
        while (q != null && n.equals(q.nombre) == false) {
            k = q;
            q = q.sig;
        }

        if (q != cab) {
            k.sig = q.sig;
        } else {
            cab = q.sig;
        }

        System.out.println("La materia " + n + " ha sido eliminada");
        JOptionPane.showMessageDialog(null, "La materia " + n + " ha sido eliminada");
    }

    void eliminarEstudiante(String m, String n) {
        Materia q = cab;
        while (q != null && m.equals(q.nombre) == false) {
            q = q.sig;
        }
        q.eliminar_estudiante(n);
    }

    String[] escribir_lista() {
        String ss="";
        String[] lista;
        Materia q = cab;
        ordenar_lista();
        while (q != null) {
            System.out.println(q.nombre + " ");
            ss+=q.nombre + " - ";
            System.out.println("- ");
            q.ordenar_lista();
            ss+=q.listarEstudiante();
            System.out.println();
            q = q.sig;
        }
        System.out.println();
        lista = ss.split(" ");
        return lista;
    }

    void ordenar_lista() {
        Materia p, q;
        String temp;
        Estudiante temp1;
        for (q = cab; q != null; q = q.sig) {
            for (p = q; p != null; p = p.sig) {
                int comp = q.nombre.compareTo(p.nombre);
                if (comp > 0) {
                    temp1 = q.estu;
                    temp = q.nombre;

                    q.estu = p.estu;
                    q.nombre = p.nombre;

                    p.estu = temp1;
                    p.nombre = temp;
                }
            }
        }
    }

}
