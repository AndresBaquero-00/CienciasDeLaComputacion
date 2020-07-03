import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JButton;

public class HomeUI extends JFrame implements ChangeListener, ActionListener{

	private JPanel contentPane;
	private JTextField A;
	private JTextField B;
	private JTextField F2;
	private JRadioButton primerCaso;
	private JRadioButton segundoCaso;
	private JRadioButton tercerCaso;
	private JButton btnEnviar;
	private int caso;
	private JLabel label;
	private JTextArea areaTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI frame = new HomeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		primerCaso = new JRadioButton("Fn = A + B * F(n/2)");
		primerCaso.setBounds(26, 61, 195, 23);
		primerCaso.addChangeListener(this);
		contentPane.add(primerCaso);
		
		segundoCaso = new JRadioButton("Fn = n^A + B * F(n/2)");
		segundoCaso.setBounds(26, 87, 195, 23);
		segundoCaso.addChangeListener(this);
		contentPane.add(segundoCaso);
		
		tercerCaso = new JRadioButton("Fn = A + n * B + 2 * F(n/2)");
		tercerCaso.setBounds(26, 113, 195, 23);
		tercerCaso.addChangeListener(this);
		//contentPane.add(tercerCaso);
		
		JLabel lblEcuacionesConCambio = new JLabel("Ecuaciones con cambio de variable");
		lblEcuacionesConCambio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEcuacionesConCambio.setBounds(108, 11, 281, 14);
		contentPane.add(lblEcuacionesConCambio);
		
		A = new JTextField();
		A.setBounds(108, 157, 86, 20);
		contentPane.add(A);
		A.setColumns(10);
		
		B = new JTextField();
		B.setBounds(108, 188, 86, 20);
		contentPane.add(B);
		B.setColumns(10);
		
		F2 = new JTextField();
		F2.setBounds(198, 219, 86, 20);
		//contentPane.add(F2);
		F2.setColumns(10);
		
		JLabel lblA = new JLabel("A = ");
		lblA.setBounds(40, 160, 46, 14);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B = ");
		lblB.setBounds(40, 191, 46, 14);
		contentPane.add(lblB);
		
		areaTexto = new JTextArea(25,80);
		areaTexto.setBounds(227, 30, 250, 280);
		contentPane.add(areaTexto, BorderLayout.CENTER);
		
		JLabel lblF = new JLabel("Solo para tercer caso. F2 = ");
		lblF.setBounds(10, 222, 164, 14);
		//contentPane.add(lblF);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(370, 320, 89, 23);
		btnEnviar.addActionListener(this);
		contentPane.add(btnEnviar);
		
		label = new JLabel("");
		label.setBounds(85, 320, 389, 14);
		contentPane.add(label);
		
