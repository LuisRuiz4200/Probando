package vistas;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class FrmProyectoPronunciamientoApelacion extends JInternalFrame {
	
	private JLabel lblCodigo;
	private JTextField txtCodigo;
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
	private DefaultTableModel modelo;
	
	public static void main (String [] args) {
		FrmProyectoPronunciamientoApelacion pro = new FrmProyectoPronunciamientoApelacion ();
		pro.setVisible(true);
	}
	
	public FrmProyectoPronunciamientoApelacion () {
		
		setTitle("Proyecto de pronunciamiento (APELACION)");
		setBounds(100,100,731,449);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.lightGray);
		
		lblCodigo = new JLabel("ID documento");
		lblCodigo.setBounds(10, 11, 98, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(10, 30, 98, 20);
		getContentPane().add(txtCodigo);
		
		lblApelacion = new JLabel("ID Apelacion");
		lblApelacion.setBounds(118, 11, 107, 14);
		getContentPane().add(lblApelacion);
		
		cboApelacion = new JComboBox <Object>();
		cboApelacion.setBounds(118, 29, 107, 22);
		getContentPane().add(cboApelacion);
		
		txtNombreEncargado = new JTextField();
		txtNombreEncargado.setColumns(10);
		txtNombreEncargado.setBounds(10, 80, 170, 20);
		getContentPane().add(txtNombreEncargado);
		
		lblNombreEncargado = new JLabel("Nombre del gerente");
		lblNombreEncargado.setBounds(10, 61, 149, 14);
		getContentPane().add(lblNombreEncargado);
		
		txtApellidoEncargado = new JTextField();
		txtApellidoEncargado.setColumns(10);
		txtApellidoEncargado.setBounds(190, 80, 170, 20);
		getContentPane().add(txtApellidoEncargado);
		
		lblApellidoEncargado = new JLabel("Apellidos del gerente");
		lblApellidoEncargado.setBounds(190, 61, 149, 14);
		getContentPane().add(lblApellidoEncargado);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(235, 30, 137, 20);
		getContentPane().add(dcFecha);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(235, 11, 46, 14);
		getContentPane().add(lblFecha);
		
		txtConclusiones = new JEditorPane();
		txtConclusiones.setBounds(10, 125, 695, 252);
		getContentPane().add(txtConclusiones);
		
		lblConclusion = new JLabel("Conclusiones");
		lblConclusion.setBounds(10, 106, 98, 14);
		getContentPane().add(lblConclusion);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(527, 10, 98, 14);
		getContentPane().add(lblResultado);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(374, 80, 98, 20);
		getContentPane().add(txtDni);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(374, 61, 46, 14);
		getContentPane().add(lblDni);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID DOCUMENTO");
		modelo.addColumn("ID APELACION");
		modelo.addColumn("FECHA");
		modelo.addColumn("ENCARGADO");
		modelo.addColumn("DNI");
		modelo.addColumn("CONCLUSIONES");
		modelo.addColumn("RESULTADO");
		modelo.addColumn("S/. GARANTIA");
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(463, 385, 109, 23);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(596, 385, 109, 23);
		getContentPane().add(btnModificar);
		
		cboResultado = new JComboBox <Object>();
		cboResultado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Fundado", "No fundado"}));
		cboResultado.setBounds(527, 28, 98, 22);
		getContentPane().add(cboResultado);
		
		
		
	}
}
