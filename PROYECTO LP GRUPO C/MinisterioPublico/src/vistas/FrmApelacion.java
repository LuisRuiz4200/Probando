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
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FrmApelacion extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPropuesta;
	private JLabel lblFechaApelacion;
	private JLabel lblDescripcion;
	private JLabel lblEstado;
	private JDateChooser dcFechaApelacion;
	private JEditorPane txtDescripcion;
	private JButton btnRegistrar;
	private JScrollPane spDescripcion;
	private JTextField txtIdApelacion;
	
	private PropuestaDAO propDao;
	private ApelacionDAO apeDao;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JLabel lblApelacion;
	private JPanel panelPedido;
	private JPanel panelParticipante;
	private JLabel lblEstadoDePropuesta;
	public static JTextField txtEstadoPropuesta;
	private JTextField txtEstadoApelacion;
	public static JTextField txtIdPropuesta;

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
		setBounds(100, 100, 700, 355);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblDescripcion.setBounds(312, 12, 109, 14);
		contentPane.add(lblDescripcion);
		
		spDescripcion = new JScrollPane();
		spDescripcion.setBounds(310, 26, 338, 247);
		getContentPane().add(spDescripcion);
		
		
		txtDescripcion = new JEditorPane();
		spDescripcion.setViewportView(txtDescripcion);
		
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(274, 291, 109, 23);
		getContentPane().add(btnRegistrar);
		
		panelPedido = new JPanel();
		panelPedido.setLayout(null);
		panelPedido.setOpaque(false);
		panelPedido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "APELACION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPedido.setBounds(10, 145, 284, 132);
		contentPane.add(panelPedido);
		
		lblApelacion = new JLabel("ID Apelacion:");
		lblApelacion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblApelacion.setBounds(10, 21, 83, 14);
		panelPedido.add(lblApelacion);
		
		txtIdApelacion = new JTextField();
		txtIdApelacion.setEditable(false);
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
		
		txtEstadoApelacion = new JTextField();
		txtEstadoApelacion.setEditable(false);
		txtEstadoApelacion.setText("REGISTRADO");
		txtEstadoApelacion.setBounds(151, 46, 113, 20);
		panelPedido.add(txtEstadoApelacion);
		txtEstadoApelacion.setColumns(10);
		
		btnLimpiar = new JButton("");
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.setBounds(182, 90, 46, 33);
		panelPedido.add(btnLimpiar);
		btnLimpiar.setIcon(new ImageIcon(FrmApelacion.class.getResource("/imagenes/iconos_24x24/limpiar.png")));
		btnLimpiar.addActionListener(this);	
		
		panelParticipante = new JPanel();
		panelParticipante.setForeground(Color.BLACK);
		panelParticipante.setLayout(null);
		panelParticipante.setOpaque(false);
		panelParticipante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROPUESTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelParticipante.setBackground(Color.BLACK);
		panelParticipante.setBounds(10, 11, 284, 132);
		contentPane.add(panelParticipante);
		
		lblPropuesta = new JLabel("ID Propuesta:");
		lblPropuesta.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblPropuesta.setBounds(10, 26, 140, 14);
		panelParticipante.add(lblPropuesta);
		
		btnBuscar = new JButton("");
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setIcon(new ImageIcon(FrmApelacion.class.getResource("/imagenes/iconos_24x24/lupa.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(138, 26, 40, 36);
		panelParticipante.add(btnBuscar);
		
		lblEstadoDePropuesta = new JLabel("Estado de Propuesta:");
		lblEstadoDePropuesta.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblEstadoDePropuesta.setBounds(10, 73, 123, 14);
		panelParticipante.add(lblEstadoDePropuesta);
		
		txtEstadoPropuesta = new JTextField();
		txtEstadoPropuesta.setEditable(false);
		txtEstadoPropuesta.setColumns(10);
		txtEstadoPropuesta.setBounds(10, 88, 106, 22);
		panelParticipante.add(txtEstadoPropuesta);
		
		txtIdPropuesta = new JTextField();
		txtIdPropuesta.setEditable(false);
		txtIdPropuesta.setBounds(10, 42, 106, 20);
		panelParticipante.add(txtIdPropuesta);
		txtIdPropuesta.setColumns(10);
		
		propDao = new PropuestaDAO();
		apeDao = new ApelacionDAO();
		
		
		arranque();
	}
	
	private void arranque() {
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
		res = txtEstadoApelacion.getText().trim();
		
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
		res = txtIdPropuesta.getText().toString();
		
		return res;
	}
	
	//METODOS ADICIONALES
	


	private void limpiar() {
		txtIdPropuesta.setText("");
		txtEstadoPropuesta.setText("");
		txtDescripcion.setText("");
		dcFechaApelacion.setDate(new Date());
		
	
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
		FrmBuscarPropuesta buscarPropuesta = new FrmBuscarPropuesta();
		buscarPropuesta.setVisible(true);
		
	}

	
}
