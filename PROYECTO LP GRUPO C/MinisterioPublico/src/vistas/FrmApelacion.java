package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import Validaciones.Reguex;
import clases.Apelacion;
import clases.Propuesta;
import mantenimiento.ApelacionDAO;
import mantenimiento.PropuestaDAO;
import utils.Tool;
import javax.swing.SwingConstants;

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
	private JButton btnRegistrar;
	private JScrollPane spDescripcion;
	private JTextField txtIdApelacion;
	
	private PropuestaDAO propDao;
	private ApelacionDAO apeDao;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JLabel lblCodigo_1;
	private JPanel panelPedido;
	private JPanel panelParticipante;
	private JLabel lblEstadoDePropuesta;
	private JTextField txtEstado;
	private JTextField txtEstado1;

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
		setBounds(100, 100, 700, 409);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblDescripcion.setBounds(309, 11, 109, 14);
		contentPane.add(lblDescripcion);
		
		spDescripcion = new JScrollPane();
		spDescripcion.setBounds(310, 36, 338, 323);
		getContentPane().add(spDescripcion);
		
		
		txtDescripcion = new JEditorPane();
		spDescripcion.setViewportView(txtDescripcion);
		
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(51, 320, 97, 23);
		getContentPane().add(btnRegistrar);
		
		panelPedido = new JPanel();
		panelPedido.setLayout(null);
		panelPedido.setOpaque(false);
		panelPedido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "APELACION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPedido.setBounds(10, 154, 284, 147);
		contentPane.add(panelPedido);
		
		lblCodigo_1 = new JLabel("ID Apelacion:");
		lblCodigo_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblCodigo_1.setBounds(10, 21, 83, 14);
		panelPedido.add(lblCodigo_1);
		
		txtIdApelacion = new JTextField();
		txtIdApelacion.setBounds(10, 46, 123, 20);
		panelPedido.add(txtIdApelacion);
		
		lblEstado = new JLabel("Estado de Apelación:");
		lblEstado.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblEstado.setBounds(151, 21, 123, 14);
		panelPedido.add(lblEstado);
			
			lblFechaApelacion = new JLabel("Fecha de la Apelación:");
			lblFechaApelacion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
			lblFechaApelacion.setBounds(10, 77, 142, 14);
			panelPedido.add(lblFechaApelacion);
			
			dcFechaApelacion = new JDateChooser();
			dcFechaApelacion.setBounds(10, 102, 123, 20);
			panelPedido.add(dcFechaApelacion);
			
			txtEstado1 = new JTextField();
			txtEstado1.setEditable(false);
			txtEstado1.setText("REGISTRADO");
			txtEstado1.setBounds(151, 46, 113, 20);
			panelPedido.add(txtEstado1);
			txtEstado1.setColumns(10);
			
			panelParticipante = new JPanel();
			panelParticipante.setLayout(null);
			panelParticipante.setOpaque(false);
			panelParticipante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROPUESTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelParticipante.setBackground(SystemColor.menu);
			panelParticipante.setBounds(10, 11, 284, 132);
			contentPane.add(panelParticipante);
			
			lblPropuesta = new JLabel("ID Propuesta:");
			lblPropuesta.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
			lblPropuesta.setBounds(10, 26, 140, 14);
			panelParticipante.add(lblPropuesta);
			
			cboPropuesta = new JComboBox<Object>();
			cboPropuesta.setBounds(10, 43, 123, 22);
			panelParticipante.add(cboPropuesta);
			
			btnBuscar = new JButton("Buscar \r\nPropuesta");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(151, 64, 123, 36);
			panelParticipante.add(btnBuscar);
			
			lblEstadoDePropuesta = new JLabel("Estado de Propuesta:");
			lblEstadoDePropuesta.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
			lblEstadoDePropuesta.setBounds(10, 76, 123, 14);
			panelParticipante.add(lblEstadoDePropuesta);
			
			txtEstado = new JTextField();
			txtEstado.setEditable(false);
			txtEstado.setColumns(10);
			txtEstado.setBounds(10, 99, 106, 22);
			panelParticipante.add(txtEstado);
			
			btnLimpiar = new JButton("LIMPIAR");
			btnLimpiar.setBounds(180, 320, 89, 23);
			contentPane.add(btnLimpiar);
			btnLimpiar.addActionListener(this);
		
		propDao = new PropuestaDAO();
		apeDao = new ApelacionDAO();
		
		cargarCboPropuesta();
		correlativo();
		limpiar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
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
			Apelacion ape = new Apelacion (idApelacion,idPropuesta, 
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
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
	}
	
    //METODOS DE ENTRADA 
	private String leerDescripcion() {
		String res = null;
		if(txtDescripcion.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar el Descripcion de la Apelacion");
			txtDescripcion.requestFocus();
		}else if (txtDescripcion.getText().trim().matches(Reguex.DESCRIPCION_APE)) {
			res = txtDescripcion.getText().trim();
		}else {
			Tool.mensajeError(this," Ingresar Descripcion Valida ");
			txtDescripcion.setText("");
			txtDescripcion.requestFocus();
		}
		
		return res ;
	}
	
	private String leerFecha() {
		String res=null;
		res = Tool.sdf.format(dcFechaApelacion.getDate()).toString();
		
		return res;
	}

	private String leerEstado() {
	    String res=null;
		res = txtEstado1.getText().trim();
		
		return res;
	}

	private String leerIdApelacion() {
		String res = null;
		if(txtIdApelacion.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar el Id Apelacion");
			txtIdApelacion.requestFocus();
		}else if (txtIdApelacion.getText().trim().matches(Reguex.ID_APELACION)) {
			res = txtIdApelacion.getText().trim();
		}else {
			Tool.mensajeError(this," Ingresar Id Apelacion Valido. Ej: AP001 ");
			txtIdApelacion.setText("");
			txtIdApelacion.requestFocus();
		}
		
		return res ;
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
		
		boolean bandera = false;
		
		for (Propuesta ped : list) {
			if (ped.getEstado().equals("OBSERVADO")) {
				cboPropuesta.addItem(ped.getCodPropuesta());
				bandera = true;
			}
		}
		
		if (bandera == false) {
			Tool.mensajeError(this, "No hay propuestas en estado de OBSERVADO");
		}

     }


	private void limpiar() {
		txtDescripcion.setText("");
		dcFechaApelacion.setDate(new Date());
		cboPropuesta.setSelectedIndex(0);
	
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
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		String codigo;
		// 1 obtener el codigo ingresado
		codigo = getCodigoPropuesta();
		// Validar
				if (codigo == null) {
					return;
				} else {
					// llamar al proceso
					Propuesta prop = propDao.buscarXIdPropuesta(codigo);
					// Validar el resultado del proceso
					if (prop == null) {
						Tool.mensajeError(this, "Propuesta no existe");
					} else {
						txtEstado.setText(prop.getEstado());						
					}
				}
	}

	private String getCodigoPropuesta() {
		return cboPropuesta.getSelectedItem().toString();
	}
}
