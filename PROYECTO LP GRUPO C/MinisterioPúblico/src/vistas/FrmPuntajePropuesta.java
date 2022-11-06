package vistas;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class FrmPuntajePropuesta extends JInternalFrame {
	
	private JLabel lblPedido;
	private JComboBox <Object> cboPedido;
	private JLabel lblPropuesta;
	private JComboBox <Object> cboPropuesta;
	private JTextField txtPuntTecnica;
	private JLabel lblPuntTecnica;
	private JDateChooser dcFecha;
	private JLabel lblFecha;
	private JTextField txtPuntEconomica;
	private JLabel lblPuntEconomica;
	private JLabel lblEstado;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JComboBox <Object>cboEstado;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	
	public static void main (String [] args) {
		FrmPuntajePropuesta pro = new FrmPuntajePropuesta ();
		pro.setVisible(true);
	}
	
	public FrmPuntajePropuesta () {
		
		setTitle("Puntos de la evaluaci\u00F3n de propuestas");
		setBounds(100,100,773,435);
		
	
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.lightGray);
		
		lblPedido = new JLabel("ID Pedido");
		lblPedido.setBounds(20, 62, 98, 14);
		getContentPane().add(lblPedido);
		
		cboPedido = new JComboBox <Object>();
		cboPedido.setBounds(20, 81, 98, 22);
		getContentPane().add(cboPedido);
		
		lblPropuesta = new JLabel("ID Propuesta");
		lblPropuesta.setBounds(146, 12, 107, 14);
		getContentPane().add(lblPropuesta);
		
		cboPropuesta = new JComboBox <Object>();
		cboPropuesta.setBounds(146, 32, 107, 22);
		getContentPane().add(cboPropuesta);
		
		txtPuntTecnica = new JTextField();
		txtPuntTecnica.setColumns(10);
		txtPuntTecnica.setBounds(146, 83, 98, 20);
		getContentPane().add(txtPuntTecnica);
		
		lblPuntTecnica = new JLabel("Pun. T\u00E9cnica");
		lblPuntTecnica.setBounds(146, 64, 98, 14);
		getContentPane().add(lblPuntTecnica);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(292, 31, 129, 20);
		getContentPane().add(dcFecha);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(292, 12, 46, 14);
		getContentPane().add(lblFecha);
		
		txtPuntEconomica = new JTextField();
		txtPuntEconomica.setColumns(10);
		txtPuntEconomica.setBounds(254, 83, 98, 20);
		getContentPane().add(txtPuntEconomica);
		
		lblPuntEconomica = new JLabel("Punt. Econ\u00F3mica");
		lblPuntEconomica.setBounds(254, 64, 98, 14);
		getContentPane().add(lblPuntEconomica);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(569, 12, 46, 14);
		getContentPane().add(lblEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 733, 224);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(448, 127, 89, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(555, 127, 89, 23);
		getContentPane().add(btnModificar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID DOCUMENTO");
		modelo.addColumn("ID POSTULACION");
		modelo.addColumn("FECHA");
		modelo.addColumn("PERSONA ENCARGADA");
		modelo.addColumn("DNI");
		modelo.addColumn("PUNT. TECNICA");
		modelo.addColumn("PUNT. ECONOMICA");
		modelo.addColumn("RESULTADO");
		table.setModel(modelo);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Sin evaluar", "Aprobado", "Rechazado", "Apelacion"}));
		cboEstado.setBounds(567, 30, 98, 22);
		getContentPane().add(cboEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(20, 32, 98, 20);
		getContentPane().add(txtCodigo);
		
		lblCodigo = new JLabel("ID evaluacion");
		lblCodigo.setBounds(23, 12, 98, 14);
		getContentPane().add(lblCodigo);
		
	}
}
