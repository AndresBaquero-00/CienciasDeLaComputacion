import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEnviar;
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
	
	/*
	public class Cliente {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ColasPrioridad cola = new ColasPrioridad();
			
			cola.creaP(4);
			cola.creaP(8);
			cola.creaP(7);
			cola.creaP(1);
			cola.creaP(5);
			cola.creaP(43);
			cola.creaP(21);
			cola.creaP(3);
			cola.creaP(2);
			cola.creaP(9);
			
			cola.setVisible(true);
			 
	
		}
	
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public Cliente() {
		setTitle("Colas de Prioridad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(164, 190, 89, 23);
		btnEnviar.addActionListener(this);
		panel.add(btnEnviar);
		
		textField = new JTextField();
		textField.setBounds(10, 145, 404, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblColasDePrioridad = new JLabel("Colas de Prioridad");
		lblColasDePrioridad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblColasDePrioridad.setHorizontalAlignment(SwingConstants.CENTER);
		lblColasDePrioridad.setBounds(27, 63, 339, 44);
		panel.add(lblColasDePrioridad);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnEnviar) {
			String cadena = textField.getText();
			String[] otracad = cadena.split(",");
			ColasPrioridad cola = new ColasPrioridad();
			for(int i=0; i<otracad.length; i++) {
				cola.creaP(Integer.parseInt(otracad[i]));
			}
			
			
			cola.setVisible(true);
		}
	}
}
