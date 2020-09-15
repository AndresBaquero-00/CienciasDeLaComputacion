import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ColasPrioridad extends JFrame implements ActionListener{

	private Arbol arbol;
    private int nivel;
    private int cantNodos;
    private int temp;
    private int diametro = 30;
    private int radio = diametro/2;
    private int k=1;
    private int raiz;
    private int[] posicion;
    private int[] otrapos;
    private JButton btnEliminar;
 
    ColasPrioridad(){
        this.arbol = new Arbol();
        this.nivel = 0;
        this.temp = 1;
        this.cantNodos = 1;
        iniciarPosicion();
        
        setBounds(100, 100, 1040, 500);
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
    }
     
    void creaP(int dato){
        int i,j;
        
        arbol.cont++;
        i=arbol.cont;
        j = i/2;
       
        while(arbol.nodos[j] < dato){
        	arbol.nodos[i] = arbol.nodos[j];
            i = j;
            j = i/2;
        }
        
        arbol.nivel[k] = nivel;
        arbol.cantNodos[k] = temp;
        k++;
        
        if(temp == cantNodos) {
        	temp = 1;
        	nivel++;
        	cantNodos = (int) Math.pow(2, nivel);
        }else {
        	temp++;
        }
        
        arbol.nodos[i] = dato;
    }
    
    public void paint(Graphics g) {
    	super.paint(g);
    	temp = 0;
    	int z = 1;
    	for(k = 1; k <= arbol.cont; k++) {
    		if(k != 1) {
    			raiz = posicion[k - otrapos[k]];
    		}else {
    			raiz = posicion[k-1];
    		}
    		pintar(g, posicion[k-1], arbol.nodos[k], arbol.nivel[k], raiz);
    	}
	}
    
    public void pintar(Graphics g, int x, int dato, int nivel, int x1) {
    	g.drawString(""+dato, x, 200+60*nivel);
    	g.drawOval(x-radio/2, 200+60*nivel-radio, diametro, diametro);
    	if(x != x1) {
    		g.drawLine(x1, 200+60*(nivel-1), x, 200+60*(nivel));
    	}
    }
    
    public void iniciarPosicion() {
    	int []arreglo = new int[32];
    	int []otro = new int[32];
    	int temp = 0;
    	int otrotemp = 1;
    	for(int k=0; k<otro.length; k++) {
    		if(temp != 1) {
    			temp++;
    		}else {
    			temp = 0;
    			otrotemp++;
    		}
    		otro[k] = otrotemp;
    	}
    	
    	int raiz = 400;
    	temp = 0;

    	for(int k = 0; k < arreglo.length-1; k++) {
			if(otro[k] == Math.pow(2, temp)+1) {
    			raiz = raiz/2;
    			temp++;
    		}
    		if(k != 0) {
    			arreglo[k] = (int) (arreglo[k - otro[k-1]] + Math.pow(-1, k)*raiz);
    		}else{
    			arreglo[k] = 400;
    		}
    	}
    	
    	this.posicion = arreglo;
    	this.otrapos = otro;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnEliminar) {
			retirarP();
			paint(getGraphics());
		}
	}
    
    
    int retirarP(){
        int i,j,temp,elemento;
        elemento = arbol.nodos[1];
        temp = arbol.nodos[arbol.cont];
        arbol.cont = arbol.cont - 1;
        i = 1;
        j = 2;
        while(j <= arbol.cont){
            if(j < arbol.cont){
                if(arbol.nodos[j] < arbol.nodos[j+1]){
                    j++;
                }
            }
            if(temp >= arbol.nodos[j]){
                break;
            }
            arbol.nodos[i] = arbol.nodos[j];
            i = j;
            j = 2*i;
        }
        arbol.nodos[i] = temp;
        return elemento;
    }
    
    
    //private int []otrapos = {1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16};
    //int []posicion = {400,200,600,100,300,500,700,50,150,250,350,450,550,650,750,25,75,125,175,225,275,325,375,425,475,525,575,625,675,725,775};
    
}