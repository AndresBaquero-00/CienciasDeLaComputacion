import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

public class Cliente extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton Enviar;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnEliminar;
	private JButton btnDibujar;
	private JButton btnConsultar;
	private ArbolesAVL arbol;
	private Nodo raiz;
	private JTextField textField_2;
	private JLabel lblEliminar;
	private JTextField textField_3;
	private JLabel lblConsultar;
	private JLabel lblResultado;
	private JButton btnListar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente() {
		setTitle("Arboles AVL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Enviar = new JButton("Enviar");
		Enviar.setBackground(Color.WHITE);
		Enviar.setBounds(10, 207, 89, 23);
		Enviar.addActionListener(this);
		panel.add(Enviar);
		
		textField = new JTextField();
		textField.setBounds(10, 100, 339, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblArbolesAvl = new JLabel("Arboles AVL");
		lblArbolesAvl.setHorizontalAlignment(SwingConstants.CENTER);
		lblArbolesAvl.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblArbolesAvl.setBounds(10, 24, 484, 42);
		panel.add(lblArbolesAvl);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 160, 339, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Edad");
		lblNewLabel.setBounds(10, 135, 111, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(10, 77, 89, 14);
		panel.add(lblNewLabel_1);
		
		btnDibujar = new JButton("Dibujar");
		btnDibujar.setBackground(Color.WHITE);
		btnDibujar.setBounds(108, 207, 89, 23);
		btnDibujar.addActionListener(this);
		panel.add(btnDibujar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(207, 207, 89, 23);
		btnEliminar.addActionListener(this);
		panel.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(306, 207, 89, 23);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(359, 160, 135, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(369, 135, 61, 14);
		panel.add(lblEliminar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(359, 100, 135, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(369, 77, 61, 14);
		panel.add(lblConsultar);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(10, 241, 484, 30);
		panel.add(lblResultado);
		
		btnListar = new JButton("Listar");
		btnListar.setBackground(Color.WHITE);
		btnListar.setBounds(405, 207, 89, 23);
		btnListar.addActionListener(this);
		panel.add(btnListar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Enviar) {
			String cadena = textField.getText();
			String edad = textField_1.getText();
			
			String[] cadenas = cadena.split(",");
			String[] edades = edad.split(",");
			
			arbol = new ArbolesAVL(cadenas.length);
			
			for (int i=0; i<cadenas.length; i++) {
				arbol.insAVL(cadenas[i], Integer.parseInt(edades[i]));
			}
			lblResultado.setText("Nombres insertados correctamente.");
		}
		
		if(e.getSource() == btnEliminar) {
			arbol.retirarAVIL(textField_2.getText());
			raiz = arbol.raizArbol();
			lblResultado.setText(textField_2.getText()+" eliminado correctamente.");
			textField_2.setText("");
		}
		
		if(e.getSource() == btnDibujar) {
			Resultado resultado = new Resultado(arbol);
			resultado.setVisible(true);
		}
		
		if(e.getSource() == btnConsultar) {
			int edad = arbol.consultarEdad(textField_3.getText());
			lblResultado.setText("La edad de "+textField_3.getText()+" es: "+edad);
			textField_3.setText("");
		}
		
		if(e.getSource() == btnListar) {
			ListaArbol lista = new ListaArbol(arbol);
		
		}
	}
}
