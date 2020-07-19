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
public class Fila {

    int fila, valor;
    Fila abajo;

    public Fila(int fila, int valor) {
        this.fila = fila;
        this.valor = valor;
        this.abajo = null;
    }

}
