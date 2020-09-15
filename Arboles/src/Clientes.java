import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Clientes extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEnviar;
	private JTextField textField_1;
	private JLabel lblRetirarNumero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setTitle("Arboles Binarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblArbolesBinarios = new JLabel("Arboles Binarios");
		lblArbolesBinarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblArbolesBinarios.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblArbolesBinarios.setBounds(10, 11, 594, 37);
		panel.add(lblArbolesBinarios);
		
		textField = new JTextField();
		textField.setBounds(10, 117, 594, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumeros = new JLabel("Numeros:");
		lblNumeros.setBounds(10, 85, 80, 14);
		panel.add(lblNumeros);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(254, 218, 111, 23);
		btnEnviar.addActionListener(this);
		panel.add(btnEnviar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnEnviar) {
			String texto = textField.getText();

			String numeros[] = texto.split(",");
    		int []arr = new int[numeros.length];
    		
    		for(int i=0; i<numeros.length; i++) {
    			arr[i] = Integer.parseInt(numeros[i]);
    		}
    		
			//{148,53,28,265,211,197,270,376,199,308,215,394,308,355,2,231,348,239,67,298}
        	Resultado frame = new Resultado(arr);
            frame.setVisible(true);
		}
	}
}
