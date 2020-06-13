import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class graficar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graficar frame = new graficar();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public graficar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		XYSeries burbuja = new XYSeries("Burbuja");
		XYSeries seleccion = new XYSeries("Seleccion");
		XYSeries insercion = new XYSeries("insercion");
		
		
		for(int i = 0; i < 500; i++) {
			//Peores casos de cada método de clasificacion
			burbuja.add(i, 6*i*i - 3);
			seleccion.add(i, 3/2*i*i + 7.5*i + 3);
		}
		
		//Se agrega cada metodo de clasificacion a la serie dela grafica
		XYSeriesCollection dataset = new XYSeriesCollection();
		
        dataset.addSeries(burbuja);
        dataset.addSeries(seleccion);
        
        //Se crea la interfaz y sus componentes
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Metodos de Ordenacion",
                "Total de Numeros",
                "Operaciones Elementales",
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
