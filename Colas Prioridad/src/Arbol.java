public class Arbol{
    final int MAX = 100;
    int cont;
    int []nodos;
    int []nivel;
    int []cantNodos;
    

    Arbol(){
        cont = 0;
        nodos = new int[MAX];
        nivel = new int[MAX];
        cantNodos = new int[MAX];

        nodos[0] = Integer.MAX_VALUE;
    }
}

