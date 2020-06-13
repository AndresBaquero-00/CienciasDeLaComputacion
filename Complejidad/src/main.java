import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Digite la cantidad N de números a analizar: ");
		String n = br.readLine();
		
		burbuja bur = new burbuja(n);
		seleccion selec = new seleccion(n);
		insercion inser = new insercion(n);
		radix rax = new radix(n);
		RadixSort radixS = new RadixSort(n);
		quick qck = new quick(n);
		merge merg = new merge(n);
		
		System.out.print("Digite 1 para el mejor caso, 2 para el peor caso, 3 para el caso medio: ");
		String caso = br.readLine();
		
		System.out.println("Para el metodo de la burbuja se obtuvo: ");
		bur.llenarArreglo(Integer.parseInt(caso));
		bur.ordenarArreglo();
		bur.devolverDatos();
		
		System.out.println("");
		System.out.println("Para el metodo de selección se obtuvo: ");
		selec.llenarArreglo(Integer.parseInt(caso));
		selec.ordenarArreglo();
		selec.devolverDatos();
		
		System.out.println("");
		System.out.println("Para el metodo de insercion se obtuvo: ");
		inser.llenarArreglo(Integer.parseInt(caso));
		inser.ordenarArreglo();
		inser.devolverDatos();
		
		//System.out.println("");
		//System.out.println("Para el metodo radix se obtuvo: ");
		rax.llenarArreglo(Integer.parseInt(caso));
		rax.ordenarArreglo();
		
		
		System.out.println("");
		System.out.println("Para el metodo radix se obtuvo: ");
		radixS.llenarArreglo(Integer.parseInt(caso));
		radixS.clasificar();
		rax.devolverDatos();
		
		System.out.println("");
		System.out.println("Para el metodo quick se obtuvo: ");
		qck.llenarArreglo(Integer.parseInt(caso));
		int a[] = qck.devolverArreglo();
		qck.ordenarArreglo(a, 0, Integer.parseInt(n)-1);
		qck.devolverDatos();
		
		System.out.println("");
		System.out.println("Para el metodo merge se obtuvo: ");
		merg.llenarArreglo(Integer.parseInt(caso));
		int b[] = merg.devolverArreglo();
		merg.dividir(b, 0, Integer.parseInt(n)-1);
		merg.devolverDatos();
		
		graficar();
	}
	
	public static void graficar() {
		XYSeries burbuja = new XYSeries("Burbuja");
		XYSeries seleccion = new XYSeries("Seleccion");
		XYSeries insercion = new XYSeries("Insercion");
		XYSeries radix = new XYSeries("Radix");
		XYSeries quick = new XYSeries("Quick");
		XYSeries merge = new XYSeries("Merge");
		
		
		for(int i = 0; i < 500; i++) {
			//Peores casos de cada método de clasificacion
			burbuja.add(i, 6*i*i - 3);
			seleccion.add(i, 3/2*i*i + 7.5*i + 3);
			insercion.add(i, 8*((i/2)*(i + 1) - i) + 12*(i - 1) + 4);
			radix.add(i, 400*i + 251);
			quick.add(i, 44 - 23*i + 13*i*Math.log(i));
			merge.add(i, 70 - 68*i + 39*i*Math.log(i));
		}
		
		//Se agrega cada metodo de clasificacion a la serie dela grafica
		XYSeriesCollection dataset = new XYSeriesCollection();
		
        dataset.addSeries(burbuja);
        dataset.addSeries(seleccion);
        dataset.addSeries(insercion);
        dataset.addSeries(radix);
        dataset.addSeries(quick);
        dataset.addSeries(merge);
        
        //Se crea la interfaz y sus componentes
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Metodos de Ordenacion (Peor Caso)",
                "Tamaño Arreglo",
                "# Operaciones Elementales",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
		
		//Grafica y agrega al canvas
		XYPlot plot = xylineChart.getXYPlot();
        
		//Se establece el color de cada serie
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
        
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesStroke(2, new BasicStroke(1.0f));
        
        renderer.setSeriesPaint(3, Color.CYAN);
        renderer.setSeriesStroke(3, new BasicStroke(1.0f));
        
        renderer.setSeriesPaint(4, Color.MAGENTA);
        renderer.setSeriesStroke(4, new BasicStroke(1.0f));
        
        renderer.setSeriesPaint(5, Color.YELLOW);
        renderer.setSeriesStroke(5, new BasicStroke(1.0f));
        plot.setRenderer(renderer);
		
        //Se agrega al panel toda la interfaz terminada
		ChartPanel panel = new ChartPanel(xylineChart);
		 
        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(panel);
	}

}
