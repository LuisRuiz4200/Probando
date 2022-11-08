package vistas;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class FrmPedido extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNroPedido;
	private JTextField txtEntidad;
	private JLabel lblNroPedido;
	private JLabel lblEntidad;
	private JLabel lblTipo;
	private JLabel lblObjeto;
	private JComboBox<Object> cboTipo;
	private JEditorPane txtDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JTable tbContratacion;
	private JScrollPane scrollPane;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JDateChooser dcFecha; 
	private DefaultTableModel model;
	private JComboBox <Object>cboEstado;
	private JComboBox cboObjeto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPedido frame = new FrmPedido();
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
	public FrmPedido() {
		setTitle("Pedido");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		
		txtNroPedido = new JTextField();
		txtNroPedido.setEditable(false);
		txtNroPedido.setBounds(167, 11, 117, 20);
		contentPane.add(txtNroPedido);
		txtNroPedido.setColumns(10);
		
		txtEntidad = new JTextField();
		txtEntidad.setBounds(167, 42, 117, 20);
		contentPane.add(txtEntidad);
		txtEntidad.setColumns(10);
		
		lblNroPedido = new JLabel("Pedido Nro:");
		lblNroPedido.setBounds(10, 14, 147, 14);
		contentPane.add(lblNroPedido);
		
		lblEntidad = new JLabel("Entidad Solicitante:");
		lblEntidad.setBounds(10, 44, 147, 14);
		contentPane.add(lblEntidad);
		
		lblTipo = new JLabel("Tipo de Contratacion:");
		lblTipo.setBounds(10, 76, 147, 14);
		contentPane.add(lblTipo);
		
		lblObjeto = new JLabel("Objeto de Contratacion:");
		lblObjeto.setBounds(10, 111, 147, 14);
		contentPane.add(lblObjeto);
		
		cboTipo = new JComboBox<Object>();
		cboTipo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "Bien ", "Servicio", "Obra"}));
		cboTipo.setBounds(167, 72, 117, 22);
		contentPane.add(cboTipo);
		
		txtDescripcion = new JEditorPane();
		txtDescripcion.setBounds(318, 64, 279, 49);
		contentPane.add(txtDescripcion);
		
		lblDescripcion = new JLabel("Descripcion de \r\nRequrimiento:");
		lblDescripcion.setBounds(318, 42, 254, 20);
		contentPane.add(lblDescripcion);
		
		lblFecha = new JLabel("Fecha Inicio: ");
		lblFecha.setBounds(318, 14, 75, 14);
		contentPane.add(lblFecha);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 727, 198);
		contentPane.add(scrollPane);
		
		tbContratacion = new JTable();
		scrollPane.setViewportView(tbContratacion);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(480, 120, 117, 23);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(610, 120, 108, 23);
		contentPane.add(btnModificar);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(403, 11, 108, 20);
		contentPane.add(dcFecha);
		
		model = new DefaultTableModel();
		//Agregar Columnas a las tablas
		model.addColumn("Orden");
		model.addColumn("Entidad");
		model.addColumn("Distrito");
		model.addColumn("Etapa");
		model.addColumn("Objeto de Contratacion");
		model.addColumn("Descripcion");
		model.addColumn("Fecha de Registro");
	
		tbContratacion.setModel(model);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setBounds(601, 11, 102, 20);
		contentPane.add(cboEstado);
		
		cboObjeto = new JComboBox();
		cboObjeto.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Bien", "Servicio", "Obra "}));
		cboObjeto.setBounds(167, 107, 117, 22);
		contentPane.add(cboObjeto);
	}
}
