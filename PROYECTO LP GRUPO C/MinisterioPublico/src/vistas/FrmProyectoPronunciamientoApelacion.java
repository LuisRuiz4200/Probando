package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Validaciones.Reguex;
import clases.Apelacion;
import clases.Participante;
import clases.Pronunciamiento;
import clases.Propuesta;
import mantenimiento.ApelacionDAO;
import mantenimiento.ParticipanteDAO;
import mantenimiento.PronunciamientoDAO;
import mantenimiento.PropuestaDAO;
import utils.Tool;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


@SuppressWarnings("serial")
public class FrmProyectoPronunciamientoApelacion extends JInternalFrame implements ActionListener {
	
	private JLabel lblCodigo;
	private JTextField txtPronunciamiento;
	private JLabel lblApelacion;
	private JTextField txtNombreEncargado;
	private JLabel lblNombreEncargado;
	private JTextField txtApellidoEncargado;
	private JLabel lblApellidoEncargado;
	private JDateChooser dcFecha;
	private JLabel lblFecha;
	private JEditorPane txtConclusiones;
	private JLabel lblConclusion;
	private JLabel lblResultado;
	private JTextField txtDni;
	private JLabel lblDni;
	private JButton btnRegistrar;
	private JComboBox <Object> cboResultado;
    private PronunciamientoDAO proDao;
    private PropuestaDAO propDao;
    private ParticipanteDAO partDao;
    private ApelacionDAO apeDao;
    private JButton btnBuscarApelacion;
    public static JTextField txtIdApelacion;
    private JPanel panelGerente;
	
	public static void main (String [] args) {
		FrmProyectoPronunciamientoApelacion pro = new FrmProyectoPronunciamientoApelacion ();
		pro.setVisible(true);
	}
	
	public FrmProyectoPronunciamientoApelacion () {
		
		setTitle("Proyecto de Pronunciamiento de Apelacion");
		setBounds(100,100,731,418);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.lightGray);
		
		lblCodigo = new JLabel("ID Pronunciamiento :");
		lblCodigo.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblCodigo.setBounds(254, 12, 116, 14);
		getContentPane().add(lblCodigo);
		
		txtPronunciamiento = new JTextField();
		txtPronunciamiento.setColumns(10);
		txtPronunciamiento.setBounds(254, 28, 98, 20);
		getContentPane().add(txtPronunciamiento);
		
		lblApelacion = new JLabel("ID Apelacion :");
		lblApelacion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblApelacion.setBounds(10, 11, 107, 14);
		getContentPane().add(lblApelacion);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(400, 28, 137, 20);
		getContentPane().add(dcFecha);
		
		lblFecha = new JLabel(" Fecha :");
		lblFecha.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblFecha.setBounds(400, 11, 46, 14);
		getContentPane().add(lblFecha);
		
		txtConclusiones = new JEditorPane();
		txtConclusiones.setBounds(10, 181, 695, 196);
		getContentPane().add(txtConclusiones);
		
		lblConclusion = new JLabel("Conclusiones :");
		lblConclusion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblConclusion.setBounds(10, 159, 98, 14);
		getContentPane().add(lblConclusion);
		
		lblResultado = new JLabel("Resultado :");
		lblResultado.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblResultado.setBounds(573, 11, 98, 14);
		getContentPane().add(lblResultado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(501, 154, 109, 23);
		getContentPane().add(btnRegistrar);
		
		cboResultado = new JComboBox <Object>();
		cboResultado.setModel(new DefaultComboBoxModel(new String[] {"FUNDADO", "NO FUNDADO"}));
		cboResultado.setBounds(561, 27, 98, 22);
		getContentPane().add(cboResultado);
		
		btnBuscarApelacion = new JButton("Buscar");
		btnBuscarApelacion.addActionListener(this);
		btnBuscarApelacion.setBounds(106, 27, 89, 23);
		getContentPane().add(btnBuscarApelacion);
		
		txtIdApelacion = new JTextField();
		txtIdApelacion.setBounds(10, 28, 86, 20);
		getContentPane().add(txtIdApelacion);
		txtIdApelacion.setColumns(10);
		
		panelGerente = new JPanel();
		panelGerente.setOpaque(false);
		panelGerente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DATOS DEL PERSONAL A CARGO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGerente.setBounds(10, 59, 631, 89);
		getContentPane().add(panelGerente);
		panelGerente.setLayout(null);
		
		lblNombreEncargado = new JLabel("Nombre del gerente :");
		lblNombreEncargado.setBounds(10, 24, 149, 14);
		panelGerente.add(lblNombreEncargado);
		lblNombreEncargado.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		
		txtNombreEncargado = new JTextField();
		txtNombreEncargado.setBounds(10, 43, 185, 20);
		panelGerente.add(txtNombreEncargado);
		txtNombreEncargado.setColumns(10);
		
		txtApellidoEncargado = new JTextField();
		txtApellidoEncargado.setBounds(205, 43, 198, 20);
		panelGerente.add(txtApellidoEncargado);
		txtApellidoEncargado.setColumns(10);
		
		lblApellidoEncargado = new JLabel("Apellidos del gerente :");
		lblApellidoEncargado.setBounds(205, 24, 149, 14);
		panelGerente.add(lblApellidoEncargado);
		lblApellidoEncargado.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		
		txtDni = new JTextField();
		txtDni.setBounds(413, 43, 137, 20);
		panelGerente.add(txtDni);
		txtDni.setColumns(10);
		
		lblDni = new JLabel("Documento de Identidad :");
		lblDni.setBounds(413, 24, 137, 14);
		panelGerente.add(lblDni);
		lblDni.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		
		propDao= new PropuestaDAO();
		partDao = new ParticipanteDAO();
		proDao = new PronunciamientoDAO();
		apeDao = new ApelacionDAO();
		
		arranque();
		correlativo();
	}

