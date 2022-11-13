package vistas;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import mantenimiento.*;
import utils.Tool;
import clases.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class FrmComite extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIdMiembro;
	private JLabel lblNroPedido;
	private JLabel lblIdMiembro;
	private JLabel lblNomMiembro;
	private JLabel lblApellido;
	private JLabel lblFuncion;
	private JLabel lblDni;
	private JTable tbContratacion;
	private JScrollPane scrollPane;
	private JButton btnGuardar;
	private JButton btnModificar;
	private DefaultTableModel model;
	private JComboBox <Object>cboEstado;
	
	private TipoPedidoDAO tipPedDao;
	private ObjetoPedidoDAO objPedDao;
	private PedidoDAO pedDao;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JComboBox cboIdPedido;
	private JTextField txtDni;
	private JTextField txtFuncion;
	private JLabel lblDependencia;
	private JTextField txtDependencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmComite frame = new FrmComite();
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
	public FrmComite() {
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
		
		txtIdMiembro = new JTextField();
		txtIdMiembro.setBounds(144, 42, 102, 20);
		contentPane.add(txtIdMiembro);
		txtIdMiembro.setColumns(10);
		
		lblNroPedido = new JLabel("ID Pedido:");
		lblNroPedido.setBounds(10, 14, 124, 14);
		contentPane.add(lblNroPedido);
		
		lblIdMiembro = new JLabel("ID Miembro del Comite:");
		lblIdMiembro.setBounds(10, 45, 124, 14);
		contentPane.add(lblIdMiembro);
		
		lblNomMiembro = new JLabel("Nombre:");
		lblNomMiembro.setBounds(10, 76, 147, 14);
		contentPane.add(lblNomMiembro);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 111, 147, 14);
		contentPane.add(lblApellido);
		
		lblFuncion = new JLabel("Funcion/Cargo:");
		lblFuncion.setBounds(319, 42, 90, 20);
		contentPane.add(lblFuncion);
		
		lblDni = new JLabel("Dni: ");
		lblDni.setBounds(319, 14, 75, 14);
		contentPane.add(lblDni);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 727, 198);
		contentPane.add(scrollPane);
		
		tbContratacion = new JTable();
		scrollPane.setViewportView(tbContratacion);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(478, 107, 117, 23);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(611, 107, 108, 23);
		contentPane.add(btnModificar);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ENTIDAD");
		model.addColumn("TIPO");
		model.addColumn("OBJETO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
	
		tbContratacion.setModel(model);
		
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"ESTADO...", "REGISTRADO", "EN PROCESO ", "DESIERTO", "CONCLUIDO"}));
		cboEstado.setBounds(610, 11, 127, 20);
		contentPane.add(cboEstado);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(144, 73, 147, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(144, 108, 147, 20);
		contentPane.add(txtApellido);
		
		cboIdPedido = new JComboBox();
		cboIdPedido.setBounds(144, 10, 102, 22);
		contentPane.add(cboIdPedido);
		
		txtDni = new JTextField();
		txtDni.setBounds(415, 11, 117, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtFuncion = new JTextField();
		txtFuncion.setBounds(415, 42, 117, 20);
		contentPane.add(txtFuncion);
		txtFuncion.setColumns(10);
		
		lblDependencia = new JLabel("Dependencia:");
		lblDependencia.setBounds(319, 76, 90, 20);
		contentPane.add(lblDependencia);
		
		txtDependencia = new JTextField();
		txtDependencia.setColumns(10);
		txtDependencia.setBounds(415, 73, 117, 20);
		contentPane.add(txtDependencia);
		
		tipPedDao = new TipoPedidoDAO();
		objPedDao = new ObjetoPedidoDAO();
		pedDao = new PedidoDAO();
		
		arranque();
	
		
	}

	private void arranque() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformed(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformed(e);
		}
	}


	
	
	


}
