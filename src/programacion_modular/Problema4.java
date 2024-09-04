package programacion_modular;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema4 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtMonto;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtAreaResultado;
	
	//declarar variable globales
	int cuotas;
	double montoPrestamo, montoCuota, tasaInteres, montoInteres; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema4 frame = new Problema4();
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
	public Problema4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Monto del pr\u00E9stamo");
		lblNewLabel.setBounds(10, 24, 107, 14);
		contentPane.add(lblNewLabel);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(127, 21, 89, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(239, 20, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(338, 20, 89, 23);
		contentPane.add(btnBorrar);
		
		txtAreaResultado = new JTextArea();
		txtAreaResultado.setBounds(10, 65, 414, 185);
		contentPane.add(txtAreaResultado);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if(e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}
	public void actionPerformedBtnProcesar(ActionEvent e) {
		ingresarDatos();
		obtenerNumeroCuotas();
		obtenerTasaInteres();
		calcularMontoInteresTotal();
		calcularMontoCuota();
		mostrarResultados();
		
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtMonto.setText("");
		txtAreaResultado.setText("");
		txtMonto.requestFocus();
		
	}
	//efectua la entrada de datos
	void ingresarDatos() {
		montoPrestamo = Integer.parseInt(txtMonto.getText());
	}
	//obtiene el numero de cuotas
	void obtenerNumeroCuotas() {
		if(montoPrestamo <= 5000)
			cuotas = 2;
		else if(montoPrestamo <= 10000) 
			cuotas = 4;
		else if(montoPrestamo <= 15000)
			cuotas = 6;
		else
			cuotas = 10;
	}
	//obtener la tasa de interes
	void obtenerTasaInteres() {
		if(montoPrestamo > 10000)
			tasaInteres = 0.03;
		else
			tasaInteres = 0.05;
	}
	//calcular monto interes total
	void calcularMontoInteresTotal() {
		montoInteres = tasaInteres * montoPrestamo * cuotas;
		
	}
	//calcular monto cuota
	void calcularMontoCuota() {
		montoCuota = (montoPrestamo + montoInteres) / cuotas;
	}
	// Muestra los resultados obtenidos
	void mostrarResultados() {
	txtAreaResultado.setText("");
	txtAreaResultado.append("Número de cuotas : " + cuotas +"\n");
	txtAreaResultado.append("Cuota mensual : S/. " + montoCuota +"\n");
	txtAreaResultado.append("Interés total : S/. " + montoInteres);
	
	}
	// Imprime una línea de texto incluyendo un salto de línea al final
	void imprimir(String cad) {
	txtAreaResultado.append(cad + "\n");
	}

	

}
