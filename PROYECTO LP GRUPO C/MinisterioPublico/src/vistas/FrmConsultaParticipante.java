package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import clases.*;

import mantenimiento.*;
import utils.Tool;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaParticipante extends JInternalFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JButton btnBuscar;
	private DefaultTableModel model; 
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private PropuestaDAO propDao;
	private ApelacionDAO apelDao;
	private JLabel lblIdParticipante;
	private JTextArea txtParticipante;
	private JComboBox<Object> cboParticipante;
	private JTextArea txtPedido;
	private JTextArea txtPropuesta;
	private JTextArea txtApelacion;
	private JLabel lblPedido;
	private JLabel lblParticipante;
	private JLabel lblPropuesta;
	private JLabel lblApelacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaParticipante frame = new FrmConsultaParticipante();
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
	public FrmConsultaParticipante() {
		setTitle("Consulta de Participantes");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(186, 26, 86, 24);
		contentPane.add(btnBuscar);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("ENTIDAD");
		model.addColumn("RUC");
		model.addColumn("CORREO");
		model.addColumn("TELEFONO");
		model.addColumn("ESTADO");
		
		lblIdParticipante = new JLabel("ID Participante :");
		lblIdParticipante.setBounds(20, 11, 101, 14);
		contentPane.add(lblIdParticipante);
		
		cboParticipante = new JComboBox<Object>();
		cboParticipante.setBounds(20, 28, 138, 22);
		contentPane.add(cboParticipante);
		
		txtPedido = new JTextArea();
		txtPedido.setBorder(new EmptyBorder(10, 10, 10, 10));
		txtPedido.setEditable(false);
		txtPedido.setLineWrap(true);
		txtPedido.setBounds(368, 91, 328, 134);
		contentPane.add(txtPedido);
		
		txtPropuesta = new JTextArea();
		txtPropuesta.setBorder(new EmptyBorder(10, 10, 10, 10));
		txtPropuesta.setEditable(false);
		txtPropuesta.setLineWrap(true);
		txtPropuesta.setBounds(10, 258, 330, 134);
		contentPane.add(txtPropuesta);
		
		txtApelacion = new JTextArea();
		txtApelacion.setBorder(new EmptyBorder(10, 10, 10, 10));
		txtApelacion.setEditable(false);
		txtApelacion.setLineWrap(true);
		txtApelacion.setBounds(368, 258, 330, 134);
		contentPane.add(txtApelacion);
		
		txtParticipante = new JTextArea();
		txtParticipante.setBorder(new EmptyBorder(10, 10, 10, 10));
		txtParticipante.setEditable(false);
		txtParticipante.setLineWrap(true);
		txtParticipante.setBounds(10, 91, 330, 134);
		contentPane.add(txtParticipante);
		
		lblPedido = new JLabel("INFORMACION DEL PEDIDO :");
		lblPedido.setBounds(368, 66, 233, 14);
		contentPane.add(lblPedido);
		
		lblParticipante = new JLabel("INFORMACION DEL PARTICIPANTE :");
		lblParticipante.setBounds(12, 66, 233, 14);
		contentPane.add(lblParticipante);
		
		lblPropuesta = new JLabel("INFORMACION DE LA PROPUESTA :");
		lblPropuesta.setBounds(10, 233, 233, 14);
		contentPane.add(lblPropuesta);
		
		lblApelacion = new JLabel("INFORMACION DE LA APELACION :");
		lblApelacion.setBounds(368, 233, 233, 14);
		contentPane.add(lblApelacion);
		
		
		partDao= new ParticipanteDAO();
		pedDao = new PedidoDAO();
		propDao = new PropuestaDAO();
		apelDao = new ApelacionDAO();
		
		
		arranque();
		
	}
	private void arranque() {
		
		cargarCboParticipante();
		cboParticipante.setEditable(true);
		
	}
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		limpiar();
		if (cboParticipante.getSelectedIndex()==0) {
			Tool.mensajeError(this, "Eliga un ID del participante que desea buscar");
		}else {
			consultaParticipante();
		}
	}
	
	
	//METODOS DE ENTRADA
	
	private String leerCboParticipante() {
		String res = null;
		
		res = (String) cboParticipante.getSelectedItem();
		
		return res;
		
	}
	
	
	//METODOS ADICIONALES

	
	
	private void cargarCboParticipante() {
		
		
		ArrayList<Participante> list = partDao.listarParticipante();
		
		cboParticipante.removeAllItems();
		cboParticipante.addItem("SELECCIONE..");
		
		for (Participante part: list) {
			
			cboParticipante.addItem(part.getCodParticipante());
			
		}
	}
	
	private void consultaParticipante() {
		
		String idParticipante = cboParticipante.getSelectedItem().toString();
		//OBJETO DE PARTICIPANTE
		Participante part = partDao.buscarXIdParticipante(idParticipante);
		cargarParticipante(part);
		//OBJETO DE PROPUESTA
		Propuesta prop = propDao.buscarPropuesta(idParticipante);
		cargarPropuesta(prop);
		//OBJETO DE APELACION
		Pedido ped = pedDao.buscarXIdPedido(part.getCodPedido());
		cargarPedido(ped);
		//OBJETO DE APELACION
		
		ArrayList<Apelacion> listApel = apelDao.listarApelacion();
		
		if (prop == null) {
			return;
		}else {
			for (Apelacion ape : listApel) {
				if (ape.getCodPropuesta().equals(prop.getCodPropuesta())) {
					cargarApelacion(ape);
				}
			}
		}
		

		
		
	}	

	
	private void cargarParticipante(Participante part) {
		
		txtParticipante.setText("");
		
		if (part == null){
			return;
		}else {

			Tool.imprimir(txtParticipante,"ID PARTICIPANTE	: " +  part.getCodParticipante() );
			Tool.imprimir(txtParticipante,"PARTICIPANTE		: " +  part.getEntidad() );
			Tool.imprimir(txtParticipante,"RUC		: " +  part.getRuc());
			Tool.imprimir(txtParticipante,"TELEFONO		: " +  part.getTelefono() );
			Tool.imprimir(txtParticipante,"ESTADO		: " + part.getEstado());
		}
		
	}
	
	private void cargarPedido(Pedido ped) {

		txtPedido.setText("");
		
		if(ped == null) {
			return;
		}else {

			Tool.imprimir(txtPedido,"ID PEDIDO		: " +  ped.getCodigo());
			Tool.imprimir(txtPedido,"ESTADO		: " + ped.getEstado());
			Tool.imprimir(txtPedido,"DESCRIPCION		: " +  ped.getDescripcion() );
		}
		
	}
	
	private void cargarApelacion(Apelacion apel) {
		
		txtApelacion.setText("");
		
		if (apel == null) {
			return;
		} else {
			
			Tool.imprimir(txtApelacion,"ID APELACION	: " +  apel.getCodApelacion() );
			Tool.imprimir(txtApelacion,"FECHA	: " +  apel.getFecha() );
			Tool.imprimir(txtApelacion,"ESTADO	: " + apel.getEstado());
		}
		
	}
	
	private void cargarPropuesta(Propuesta prop) {
		

		txtPropuesta.setText("");
		
		if (prop == null) {
			return;
		}else {
			
			Tool.imprimir(txtPropuesta,"ID PROPUESTA	: " +  prop.getCodPropuesta() );
			Tool.imprimir(txtPropuesta,"FECHA		: " +  prop.getFecha() );
			Tool.imprimir(txtPropuesta,"ESTADO		: " + prop.getEstado());
		}
		
	}
	
	private void limpiar () {
		txtPedido.setText("");
		txtPropuesta.setText("");
		txtApelacion.setText("");
		txtParticipante.setText("");
	}
}
