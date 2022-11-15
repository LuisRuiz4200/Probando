package vistas;

import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

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
	private JTextField txtIdApelacion;
	private JLabel lblCodigo;
	
	private PropuestaDAO propDao;
	private ApelacionDAO apeDao;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnLimpiar;

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
		lblFechaApelacion.setBounds(10, 119, 140, 14);
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
		dcFechaApelacion.setBounds(10, 144, 123, 20);
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
		btnRegistrar.setBounds(10, 234, 77, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(107, 234, 77, 23);
		getContentPane().add(btnModificar);
		
		txtIdApelacion = new JTextField();
		txtIdApelacion.setBounds(10, 83, 123, 20);
		contentPane.add(txtIdApelacion);
		
		lblCodigo = new JLabel("ID Apelacion:");
		lblCodigo.setBounds(10, 63, 140, 14);
		contentPane.add(lblCodigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(178, 82, 89, 23);
		contentPane.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(206, 234, 89, 23);
		contentPane.add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(178, 141, 89, 23);
		contentPane.add(btnLimpiar);
		
		propDao = new PropuestaDAO();
		apeDao = new ApelacionDAO();
		
		cargarCboPropuesta();
		correlativo();
		limpiar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		} 
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String idPropuesta = leerIdPropuesta();
		String idApelacion = leerIdApelacion();
		String fechPropuesta = leerFecha();
		String descripcion = leerDescripcion();
		String estado = leerEstado();
		
		if ( idPropuesta == null || idApelacion == null || fechPropuesta == null ||
				descripcion == null || estado ==  null ) {
			return; 
		} else {
			Apelacion ape = new Apelacion (idPropuesta, idApelacion, 
					fechPropuesta, descripcion, estado   
					);
			int ok = apeDao.resgistrarApelacion(ape);
			if (ok == 0) {
				Tool.mensajeError(this, "Error de registro");
			}else {
				Tool.mensajeExito(this, "Registro exitoso");
				correlativo();
			}
		}
	}
    
	protected void actionPerformedBtnModificar(ActionEvent e) {
		String idApelacion = leerIdApelacion();
		String idPropuesta = leerIdPropuesta();
		String fechPropuesta = leerFecha();
		String descripcion = leerDescripcion();
		String estado = leerEstado();
		
		if ( idApelacion == null || idPropuesta == null || fechPropuesta == null ||
				descripcion == null || estado == null ) {
			return; 
		} else {
			Apelacion ape = new Apelacion (
					idApelacion, idPropuesta, fechPropuesta, descripcion, descripcion   
					);
			int ok = apeDao.modificarApelacion(ape);
			if (ok == 0) {
				Tool.mensajeError(this, "Error de registro");
			}else {
				Tool.mensajeExito(this, "Registro exitoso");
				correlativo();
			}
		}
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		String codApelacion =  leerIdApelacion();
		String codPropuesta = leerIdPropuesta();
		
		int ok = apeDao.eliminarApelacion (codApelacion, codPropuesta);
		
		if(ok == 0) {
			Tool.mensajeError(this, "Error en eliminar!");
		}else {
			Tool.mensajeExito(this, "Se eliminó un participante");
			
		}
	}
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
	}
	
    //METODOS DE ENTRADA 
	private String leerDescripcion() {
		String res = null;
		res = txtDescripcion.getText().trim();
		
		return res;
	}
	
	private String leerFecha() {
		String res=null;
		res = Tool.sdf.format(dcFechaApelacion.getDate()).toString();
		
		return res;
	}

	private String leerEstado() {
	    String res=null;
		res = cboEstado.getSelectedItem().toString();
		
		return res;
	}

	private String leerIdApelacion() {
		String res = null;
		res = txtIdApelacion.getText().trim();
		
		return res;
	}
	
	private String leerIdPropuesta() {
		String res = null;
		res = cboPropuesta.getSelectedItem().toString();
		
		return res;
	}
	
	//METODOS ADICIONALES
	
	private void cargarCboPropuesta() {
		ArrayList<Propuesta> list = propDao.listarPropuestas();
		
		cboPropuesta.removeAllItems();
		cboPropuesta.addItem("SELECCIONE...");
		
		for (Propuesta ped : list) {
			
			cboPropuesta.addItem(ped.getCodPropuesta());
			
		}

     }


	private void limpiar() {
		txtDescripcion.setText("");
		dcFechaApelacion.setDate(new Date());
		cboPropuesta.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
	
    }
    private void correlativo() {
    	@SuppressWarnings("resource")
	    Formatter ft = new Formatter();
	    
	    ArrayList <Apelacion> list = apeDao.listarApelacion();
		if (list.size()==0) {
			txtIdApelacion.setText("AP001");
		}else {
			String idApelacion = list.get(list.size()-1).getCodApelacion();
			
			int n =Integer.parseInt(idApelacion.substring(2))+1;
			
			txtIdApelacion.setText("");
			txtIdApelacion.setText("AP"+ft.format("%03d", n));
          }
    }

}
