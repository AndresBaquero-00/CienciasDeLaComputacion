import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

public class Binaria {
	
	public static int c = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for(int i=0; i<50; i++) {
			int valor = (int) (Math.random()*100);
			lista.add(i, valor);
		}
		
		Collections.sort(lista);
		
		for(int i=0; i<20; i++) {
			System.out.println(lista.get(i));
		}
				
		XYSeries binaria = new XYSeries("Binaria");
		XYSeries logaritmo = new XYSeries("Logaritmo");
		
		for(int i = 1; i < 100; i++) {
			int pos = (int) (Math.random()*50);
			double lg = (double) Math.log(i)/Math.log(20)*40;
			c = 0;
			buscar(lista, 0, (int) lista.size(), (int) lista.get(pos));
			binaria.add(i, c);
			logaritmo.add(i, lg);
			
		}
		
		//Se agrega cada metodo de clasificacion a la serie dela grafica
		XYSeriesCollection dataset = new XYSeriesCollection();
		
        dataset.addSeries(binaria);
        dataset.addSeries(logaritmo);

        
        //Se crea la interfaz y sus componentes
		JFreeChart xydispChart = ChartFactory.createScatterPlot(
                "Busqueda Binaria",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
		
		//Grafica y agrega al canvas
		XYPlot plot = (XYPlot) xydispChart.getPlot();
        
		//Se establece el color de cada serie
		XYItemRenderer renderer = plot.getRenderer();
		
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
                
        plot.setRenderer(renderer);
		
        //Se agrega al panel toda la interfaz terminada
		ChartPanel panel = new ChartPanel(xydispChart);
		 
        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(panel);
	}
	
	
	public static void buscar(ArrayList<Integer> a, int i, int j, int llave) {
		c = c + 3;
		int mitad = (i+j)/2;
		c = c + 2;
		int temp = (int) a.get(mitad);
		c = c + 2;
		c = c + 1;
		if(temp == llave) {
			c = c + 1;
			System.out.println("Existe el numero "+llave+" y se encuentra en la posicion "+mitad);
			return;
		}
		if (i > j){
			c = c + 1;
			System.out.println("Numero "+llave+" no encontrado");
			return;
		}
		if(temp < llave) {
			c = c + 2;
			buscar(a, mitad+1, j, llave);
		}
		else {
			c = c + 2;
			buscar(a, i, mitad-1, llave);
		}
	}
	
}
