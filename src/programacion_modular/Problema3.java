package programacion_modular;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Problema3 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JComboBox cmbTipo;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtAreaResultado;
	
	//declarar variables globales
	int tipo, cantidad, caramelos;
	double descuento, importeCompra, importePagar;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema3 frame = new Problema3();
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
	public Problema3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10, 36, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Primor", "Dulzura", "Tentaci\u00F3n", "Explosi\u00F3n"}));
		cmbTipo.setBounds(93, 7, 85, 22);
		contentPane.add(cmbTipo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(92, 33, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		txtAreaResultado = new JTextArea();
		txtAreaResultado.setBounds(10, 71, 414, 179);
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
		calcularImporteCompra();
		calcularImporteDescuento();
		calcularImportePagar();
		calcularCaramelos();
		mostrarResultados();
		
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		txtAreaResultado.setText("");
		txtCantidad.requestFocus();
	}
	void ingresarDatos() {
		tipo = cmbTipo.getSelectedIndex();
		cantidad = Integer.parseInt(txtCantidad.getText());
	}
	void calcularImporteCompra() {
		switch(tipo) {
			case 0:
				importeCompra = 8.5 * cantidad;
				break;
			case 1:
				importeCompra = 10.0 * cantidad;
				break;
			case 2:
				importeCompra = 7.0 * cantidad;
				break;
			default:
				importeCompra = 12.5 * cantidad;
				break;
		}
	}
	void calcularImporteDescuento() {
		if(cantidad < 5)
			descuento = 0.04 * importeCompra;
		else if(cantidad < 10)
			descuento = 0.065 * importeCompra;
		else if(cantidad < 15)
			descuento = 0.09 * importeCompra;
		else 
			descuento = 0.115 * importeCompra;
	}
	void calcularImportePagar() {
		importePagar = importeCompra - descuento;
	}
	void calcularCaramelos() {
		if(importePagar > 250)
			caramelos = 3 * cantidad;
		else
			caramelos = 2 * cantidad;
	}
	void mostrarResultados() {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Importe de la compra	: S/. " + importeCompra +"\n");
		txtAreaResultado.append("Importe del descuento	: S/. " + descuento +"\n");
		txtAreaResultado.append("Importe a pagar		: S/. " + importePagar +"\n");
		txtAreaResultado.append("Caramelos de obsequio	: " + caramelos);
	}
	// Imprime una línea de texto incluyendo un salto de línea al final
	void imprimir(String cad) {
	txtAreaResultado.append(cad + "\n");
	}
	
}
