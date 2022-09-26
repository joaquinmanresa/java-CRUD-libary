package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Application {

	private JFrame frmAplicacionGrafica;
	private JTextField txtResultado;
	private boolean isOperacion;
	private String operacion;
	private boolean primerNumero = true;
	private double resultado = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmAplicacionGrafica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	private Double calcular() {
		
		switch(this.operacion) {
		case "suma" : resultado += Double.parseDouble(txtResultado.getText()); break;
		case "resta" : resultado -= Double.parseDouble(txtResultado.getText()); break;
		case "multiplicacion" : resultado *= Double.parseDouble(txtResultado.getText()); break;
		case "division" : resultado /= Double.parseDouble(txtResultado.getText()); break;
		
		}
		
		return resultado;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmAplicacionGrafica =  new JFrame();
		frmAplicacionGrafica.getContentPane().setBackground(Color.GRAY);
		frmAplicacionGrafica.setTitle("Calculadora");
		frmAplicacionGrafica.setBounds(100, 100, 450, 300);
		frmAplicacionGrafica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAplicacionGrafica.getContentPane().setLayout(null);
		
		JPanel panelNumeros = new JPanel();
		panelNumeros.setBackground(Color.GRAY);
		panelNumeros.setBorder(new TitledBorder(null, "Numeros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNumeros.setBounds(50, 77, 169, 174);
		frmAplicacionGrafica.getContentPane().add(panelNumeros);
		panelNumeros.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton boton1 = new JButton("1");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { // esto verifica: hay una operacion? sea + - * /, no concatena, si no que pone el numero. Ej si pongo '+' esto da TRUE
					txtResultado.setText("1");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 1);
				}
			}
		});
		panelNumeros.add(boton1);
		
		JButton boton2 = new JButton("2");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("2");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 2);
				}
			}
		});
		panelNumeros.add(boton2);
		
		JButton boton3 = new JButton("3");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("3");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 3);
				}
			}
		});
		panelNumeros.add(boton3);
		
		JButton boton4 = new JButton("4");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("4");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 4);
				}
			}
		});
		panelNumeros.add(boton4);
		
		JButton boton5 = new JButton("5");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("5");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 5);
				}
			}
		});
		panelNumeros.add(boton5);
		
		JButton boton6 = new JButton("6");
		boton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("6");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 6);
				}
			}
		});
		panelNumeros.add(boton6);
		
		JButton boton7 = new JButton("7");
		boton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("7");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 7);
				}
			}
		});
		panelNumeros.add(boton7);
		
		JButton boton8 = new JButton("8");
		boton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("8");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 8);
				}
			}
		});
		panelNumeros.add(boton8);
		
		JButton boton9 = new JButton("9");
		boton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("9");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 9);
				}
			}
		});
		panelNumeros.add(boton9);
		
		JButton boton0 = new JButton("0");
		boton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isOperacion) { 
					txtResultado.setText("0");
					isOperacion = false;
				}
				else {
					txtResultado.setText(txtResultado.getText() + 0);
				}
			}
		});
		panelNumeros.add(boton0);
		
		JButton botonComa = new JButton(",");
		botonComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtResultado.getText().contains(".")) {
					txtResultado.setText(txtResultado.getText() + "."); 
				}
			}
		});
		panelNumeros.add(botonComa);
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBounds(50, 26, 365, 40);
		frmAplicacionGrafica.getContentPane().add(panelResultados);
		panelResultados.setLayout(null);
		
		txtResultado = new JTextField(); 
		txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResultado.setEditable(false);
		txtResultado.setBounds(0, 0, 365, 40);
		panelResultados.add(txtResultado);
		txtResultado.setColumns(10);
		
		JPanel panelOperaciones = new JPanel();
		panelOperaciones.setBackground(Color.GRAY);
		panelOperaciones.setBounds(246, 101, 169, 125);
		frmAplicacionGrafica.getContentPane().add(panelOperaciones);
		panelOperaciones.setLayout(new GridLayout(3, 2, 0, 0));
		
		JButton botonSumar = new JButton("+");
		botonSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (isOperacion != true) {
				
					isOperacion = true; // cuando cliqueo la accion, estoy diciendo que hay una operacion. Estoy diciendo que se toco uno de los botones
					
					if (primerNumero) { // Es el primer numero si o no?
						
						resultado = Double.parseDouble(txtResultado.getText());
						
						operacion = "suma";
						
						primerNumero = false;					
					}
					else {
						txtResultado.setText(Double.toString(calcular()));
					}
				}
					operacion = "suma";
				
			}
		});
		panelOperaciones.add(botonSumar); 
		
		JButton botonRestar = new JButton("-");
		botonRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (isOperacion != true) {
				
					isOperacion = true; // cuando cliqueo la accion, estoy diciendo que hay una operacion. Estoy diciendo que se toco uno de los botones
					
					if (primerNumero) { // Es el primer numero si o no?
						
						resultado = Double.parseDouble(txtResultado.getText());
						
						operacion = "resta";
						
						primerNumero = false;					
					}
					else {
						txtResultado.setText(Double.toString(calcular()));
					}
				}
					operacion = "resta";
				
			}
		});
		panelOperaciones.add(botonRestar);
		
		JButton botonMultiplicacion = new JButton("*");
		botonMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (isOperacion != true) {
				
					isOperacion = true; // cuando cliqueo la accion, estoy diciendo que hay una operacion. Estoy diciendo que se toco uno de los botones
					
					if (primerNumero) { // Es el primer numero si o no?
						
						resultado = Double.parseDouble(txtResultado.getText());
						
						operacion = "multiplicacion";
						
						primerNumero = false;					
					}
					else {
						txtResultado.setText(Double.toString(calcular()));
					}
				}
					operacion = "multiplicacion";
				
			}
		});
		panelOperaciones.add(botonMultiplicacion);
		
		JButton botonDivision = new JButton("/");
		botonDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (isOperacion != true) {
				
					isOperacion = true; // cuando cliqueo la accion, estoy diciendo que hay una operacion. Estoy diciendo que se toco uno de los botones
					
					if (primerNumero) { // Es el primer numero si o no?
						
						resultado = Double.parseDouble(txtResultado.getText());
						
						operacion = "division";
						
						primerNumero = false;					
					}
					else {
						txtResultado.setText(Double.toString(calcular()));						
					}
				}
					operacion = "division";				
			}
		});
		panelOperaciones.add(botonDivision);
		
		JButton botonIgual = new JButton("=");
			botonIgual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtResultado.setText(Double.toString(calcular()));
					resultado = 0;
					primerNumero = true;
					isOperacion = true; 
				}
			});
		panelOperaciones.add(botonIgual);
		
		JButton botonLimpiar = new JButton("C");
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado = 0;
				primerNumero = true;
				isOperacion = true;
				txtResultado.setText(Double.toString(resultado));
			}
		});
		panelOperaciones.add(botonLimpiar);
	}
}