	private void arranque() {
		limpiar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarApelacion) {
			actionPerformedBtnBuscarApelacion(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	
	protected void actionPerformedBtnBuscarApelacion(ActionEvent e) {
		FrmBuscarApelacion buscarApelacion = new FrmBuscarApelacion();
		buscarApelacion.setVisible(true);
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String idPronApelacion = leerPronApelacion();
		String idApelacion = leerIdApelacion();
		String nombGerente = leerNomGerente();
		String dni = leerDni();
		String fecha = leerFecha();
		String conclusion = leerConclusion();
		String estado = leerEstado();
		
		Propuesta prop = null;
		Apelacion apel = null;
		Participante part =  null;
		
		if (idPronApelacion == null || idApelacion == null || 
				nombGerente == null || dni == null ||  fecha == null || 
				conclusion == null || estado == null ) {
			return;
		}else {
			Pronunciamiento pro = new Pronunciamiento (idPronApelacion,
					idApelacion, nombGerente, dni, fecha, conclusion,
					estado);
			int ok = proDao.registrarPronApelacion(pro);
			if (ok == 0) {
				Tool.mensajeError(this, "Error de registro");
			}else {
				Tool.mensajeExito(this, "Registro exitoso");
				limpiar();
				
				//CAMBIO DE ESTADO EN LAS ENTIDADES RELACIONADAS
				
				apel = apeDao.buscarXIdApelacion(pro.getIdApel());
				
				prop = propDao.buscarXIdPropuesta(apel.getCodPropuesta());
				
				part = partDao.buscarXIdParticipante(prop.getCodParticipante());
				
				if (pro.getEstado().equals("fundado")) {
					apel.setEstado("FUNDADO");
					prop.setEstado("PROCESO");
					propDao.actualizarPropuesta(prop);
					apeDao.modificarApelacion(apel);
				}else if (prop.getEstado().equals("no fundado")) {
					apel.setEstado("NO FUNDADO");
					prop.setEstado("NO ADMITIDA");
					part.setEstado("NO CALIFICA");
					propDao.actualizarPropuesta(prop);
					apeDao.modificarApelacion(apel);
					partDao.actualizarPartcipante(part);
				}
			}
		}
	}
	
	//METODOS DE ENTRADA
    private String leerEstado() {
		String res = null;
		return res = cboResultado.getSelectedItem().toString();
	}

	private String leerConclusion() {
		String res = null;
		if(txtConclusiones.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar Conclusion");
			txtConclusiones.requestFocus();
		}else if (txtConclusiones.getText().trim().matches(Reguex.CONCLUSION)) {
			res = txtConclusiones.getText().trim();
		}else {
			Tool.mensajeError(this," Reducir la redaccion ");
			txtDni.setText("");
			txtDni.requestFocus();
		}
		
		return res ;
	}

	private String leerFecha() {
		String res = null;
		return res = Tool.sdf.format(dcFecha.getDate()).toString();
	}

	private String leerDni() {
		String res = null;
		if(txtDni.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar el DNI del Acesor");
			txtDni.requestFocus();
		}else if (txtDni.getText().trim().matches(Reguex.DNI_ACESOR)) {
			res = txtDni.getText().trim();
		}else {
			Tool.mensajeError(this," Ingresar numero de DNI valido ");
			txtDni.setText("");
			txtDni.requestFocus();
		}
		
		return res ;
	}

	private String leerNomGerente() {
		String res = null;
		return res = txtNombreEncargado.getText().trim() + " " + txtApellidoEncargado.getText().trim();
	}

	private String leerIdApelacion() {
		String res = null;
		return res = txtIdApelacion.getText();
	}

	private String leerPronApelacion() {
		String res = null;
		if(txtPronunciamiento.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar el Id de Pronunciamiento de Apelacion");
			txtPronunciamiento.requestFocus();
		}else if (txtPronunciamiento.getText().trim().matches(Reguex.ID_PRONUNCIAMIENTO)) {
			res = txtPronunciamiento.getText().trim();
		}else {
			Tool.mensajeError(this," Ingresar Id Pronunciamiento Valido Ej: PA001 ");
			txtPronunciamiento.setText("");
			txtPronunciamiento.requestFocus();
		}
		
		return res ;
	}

	//METODOS AADICIONALES

	private void correlativo() {
		@SuppressWarnings("resource")
	    Formatter ft = new Formatter();
		
		ArrayList <Pronunciamiento> list = proDao.listarPronunciamiento();
		if (list.size() == 0) {
			txtPronunciamiento.setText("PA001");
		}else {
			String idPronApelacion = list.get(list.size()-1).getIdPronun();
            int n =Integer.parseInt(idPronApelacion.substring(2))+1;
			
			txtPronunciamiento.setText("");
			txtPronunciamiento.setText("PA"+ft.format("%03d", n));
		}
	}
	private void limpiar() {
		correlativo();
		txtIdApelacion.setEditable(false);
		dcFecha.setDate(new Date());
		cboResultado.setSelectedIndex(0);
		txtNombreEncargado.setText("");
		txtApellidoEncargado.setText("");
		txtDni.setText("");
		txtConclusiones.setText("");
	}

}
