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
import javax.swing.JEditorPane;
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
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaApelacion extends JInternalFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JButton btnConsultar;
	private DefaultTableModel model; 
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private PropuestaDAO propDao;
	private ApelacionDAO apelDao;
	private JLabel lblIdParticipante;
	private JComboBox<Object> cboApelacion;
	private JTextArea txtCuadro1;
	private JTextArea txtCuadro2;
	private JLabel lblPedido;
	private JLabel lblApelacion;
	private JTextArea txtCuadro3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaApelacion frame = new FrmConsultaApelacion();
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
	public FrmConsultaApelacion() {
		setTitle("Consulta de Apelaciones");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultar = new JButton("");
		btnConsultar.setBackground(Color.LIGHT_GRAY);
		btnConsultar.setIcon(new ImageIcon(FrmConsultaApelacion.class.getResource("/imagenes/iconos_24x24/lupa.png")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(288, 11, 57, 36);
		contentPane.add(btnConsultar);
		
		lblIdParticipante = new JLabel("ID Apelacion :");
		lblIdParticipante.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblIdParticipante.setBounds(21, 21, 104, 26);
		contentPane.add(lblIdParticipante);
		
		cboApelacion = new JComboBox<Object>();
		cboApelacion.setBounds(135, 22, 138, 22);
		contentPane.add(cboApelacion);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(350, 89, 360, 419);
		contentPane.add(scrollPane_2);
		
		txtCuadro2 = new JTextArea();
		txtCuadro2.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane_2.setViewportView(txtCuadro2);
		txtCuadro2.setLineWrap(true);
		txtCuadro2.setEditable(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 330, 173);
		contentPane.add(scrollPane);
		
		txtCuadro1 = new JTextArea();
		txtCuadro1.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(txtCuadro1);
		txtCuadro1.setLineWrap(true);
		txtCuadro1.setEditable(false);
		
		lblPedido = new JLabel("DESCRIPCION DE LA APELACION :");
		lblPedido.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblPedido.setBounds(348, 61, 233, 17);
		contentPane.add(lblPedido);
		
		lblApelacion = new JLabel("DATOS GENERALES : ");
		lblApelacion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblApelacion.setBounds(10, 64, 233, 14);
		contentPane.add(lblApelacion);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 273, 330, 235);
		contentPane.add(scrollPane_1);
		
		txtCuadro3 = new JTextArea();
		txtCuadro3.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane_1.setViewportView(txtCuadro3);
		txtCuadro3.setLineWrap(true);
		txtCuadro3.setEditable(false);
		
		
		partDao= new ParticipanteDAO();
		pedDao = new PedidoDAO();
		propDao = new PropuestaDAO();
		apelDao = new ApelacionDAO();
		
		
		arranque();
		
	}
	private void arranque() {
		
		cargarCboApelacion();
		cboApelacion.setEditable(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultaApelacion();
	}
	
	
	//METODOS DE ENTRADA
	
	private String leerCboApelacion() {
		String res = null;
		res = (String) cboApelacion.getSelectedItem();
		return res;
		
	}
	
	
	//METODOS ADICIONALES
	
	private void cargarCboApelacion() {
				
ArrayList<Apelacion> list = apelDao.listarApelacion();
		
		cboApelacion.removeAllItems();
		cboApelacion.addItem("SELECCIONE...");
		
		for (Apelacion apel : list) {
			
			cboApelacion.addItem(apel.getCodApelacion());
			
		}
	}
	
	private void consultaApelacion() {
		
		String idApelacion = leerCboApelacion();
		Apelacion ape = apelDao.buscarXIdApelacion(idApelacion);
		
		cargarApelacion(ape);
		
		String idPropuesta = ape.getCodPropuesta();
		Propuesta prop = propDao.buscarXIdPropuesta(idPropuesta);
		
		cargarPropuesta(prop);  
		Pedido ped = pedDao.buscarXIdPedido(prop.getCodPedido());
		cargarPedido(ped);
		
		Participante part = partDao.buscarXIdParticipante(prop.getCodParticipante());
		cargarParticipante(part);
		

		
	}	

	
	private void cargarPedido(Pedido ped) {
	     txtCuadro3.setText("");
		
		if(ped == null) {
			return;
		}else {
			
			Tool.imprimir(txtCuadro3, "=========================================");
			Tool.imprimir(txtCuadro3," ID PEDIDO		 :" +  ped.getCodigo());
			Tool.imprimir(txtCuadro3," PEDIDO	  	:" +  ped.getEntidad() );
			Tool.imprimir(txtCuadro3," RUC		:" +  ped.getRuc());
			Tool.imprimir(txtCuadro3," ESTADO		:" + ped.getEstado());
			Tool.imprimir(txtCuadro3," ");
		}
	}

	private void cargarParticipante(Participante part) {
		
		//txtCuadro1.setText("");
		
		if (part == null){
			return;
		}else {
			
			Tool.imprimir(txtCuadro3, "=========================================");
			Tool.imprimir(txtCuadro3," ID PARTICIPANTE	: " + part.getCodParticipante() );
			Tool.imprimir(txtCuadro3," PARTICIPANTE	: " + part.getEntidad() );
			Tool.imprimir(txtCuadro3," RUC		: " + part.getRuc());
			Tool.imprimir(txtCuadro3," TELEFONO		: " + part.getTelefono() );
			Tool.imprimir(txtCuadro3," ESTADO		: " + part.getEstado());
		}
		
	}
	
	private void cargarApelacion(Apelacion apel) {
		
		txtCuadro1.setText("");
		txtCuadro2.setText("");
		if (apel == null) {
			return;
		} else {
			
			Tool.imprimir(txtCuadro1, "=========================================");
			Tool.imprimir(txtCuadro1," ID APELACION		: " +  apel.getCodApelacion() );
			Tool.imprimir(txtCuadro1," FECHA		: " +  apel.getFecha() );
			Tool.imprimir(txtCuadro1," ESTADO		: " +  apel.getEstado());
			//DESCRIPCION
			Tool.imprimir(txtCuadro2,apel.getDescripcion());
			Tool.imprimir(txtCuadro1," ");
		}
		
	}

	private void cargarPropuesta(Propuesta prop) {
		//txtCuadro1.setText("");
		if (prop == null) {
			return;
		}else {
			Tool.imprimir(txtCuadro1, "=========================================");
			Tool.imprimir(txtCuadro1," ID PROPUESTA	: " +  prop.getCodPropuesta() );
			Tool.imprimir(txtCuadro1," FECHA		: " +  prop.getFecha() );
			Tool.imprimir(txtCuadro1," ESTADO		: " +  prop.getEstado());
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
