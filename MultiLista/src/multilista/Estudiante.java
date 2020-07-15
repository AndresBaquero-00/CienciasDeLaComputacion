/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilista;


public class Estudiante {

    String nombre;
    Estudiante abajo;

    Estudiante(String n) {
        this.nombre = n;
        abajo = null;
    }
}
