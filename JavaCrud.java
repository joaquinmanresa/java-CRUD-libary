import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JavaCrud {

	private JFrame frmLibreriaVirtualbookmania;
	private JTextField txtnombrelibro;
	private JTextField txtedicion;
	private JTextField txtprecio;
	private JTable table;
	private JTextField txtbuscador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
					window.frmLibreriaVirtualbookmania.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaCrud() {		
		initialize();
		Connect();
		table_load();
	}
	
	Connection conexion;
	PreparedStatement pst;
	ResultSet rs;
	
	public void Connect() {
		
		String url = "";
		String usuario = "";
		String password = "";
		
		try {
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(url, usuario, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// JOptionPane.showMessageDialog(null,"Error: " + e.getMessage() + " no existe dentro del proyecto.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos: " + e.getMessage());
			e.printStackTrace();
		} 
	}
	
	public void table_load() {
		
		try {
			pst = conexion.prepareStatement("select * from libro");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibreriaVirtualbookmania = new JFrame();
		frmLibreriaVirtualbookmania.setTitle("Libreria virtual 'BookMania'");
		frmLibreriaVirtualbookmania.setBounds(100, 100, 843, 495);
		frmLibreriaVirtualbookmania.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibreriaVirtualbookmania.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BookMania");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblNewLabel.setBounds(295, 9, 250, 54);
		frmLibreriaVirtualbookmania.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 200, 0), new Color(160, 160, 160)), "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 200, 0)));
		panel.setBounds(33, 74, 375, 234);
		frmLibreriaVirtualbookmania.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del libro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(24, 54, 113, 19);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edición");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(24, 84, 113, 19);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(24, 114, 113, 19);
		panel.add(lblNewLabel_1_1_1);
		
		txtnombrelibro = new JTextField();
		txtnombrelibro.setBounds(157, 55, 200, 20);
		panel.add(txtnombrelibro);
		txtnombrelibro.setColumns(10);
		
		txtedicion = new JTextField();
		txtedicion.setColumns(10);
		txtedicion.setBounds(157, 85, 200, 20);
		panel.add(txtedicion);
		
		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		txtprecio.setBounds(157, 115, 99, 20);
		panel.add(txtprecio);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(24, 165, 96, 35);
		panel.add(btnNewButton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(141, 165, 96, 35);
		panel.add(btnLimpiar);
		
		JButton btnNewButton_1_1 = new JButton("Salir");
		btnNewButton_1_1.setBounds(258, 165, 96, 35);
		panel.add(btnNewButton_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombrelib,edicion,precio;
				
				nombrelib = txtnombrelibro.getText();
				edicion = txtedicion.getText();
				precio = txtprecio.getText();
				
				try {
					String query = "insert into libro (nombre,edicion,precio) values (?,?,?)";
					PreparedStatement pst = conexion.prepareStatement(query);
					// conexion.prepareStatement("insert into libro (nombre,edicion,precio) values (?,?,?)"); 
					pst.setString(1, nombrelib);
					pst.setString(2, edicion);
					pst.setString(3, precio);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registro agregado con exito!");
					table_load();
					txtnombrelibro.setText("");
					txtedicion.setText("");
					txtprecio.setText("");
					// txtnombrelibro.requestFocus();				
					
				} 
					catch (SQLException e1) {
					
						e1.printStackTrace();
				}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 76, 375, 275);
		frmLibreriaVirtualbookmania.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(108, 350, 235, 60);
		frmLibreriaVirtualbookmania.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("ID Libro");
		lblNewLabel_1_1_2.setBounds(10, 18, 74, 26);
		lblNewLabel_1_1_2.setFont(new Font("Open Sans", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1_2);
		
		txtbuscador = new JTextField();
		txtbuscador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
								
				try {
					
					String id = txtbuscador.getText();
					
					
					pst = conexion.prepareStatement("select nombre, edicion, precio from libro where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()==true) {
						
						String nombre = rs.getString(1);
						String edicion = rs.getString(2);
						String precio = rs.getString(3);
						
						txtnombrelibro.setText(nombre);
						txtedicion.setText(edicion);
						txtprecio.setText(precio);
					} 
					
					else {
						txtnombrelibro.setText("");
						txtedicion.setText("");
						txtprecio.setText("");
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		txtbuscador.setBounds(86, 18, 139, 28);
		txtbuscador.setColumns(10);
		panel_1.add(txtbuscador);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nombrelib,edicion,precio,lid;
				
				nombrelib = txtnombrelibro.getText();
				edicion = txtedicion.getText();
				precio = txtprecio.getText();
				lid = txtbuscador.getText();
				
				try {
					String query = "update libro set nombre = ?, edicion = ?, precio = ? where id = ?";
					PreparedStatement pst = conexion.prepareStatement(query);
					// conexion.prepareStatement("insert into libro (nombre,edicion,precio) values (?,?,?)"); 
					pst.setString(1, nombrelib);
					pst.setString(2, edicion);
					pst.setString(3, precio);
					pst.setString(4, lid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registro actualizado con exito!");
					table_load();
					
					txtnombrelibro.setText("");
					txtedicion.setText("");
					txtprecio.setText("");
					// txtnombrelibro.requestFocus();				
					
				} 
					catch (SQLException e1) {
					
						e1.printStackTrace();
				}
				
			}
		});
		btnActualizar.setBounds(505, 381, 96, 35);
		frmLibreriaVirtualbookmania.getContentPane().add(btnActualizar);
		
		JButton btnNewButton_1_1_1 = new JButton("Borrar");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lid;
				lid = txtbuscador.getText();
				
				try {
					String query = "delete from book where id = ?";
					PreparedStatement pst = conexion.prepareStatement(query);
					// conexion.prepareStatement("insert into libro (nombre,edicion,precio) values (?,?,?)"); 
				
					pst.setString(1, lid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registro borrado con exito!");
					table_load();
					
					txtnombrelibro.setText("");
					txtedicion.setText("");
					txtprecio.setText("");
					// txtnombrelibro.requestFocus();				
					
				} 
					catch (SQLException e1) {
					
						e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1.setBounds(663, 381, 96, 35);
		frmLibreriaVirtualbookmania.getContentPane().add(btnNewButton_1_1_1);
	}
}
