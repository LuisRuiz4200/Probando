package vistas;

import java.awt.EventQueue;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import mantenimiento.*;
import utils.Tool;
import clases.*;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmApelacion extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPropuesta;
	private JLabel lblFechaApelacion;
	private JLabel lblDescripcion;
	private JLabel lblEstado;
	private JComboBox <Object> cboPropuesta;
	private JDateChooser dcFechaApelacion;
	private JEditorPane txtDescripcion;
	private JComboBox <Object> cboEstado;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JScrollPane spDescripcion;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	
	private PropuestaDAO propDao;
	private ApelacionDAO apelDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmApelacion frame = new FrmApelacion();
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
	public FrmApelacion() {
		setTitle("Apelacion");
		setBounds(100, 100, 687, 409);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPropuesta = new JLabel("ID Propuesta:");
		lblPropuesta.setBounds(10, 11, 140, 14);
		contentPane.add(lblPropuesta);
		
		lblFechaApelacion = new JLabel("Fecha de la Apelación:");
		lblFechaApelacion.setBounds(160, 63, 140, 14);
		contentPane.add(lblFechaApelacion);
		
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(309, 11, 109, 14);
		contentPane.add(lblDescripcion);
		
		lblEstado = new JLabel("Estado de Apelación:");
		lblEstado.setBounds(160, 12, 123, 14);
		contentPane.add(lblEstado);
		
		cboPropuesta = new JComboBox<Object>();
		cboPropuesta.setBounds(10, 31, 123, 22);
		contentPane.add(cboPropuesta);
		
		dcFechaApelacion = new JDateChooser();
		dcFechaApelacion.setBounds(160, 83, 123, 20);
		contentPane.add(dcFechaApelacion);
		
		spDescripcion = new JScrollPane();
		spDescripcion.setBounds(310, 36, 338, 323);
		getContentPane().add(spDescripcion);
		
		
		txtDescripcion = new JEditorPane();
		spDescripcion.setViewportView(txtDescripcion);
	
		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar", "En Proceso",  "Aceptado", "Rechazado"}));
		cboEstado.setBounds(160, 30, 123, 22);
		contentPane.add(cboEstado);
		
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(10, 234, 109, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(142, 234, 109, 23);
		getContentPane().add(btnModificar);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 83, 123, 20);
		contentPane.add(txtCodigo);
		
		lblCodigo = new JLabel("ID Apelacion:");
		lblCodigo.setBounds(10, 63, 140, 14);
		contentPane.add(lblCodigo);
		
		propDao = new PropuestaDAO();
		arranque();
		
	}

	private void arranque() {
		
		cargarCboPropuesta();
		
	}

		
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String idPropuesta = leerPropuesta();
		String idApelacion = leerApelacion();
		int idEstadoApe = leerIdEstado();
		String fecha = leerFecha();
		
		//if ( idPropuesta == null || idApelacion == null || id )
	}
	

	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	
	//METODOS INTERNOS 
	private String leerFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	private int leerIdEstado() {
		// TODO Auto-generated method stub
		return 0;
	}

	private String leerApelacion() {
		// TODO Auto-generated method stub
		return null;
	}

	private String leerPropuesta() {
		// TODO Auto-generated method stub
		return null;
	}
	//METODOS ADICIONALES
	
	private void cargarCboPropuesta() {
		/*ArrayList<Pedido> list = propDao.listarPropuesta();
		
		cboPropuesta.removeAllItems();
		cboPropuesta.addItem("SELECCIONE...");
		
		for (Pedido ped : list) {
			
			cboPropuesta.addItem(ped.getCodigo());
			
		}
	*/
     }
}
