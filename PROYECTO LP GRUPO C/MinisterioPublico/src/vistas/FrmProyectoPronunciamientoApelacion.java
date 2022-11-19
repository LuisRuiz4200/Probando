package vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import mantenimiento.*;
import utils.Tool;
import clases.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class FrmProyectoPronunciamientoApelacion extends JInternalFrame implements ActionListener {
	
	private JLabel lblCodigo;
	private JTextField txtPronunciamiento;
	private JLabel lblApelacion;
	private JComboBox <Object> cboApelacion;
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
	private JButton btnModificar;
	private JComboBox <Object> cboResultado;
    private PronunciamientoDAO proDao;
    private ApelacionDAO apeDao;
	
	public static void main (String [] args) {
		FrmProyectoPronunciamientoApelacion pro = new FrmProyectoPronunciamientoApelacion ();
		pro.setVisible(true);
	}
	
	public FrmProyectoPronunciamientoApelacion () {
		
		setTitle("Proyecto de Pronunciamiento de Apelacion");
		setBounds(100,100,731,449);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.lightGray);
		
		lblCodigo = new JLabel("ID Pronunciamiento :");
		lblCodigo.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblCodigo.setBounds(200, 11, 116, 14);
		getContentPane().add(lblCodigo);
		
		txtPronunciamiento = new JTextField();
		txtPronunciamiento.setColumns(10);
		txtPronunciamiento.setBounds(200, 31, 98, 20);
		getContentPane().add(txtPronunciamiento);
		
		lblApelacion = new JLabel("ID Apelacion :");
		lblApelacion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblApelacion.setBounds(10, 11, 107, 14);
		getContentPane().add(lblApelacion);
		
		cboApelacion = new JComboBox <Object>();
		cboApelacion.setBounds(10, 30, 131, 22);
		getContentPane().add(cboApelacion);
		
		txtNombreEncargado = new JTextField();
		txtNombreEncargado.setColumns(10);
		txtNombreEncargado.setBounds(10, 80, 170, 20);
		getContentPane().add(txtNombreEncargado);
		
		lblNombreEncargado = new JLabel("Nombre del gerente :");
		lblNombreEncargado.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNombreEncargado.setBounds(10, 61, 149, 14);
		getContentPane().add(lblNombreEncargado);
		
		txtApellidoEncargado = new JTextField();
		txtApellidoEncargado.setColumns(10);
		txtApellidoEncargado.setBounds(200, 80, 170, 20);
		getContentPane().add(txtApellidoEncargado);
		
		lblApellidoEncargado = new JLabel("Apellidos del gerente :");
		lblApellidoEncargado.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblApellidoEncargado.setBounds(200, 61, 149, 14);
		getContentPane().add(lblApellidoEncargado);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(400, 31, 137, 20);
		getContentPane().add(dcFecha);
		
		lblFecha = new JLabel(" Fecha :");
		lblFecha.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblFecha.setBounds(400, 11, 46, 14);
		getContentPane().add(lblFecha);
		
		txtConclusiones = new JEditorPane();
		txtConclusiones.setBounds(10, 125, 695, 252);
		getContentPane().add(txtConclusiones);
		
		lblConclusion = new JLabel("Conclusiones :");
		lblConclusion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblConclusion.setBounds(10, 106, 98, 14);
		getContentPane().add(lblConclusion);
		
		lblResultado = new JLabel("Resultado :");
		lblResultado.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblResultado.setBounds(573, 11, 98, 14);
		getContentPane().add(lblResultado);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(400, 80, 137, 20);
		getContentPane().add(txtDni);
		
		lblDni = new JLabel("Documento de Identidad :");
		lblDni.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblDni.setBounds(400, 61, 137, 14);
		getContentPane().add(lblDni);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(228, 385, 109, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(376, 385, 109, 23);
		getContentPane().add(btnModificar);
		
		cboResultado = new JComboBox <Object>();
		cboResultado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Fundado", "No fundado"}));
		cboResultado.setBounds(573, 30, 98, 22);
		getContentPane().add(cboResultado);
		
		proDao = new PronunciamientoDAO();
		apeDao = new ApelacionDAO();
		
		arranque();
		correlativo();
	}

	private void arranque() {
		cargarCboApelacion();
		
		
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
		String idPronApelacion = leerPronApelacion();
		String idApelacion = leerIdApelacion();
		String nombGerente = leerNomGerente();
		String dni = leerDni();
		String fecha = leerFecha();
		String conclusion = leerConclusion();
		String estado = leerEstado();
		
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
				correlativo();
			}
		}
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		String idPronApelacion = leerPronApelacion();
		String idApelacion = leerIdApelacion();
		String nombGerente = leerNomGerente();
		String dni = leerDni();
		String fecha = leerFecha();
		String conclusion = leerConclusion();
		String estado = leerEstado();
		
		if (idPronApelacion == null || idApelacion == null || 
				nombGerente == null || dni == null ||  fecha == null || 
				conclusion == null || estado == null ) {
			return;
		}else {
			Pronunciamiento pro = new Pronunciamiento (idPronApelacion,
					idApelacion, nombGerente, dni, fecha, conclusion,
					estado);
			int ok = proDao.modificarPronApelacion(pro);
			if (ok == 0) {
				Tool.mensajeError(this, "Error de Actualizacion");
			}else {
				Tool.mensajeExito(this, "Actualizacion exitoso");
				correlativo();
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
		return res = txtConclusiones.getText().trim();
	}

	private String leerFecha() {
		String res = null;
		return res = Tool.sdf.format(dcFecha.getDate()).toString();
	}

	private String leerDni() {
		String res = null;
		return res = txtDni.getText().trim();
	}

	private String leerNomGerente() {
		String res = null;
		return res = txtNombreEncargado.getText().trim() + " " + txtApellidoEncargado.getText().trim();
	}

	private String leerIdApelacion() {
		String res = null;
		return res = cboApelacion.getSelectedItem().toString();
	}

	private String leerPronApelacion() {
		String res = null;
		return res = txtPronunciamiento.getText().trim();
	}

	//METODOS AADICIONALES
	private void cargarCboApelacion() {
		ArrayList <Apelacion> list = apeDao.listarApelacion();
		
		cboApelacion.removeAllItems();
		cboApelacion.addItem("Seleccione...");
		
		for (Apelacion ape : list) {
			cboApelacion.addItem(ape.getCodApelacion());
		}
	}
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
	
}
