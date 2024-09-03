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

public class Problema2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtMinutosTardanza;
	private JTextField txtNumeroObservaciones;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtAreaResultado;
	
	//declaro variables locales
	int minutosTar, numeroObs,puntajePun, puntajeRen, puntajeTot;
	double bonificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema2 frame = new Problema2();
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
	public Problema2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Minutos de tardanza");
		lblNewLabel.setBounds(10, 11, 117, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("N\u00FAmero de observaciones");
		lblNewLabel_1.setBounds(10, 43, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		txtMinutosTardanza = new JTextField();
		txtMinutosTardanza.setBounds(157, 8, 86, 20);
		contentPane.add(txtMinutosTardanza);
		txtMinutosTardanza.setColumns(10);
		
		txtNumeroObservaciones = new JTextField();
		txtNumeroObservaciones.setBounds(157, 40, 86, 20);
		contentPane.add(txtNumeroObservaciones);
		txtNumeroObservaciones.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 39, 89, 23);
		contentPane.add(btnBorrar);
		
		txtAreaResultado = new JTextArea();
		txtAreaResultado.setBounds(10, 81, 414, 169);
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
		determinarPuntajePuntualidad();
		determinarPuntajeRendimiento();
		determinarPuntajeTotal();
		determinarBonificacion();
		mostrarResultados();
	}
	public void actionPerformedBtnBorrar(ActionEvent e) {
		txtMinutosTardanza.setText("");
		txtNumeroObservaciones.setText("");
		txtAreaResultado.setText("");
		txtMinutosTardanza.requestFocus();
	}
	//ingresa datos
	void ingresarDatos() {
		minutosTar = Integer.parseInt(txtMinutosTardanza.getText());
		numeroObs = Integer.parseInt(txtNumeroObservaciones.getText());
	}
	//determina el puntaje por puntualidad
	void determinarPuntajePuntualidad() {
		if(minutosTar == 0)
			puntajePun = 10;
		else if(minutosTar <= 2) 
			puntajePun = 8;
		else if(minutosTar <= 5) 
			puntajePun = 6;
		else if(minutosTar <= 9) 
			puntajePun = 4;
		else 
			puntajePun = 0;
	}
	//determina el puntaje por rendimiento
	void determinarPuntajeRendimiento() {
		if(numeroObs == 0)
			puntajeRen = 10;
		else if(numeroObs == 1)
			puntajeRen = 8;
		else if(numeroObs == 2)
			puntajeRen = 5;
		else if(numeroObs == 3)
			puntajeRen = 1;
		else
			puntajeRen = 0;
	}
	//determina el puntaje total
	void determinarPuntajeTotal() {
		puntajeTot = puntajePun + puntajeRen;
	}
	//determina el puntaje por rendimiento
	void determinarBonificacion() {
	if(puntajeTot < 11)
		bonificacion = 2.5 * puntajeTot;
	else if(puntajeTot <= 13)
		bonificacion = 5.0 * puntajeTot;
	else if(puntajeTot <= 16)
		bonificacion = 7.5 * puntajeTot;
	else if(puntajeTot <= 19)
		bonificacion = 10.0 * puntajeTot;
	else
		bonificacion = 12.5 * puntajeTot;
	}
	//mostramos los resultados
	void mostrarResultados() {
		txtAreaResultado.setText("");
		txtAreaResultado.append("Puntaje por puntualidad : " + puntajePun +"\n"); 
		txtAreaResultado.append("Puntaje por rendimiento : " + puntajeRen +"\n"); 
		txtAreaResultado.append("Puntaje total           : " + puntajeTot +"\n"); 
		txtAreaResultado.append("Bonificación            : S/. " + bonificacion); 
	}
	

}
