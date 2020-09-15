import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ListaArbol extends JFrame {

	private JPanel contentPane;
	private Nodo[] nodos;
	private ArbolesAVL arbol;
	private int k=0;

	/**
	 * Create the frame.
	 */
	public ListaArbol(ArbolesAVL arbol) {
		this.arbol = arbol;
		
		nodos = new Nodo[arbol.cantNodos];
		inorden(arbol.raizArbol());
		ordenar(arbol.raizArbol());
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		String[] columns = new String[] {
				"Nombre", "Edad"
		};
		
		//actual data for the table in a 2d array
		Object[][] data = new Object[arbol.cantNodos][3];
		    
		for(int i = 0; i < nodos.length; i++){
	    	Nodo nodo = nodos[i];
	    	data[i][0] = nodo.info;
	    	data[i][1] = nodo.edad;
	    }
		
		//create table with data
		JTable table = new JTable(data, columns);
		         
		//add the table to the frame
		getContentPane().add(new JScrollPane(table));
		         
		this.setTitle("Listado");      
		this.pack();
		this.setVisible(true);
		
	}
	
	void inorden(Nodo p) {
		if(p != null) {
			inorden(p.izq);
			nodos[k] = p;
			k++;
			inorden(p.der);
		}
	}
	
	void ordenar(Nodo p) {
		for(int i=0; i<arbol.cantNodos; i++) {
			for(int j=i+1; j<arbol.cantNodos; j++) {
				if(nodos[i].edad > nodos[j].edad) {					
					Nodo temp = nodos[i];
					nodos[i] = nodos[j];
					nodos[j] = temp;
				}
			}
		}
	}

}
