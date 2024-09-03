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

public class Problema1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtPromedio;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JComboBox cmbCategoria;
	private JTextArea txtAreaResultado;
	
	//declaracion de variables globales
	int categoria;
	double actualpen, nuevapen, descuento, promedio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema1 frame = new Problema1();
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
	public Problema1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(20, 23, 76, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Promedio");
		lblNewLabel_1.setBounds(20, 48, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		cmbCategoria.setBounds(85, 19, 87, 22);
		contentPane.add(cmbCategoria);
		
		txtPromedio = new JTextField();
		txtPromedio.setBounds(85, 45, 87, 20);
		contentPane.add(txtPromedio);
		txtPromedio.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 11, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 39, 89, 23);
		contentPane.add(btnBorrar);
		
		txtAreaResultado = new JTextArea();
		txtAreaResultado.setBounds(10, 73, 414, 177);
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
		calcularPensionActual();
		calcularDescuento();
		calcularNuevaPension();
		mostrarResultados();
		
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtPromedio.setText("");
		txtAreaResultado.setText("");
		txtPromedio.requestFocus();
	}
	//ingresa datos
	void ingresarDatos() {
		categoria = cmbCategoria.getSelectedIndex();
		promedio = Double.parseDouble(txtPromedio.getText());
	}
	//calcula la pension actual
	
	void calcularPensionActual() {
		if(categoria == 0) {
			actualpen = 550;
		}else if (categoria == 1) {
			actualpen = 500;
		}else if (categoria == 2) {
			actualpen = 460;
		}else {
			actualpen = 400;
		}
	}
	//calcula el descuento
	
	void calcularDescuento() {
		if(promedio <= 13.99) 
			descuento = 0;
		else if (promedio <= 15.99)
			descuento = 0.10 * actualpen;
		else if (promedio <= 17.99) 
			descuento = 0.12 * actualpen;
		else
			descuento = 0.15 * actualpen;
	}
	
	//calcula la nueva pension
	void calcularNuevaPension() {
		nuevapen = actualpen - descuento;
	}
	
	//Muestra resultados
	void mostrarResultados() {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Pensión actual : S/. " + actualpen +"\n");
		txtAreaResultado.append("Descuento : S/. " + descuento +"\n");
		txtAreaResultado.append("Nueva pensión : S/. " + nuevapen);
	}
	
	//Imprime una línea de texto incluyendo un salto de línea al final
	void imprimir(String cad) {
		txtAreaResultado.append(cad + "\n");
		}

}