		JLabel lblSolucion = new JLabel("Solucion:");
		lblSolucion.setBounds(10, 320, 76, 14);
		contentPane.add(lblSolucion);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnEnviar) {
			DecimalFormat df = new DecimalFormat("#0.000");
			String texto = " ";
			if(caso == 1) {
				double A = Double.parseDouble(this.A.getText());
				double B = Double.parseDouble(this.B.getText());
				
				String procedimiento = "Fn = "+A+" + "+B+"*F(n/2) \n";
				procedimiento += "Se reemplaza n = 2^i \n";
				procedimiento += "F(2^i) = "+A+" + "+B+"*F(2^i-1) \n";
				double Fn[] = new double[2];
				double n[] = new double[2];
				double matriz[][] = new double[2][3];
				Fn[0] = 1; n[0] = 1; Fn[1] = A + B; n[1] = 2;
				
				procedimiento += "La ecuacion homogenea es: \n";
				procedimiento += "F(i) - "+B+"F(i-1) = "+A+" \n";
				double coeficientes[] = {1, (-1)*B, A};
				Homogenea homo = new Homogenea(coeficientes, coeficientes.length-1, 1);
				
				coeficientes = homo.devolverEcuacion();
				
				
				Raices raices = new Raices();
				raices.CalcularRaices(coeficientes);
				ArrayList raiz = raices.getRaices();
				
				procedimiento += "Las raices son: "+raiz.get(0)+" , "+raiz.get(1)+" \n";
				procedimiento += "Fn = C1*"+raiz.get(0)+"^log(n) + C1*"+raiz.get(1)+"^log(n) \n";
				
				procedimiento += "F1 = "+Fn[0]+"   F2 = "+Fn[1]+" \n";
				for(int k=0; k<2; k++) {
					for(int j=0; j<3; j++) {
						if(j == 2) {
							matriz[k][j] = Fn[k];
						}
						else {
							double i = Math.log(n[k]) / Math.log(2);
							matriz[k][j] = Math.pow((double) raiz.get(j), i);
						}
					}
				}
				
				procedimiento += "La matriz de Gauss es: \n";
				for(int k=0; k<2; k++) {
					for(int j=0; j<3; j++) {
						procedimiento += matriz[k][j] + "   ";
					}
					procedimiento += " \n";
				}
				Resolver resol = new Resolver(matriz);
				double [][]solucion = resol.calcular();
				
				double C1 = solucion[0][2];
				double C2 = solucion[1][2];
				
				procedimiento += "La solucion para C1 y C2 es: "+C1+" , "+C2+" \n";
				
				
				texto = "Fn = "+df.format(C1)+" * n^("+df.format(Math.log((double) raiz.get(0)) / Math.log(2))+") + "+df.format(C2)+" * n^log("+df.format(Math.log((double) raiz.get(1)) / Math.log(2))+")";
				areaTexto.insert(procedimiento, 0);
				System.out.println(procedimiento);
			}
			if(caso == 2) {
				double A = Double.parseDouble(this.A.getText());
				double B = Double.parseDouble(this.B.getText());
				
				String procedimiento = "Fn = n^"+A+" + "+B+"*F(n/2) \n";
				procedimiento += "Se reemplaza n = 2^i \n";
				procedimiento += "F(2^i) = 2^"+A+"i + "+B+"*F(2^i-1) \n";
				procedimiento += "F(i) - "+B+"*F(i-1) = 2^"+A+"i \n";
				procedimiento += "Cambiando n por n-1 y multiplicando por -1 \n";
				procedimiento += "F(i-1) - "+B+"*F(i-2) = (2^"+A+"i)/"+Math.pow(2, A)+" \n";
				procedimiento += "Restando las ecuaciones tenemos \n";
				procedimiento += "F(i) - "+(Math.pow(2, A)+B)+"*F(i-1) - "+(B*Math.pow(2, A))+"F(i-2) = 0 \n";
				double Fn[] = new double[2];
				double n[] = new double[2];
				double matriz[][] = new double[2][3];
				Fn[0] = 1; n[0] = 1; Fn[1] = Math.pow(2, A) + B; n[1] = 2;
				
				procedimiento += "La ecuacion homogenea es: \n";
				procedimiento += "F(i) - "+B+"F(i-1) = "+A+" \n";
				
				double coeficientes[] = {1, (-1)*B, Math.pow(2, A)};
				Homogenea homo = new Homogenea(coeficientes, coeficientes.length-1, Math.pow(2, A));
				
				coeficientes = homo.devolverEcuacion();
				
				Raices raices = new Raices();
				raices.CalcularRaices(coeficientes);
				ArrayList raiz = raices.getRaices();
				
				procedimiento += "Las raices son: "+raiz.get(0)+" , "+raiz.get(1)+" \n";
				procedimiento += "Fn = C1*"+raiz.get(0)+"^log(n) + C1*"+raiz.get(1)+"^log(n) \n";
				
				for(int k=0; k<2; k++) {
					for(int j=0; j<3; j++) {
						if(j == 2) {
							matriz[k][j] = Fn[k];
						}
						else {
							double i = Math.log(n[k]) / Math.log(2);
							matriz[k][j] = Math.pow((double) raiz.get(j), i);
						}
					}
				}
				
				procedimiento += "La matriz de Gauss es: \n";
				for(int k=0; k<2; k++) {
					for(int j=0; j<3; j++) {
						procedimiento += matriz[k][j] + "   ";
					}
					procedimiento += " \n";
				}
								
				Resolver resol = new Resolver(matriz);
				double [][]solucion = resol.calcular();
				
				double C1 = solucion[0][2];
				double C2 = solucion[1][2];
				
				procedimiento += "La solucion para C1 y C2 es: "+C1+" , "+C2+" \n";
				areaTexto.insert(procedimiento, 0);
				texto = "Fn = "+df.format(C1)+" * n^("+df.format(Math.log((double) raiz.get(0)) / Math.log(2))+") + "+df.format(C2)+" * n^"+df.format(Math.log((double) raiz.get(1)) / Math.log(2))+"";
			}
			if(caso == 3) {
				double A = Double.parseDouble(this.A.getText());
				double B = Double.parseDouble(this.B.getText());
				double F2 = Double.parseDouble(this.F2.getText());
				
				double Fn[] = new double[3];
				double n[] = new double[3];
				double matriz[][] = new double[3][4];
				Fn[0] = F2; n[0] = 2; n[1] = 4; Fn[1] = A+n[1]*B+2*Fn[0]; n[2] = 8; Fn[2] = A+n[2]*B+2*Fn[1];
				
				double coeficientes[] = {1, -4, 4, 2*A};
				Homogenea homo = new Homogenea(coeficientes, coeficientes.length-1, 1);
				
				coeficientes = homo.devolverEcuacion();
				
				Raices raices = new Raices();
				raices.CalcularRaices(coeficientes);
				ArrayList raiz = raices.getRaices();
				
				double multiplicidad[] = new double[3];
				
				for(int i=0; i< raiz.size(); i++) {	
					for(int j=i+1; j<raiz.size(); j++) {
						double error = (double) raiz.get(j) - (double) raiz.get(i);
						if(Math.abs(error) < 0.0001) {
							multiplicidad[j]++;
						}
					}
				}
				
				
				for(int k=0; k<3; k++) {
					for(int j=0; j<4; j++) {
						if(j == 3) {
							matriz[k][j] = Fn[k];
						}
						else {
							double i = Math.log(n[k]) / Math.log(2);
							matriz[k][j] = Math.pow((Math.log(n[k]) / Math.log(2)), multiplicidad[j])*Math.pow((double) raiz.get(j), i);
						}
					}
				}
				
				Resolver resol = new Resolver(matriz);
				double [][]solucion = resol.calcular();
				
				double C1 = solucion[0][3];
				double C2 = solucion[1][3];
				double C3 = solucion[2][3];
				
				texto = "Fn = "+df.format(C1)+" * n^log("+df.format(raiz.get(0))+") + "+df.format(C2)+" * n^log("+df.format(raiz.get(1))+")"+" + "+df.format(C3)+" * log(n) * n^log("+df.format(raiz.get(2))+")";
			}
			label.setText(texto);
	    }
	}
	 
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		if (primerCaso.isSelected()) {
			caso = 1;
        }
        if (segundoCaso.isSelected()) {
            caso = 2;
        }
        if (tercerCaso.isSelected()) {
            caso = 3;
        }
	}
}
