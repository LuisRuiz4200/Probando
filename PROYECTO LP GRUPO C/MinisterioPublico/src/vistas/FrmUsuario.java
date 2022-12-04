package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Validaciones.Reguex;
import clases.TipoUsuario;
import clases.Usuario;
import mantenimiento.TipoUsuarioDAO;
import mantenimiento.UsuarioDAO;
import utils.Tool;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmUsuario extends JInternalFrame implements ActionListener, MouseListener{
	private JLabel lblCodigo;
	private JTextField txtCodigoUsuario;
	private JTextField txtNombreUsuario;
	private JLabel lblNombre;
	private JTextField txtApellidoUsuario;
	private JLabel lblApellido;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JTextField txtClave;
	private JLabel lblClave;
	private JDateChooser dcFechaNac;
	private JLabel lblFechaNac;
	private JTextField txtEstado;
	private JLabel lblEstado;
	private JLabel lblTipoUsuario;
	private JComboBox <Object>cboTipoUsuario;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private DefaultTableModel model;
	private UsuarioDAO usuarioDao;
	private TipoUsuarioDAO tipoUsuarioDao;
	
	
	public static void main(String [] args) {
		
		FrmUsuario form = new FrmUsuario();
		form.setVisible(true);
		
	}
	
	public FrmUsuario() {
		getContentPane().setBackground(new Color(192, 192, 192));
		
		setTitle("USUARIO");
		setBounds(100,100,696,432);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 73, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigoUsuario = new JTextField();
		txtCodigoUsuario.setBounds(10, 32, 78, 20);
		getContentPane().add(txtCodigoUsuario);
		txtCodigoUsuario.setColumns(10);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(98, 32, 156, 20);
		getContentPane().add(txtNombreUsuario);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(98, 11, 73, 14);
		getContentPane().add(lblNombre);
		
		txtApellidoUsuario = new JTextField();
		txtApellidoUsuario.setColumns(10);
		txtApellidoUsuario.setBounds(264, 32, 156, 20);
		getContentPane().add(txtApellidoUsuario);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(264, 11, 73, 14);
		getContentPane().add(lblApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(10, 137, 156, 20);
		getContentPane().add(txtUsuario);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 116, 87, 14);
		getContentPane().add(lblUsuario);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(176, 137, 156, 20);
		getContentPane().add(txtClave);
		
		lblClave = new JLabel("Clave");
		lblClave.setBounds(176, 116, 87, 14);
		getContentPane().add(lblClave);
		
		dcFechaNac = new JDateChooser();
		dcFechaNac.setBounds(10, 85, 129, 20);
		getContentPane().add(dcFechaNac);
		
		lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setBounds(10, 64, 78, 14);
		getContentPane().add(lblFechaNac);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(545, 32, 101, 28);
		getContentPane().add(txtEstado);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(545, 11, 87, 14);
		getContentPane().add(lblEstado);
		
		lblTipoUsuario = new JLabel("Tipo");
		lblTipoUsuario.setBounds(159, 63, 87, 14);
		getContentPane().add(lblTipoUsuario);
		
		cboTipoUsuario = new JComboBox<Object>();
		cboTipoUsuario.setBounds(159, 83, 156, 22);
		getContentPane().add(cboTipoUsuario);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 660, 214);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(533, 136, 113, 23);
		getContentPane().add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(533, 112, 113, 23);
		getContentPane().add(btnModificar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(379, 85, 113, 23);
		getContentPane().add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(533, 85, 113, 23);
		getContentPane().add(btnRegistrar);
		
		model = new DefaultTableModel ();
		model.addColumn("CODIGO");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("USUARIO");
		model.addColumn("CLAVE");
		model.addColumn("FECHA NAC.");
		model.addColumn("TIPO");
		model.addColumn("ESTADO");
		table.setModel(model);
		
		
		usuarioDao =  new UsuarioDAO();
		tipoUsuarioDao = new TipoUsuarioDAO();
		
		arranque();
		
	}
	
	private void arranque() {
		
		limpiar();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
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
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
		int codUsuario = leerCodigoUsuario();
		String nombreUsuario=leerNombreUsuario();
		String apellidoUsuario = leerApellidoUsuario();
		String userUsuario = leerUserUsario();
		String claveUsuario = leerClaveUsuario();
		String fechaNacUsuario = leerFechaNacUsuario();
		int tipoUsuario = leerTipoUsuario();
		String estadoUsuario = leerEstadoUsuario();
		
		
		if (codUsuario == -1 || nombreUsuario ==null || apellidoUsuario ==null || userUsuario ==null
				 || claveUsuario ==null || fechaNacUsuario ==null || tipoUsuario ==-1
				 || estadoUsuario ==null ) {
			Tool.mensajeError(this, "Error de campos, verificar !");
			return;
		}else {
			
			Usuario user = new Usuario (codUsuario,nombreUsuario,apellidoUsuario,userUsuario,claveUsuario,
					fechaNacUsuario,tipoUsuario,estadoUsuario);
			
			int ok = usuarioDao.regitrarUsuario(user);
			
			if(ok==0) {
				Tool.mensajeError(this, "Registro rechazado");
			}else {
				Tool.mensajeExito(this, "Registrado correctamente !");
				cargarTabla();
				
			}
			
		}
		
	}


	protected void actionPerformedBtnModificar(ActionEvent e) {
		int codUsuario = leerCodigoUsuario();
		String nombreUsuario=leerNombreUsuario();
		String apellidoUsuario = leerApellidoUsuario();
		String userUsuario = leerUserUsario();
		String claveUsuario = leerClaveUsuario();
		String fechaNacUsuario = leerFechaNacUsuario();
		int tipoUsuario = leerTipoUsuario();
		String estadoUsuario = leerEstadoUsuario();
		
		
		if (codUsuario == -1 || nombreUsuario ==null || apellidoUsuario ==null || userUsuario ==null
				 || claveUsuario ==null || fechaNacUsuario ==null || tipoUsuario ==-1
				 || estadoUsuario ==null ) {
			Tool.mensajeError(this, "Error de campos, verificar !");
			return;
		}else {
			
			Usuario user = new Usuario (codUsuario,nombreUsuario,apellidoUsuario,userUsuario,claveUsuario,
					fechaNacUsuario,tipoUsuario,estadoUsuario);
			
			int ok = usuarioDao.ModificarUsuario(user);
			
			if(ok==0) {
				Tool.mensajeError(this, "Actualizacion fallida");
			}else {
				Tool.mensajeExito(this, "Se actualizo correctamente!");
				cargarTabla();
			}
			
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int codUsuario = leerCodigoUsuario();
		
		
		if (codUsuario == -1 ) {
			Tool.mensajeError(this, "Error de campos, verificar !");
			return;
		}else {
			
			int ok = usuarioDao.eliminarUsuario(codUsuario);
			
			if(ok==0) {
				Tool.mensajeError(this, "Fallo al intento de eliminación");
			}else {
				Tool.mensajeExito(this, "Se eliminó correctamentess !");
				cargarTabla();
			}
			
		}
	}
	
	//METODOS DE ENTRADA
	
	private int leerCodigoUsuario() {
		int res = -1;
		
		if (txtCodigoUsuario.getText().trim().length()==0){
			Tool.mensajeError(this,"Campo codigo sin llenar");
			txtCodigoUsuario.requestFocus();
		}else {
			res = Integer.parseInt(txtCodigoUsuario.getText().trim());
		}
		return res;
	}

	private String leerNombreUsuario() {
		String res = null;
		
		if(txtNombreUsuario.getText().trim().length()==0) {
			Tool.mensajeError(this, "Coloque los nombres del usuario");
			txtNombreUsuario.requestFocus();
		}else if (txtNombreUsuario.getText().trim().matches(Reguex.NOMBRE_USUARIO)) {
			res = txtNombreUsuario.getText();
		}else {
			Tool.mensajeError(this, "Nombre incorrecto. Caracteres entre 3 y 25");
		}
		
		return res;
	}

	private String leerApellidoUsuario() {
		String res = null;
		
		if(txtApellidoUsuario.getText().trim().length()==0) {
			Tool.mensajeError(this, "Coloque los apellidos del usuario");
			txtApellidoUsuario.requestFocus();
		}else if (txtApellidoUsuario.getText().trim().matches(Reguex.APELLIDO_USUARIO)) {
			res = txtApellidoUsuario.getText();
		}else {
			Tool.mensajeError(this, "Apellido incorrecto. Caracteres entre 3 y 25");
		}
		
		return res;
	}

	private String leerUserUsario() {
		String res = null;
		
		if(txtUsuario.getText().trim().length()==0) {
			Tool.mensajeError(this, "Escriba un usuario");
			txtUsuario.requestFocus();
		}else if (txtUsuario.getText().trim().matches(Reguex.USER_USUARIO)) {
			res = txtUsuario.getText();
		}else {
			Tool.mensajeError(this, "User incorrecto. Letras y numeros de 4 a 15 caracteres");
		}
		
		return res;
	}

	private String leerClaveUsuario() {
		String res = null;
	
		if(txtClave.getText().trim().length()==0) {
			Tool.mensajeError(this, "Escriba una clave");
			txtClave.requestFocus();
		}else if (txtClave.getText().trim().matches(Reguex.USER_USUARIO)) {
			res = txtClave.getText();
		}else {
			Tool.mensajeError(this, "Clave incorrecta. Letras y numeros de 4 a 8 caracteres ");
		}
				 
		return res;
	}

	private String leerFechaNacUsuario() {
		String res = null;
		
		if (dcFechaNac.getDate()==null) {
			Tool.mensajeError(this, "El campo de la fecha esta vacía");
			dcFechaNac.requestFocus();
		}else {
			res =Tool.sdf.format(dcFechaNac.getDate()).toString();
		}
		
		
		
		return res;
	}

	private int leerTipoUsuario() {
		int res = -1;
		
		if (cboTipoUsuario.getSelectedIndex()==0) {
			Tool.mensajeError(this,"Eliga un tipo de usuario");
		}else {
			res = cboTipoUsuario.getSelectedIndex();
		}
		
		return res;
	}

	private String leerEstadoUsuario() {
		String res = null;
		
		if (txtEstado.getText().trim().length()==0){
			Tool.mensajeError(this, "Campo del estado esta vacío !");
			txtEstado.requestFocus();
		}else {
			res = txtEstado.getText();
		}
		
		
		return res;
	}
	
	//METODOS ADICIONALES
	
	
	private void cargarTabla() {
		ArrayList <Usuario> listUser = usuarioDao.listarUsuario();
		
		model.setRowCount(0);
		
		for(Usuario user : listUser ) {
			Object[] x= {
					user.getCodigoUsuario(),
					user.getNombreUsuario(),
					user.getApellidoUsuario(),
					user.getUserUsuario(),
					user.getClaveUsuario(),
					user.getFechaNacUsuario(),
					user.getTipoUsuario(),
					user.getEstadoUsario()
			};
			
			model.addRow(x);
		}
		
	}
	
	private void limpiar () {
		
		cargarCboTipoUsuario();
		txtCodigoUsuario.setEditable(false);
		correlativo();
		cargarTabla();
		txtNombreUsuario.setText("");
		txtApellidoUsuario.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		dcFechaNac.setDate(new Date());
		txtEstado.setText("REGISTRADO");
		
	}
	
	private void cargarCboTipoUsuario() {
		
		ArrayList<TipoUsuario> listTipoUser = tipoUsuarioDao.listarTipoUsuario();
		
		cboTipoUsuario.removeAllItems();
		cboTipoUsuario.addItem("SELECCIONE..");
		
		for (TipoUsuario tipoUser : listTipoUser) {
			
			cboTipoUsuario.addItem(tipoUser.getDesTipoUser());
			
		}
		
	}
	private void correlativo () {
		
		
		ArrayList<Usuario> listUser = usuarioDao.listarUsuario();
		
		if (listUser.size()==0) {
			txtCodigoUsuario.setText("1");
		}else {
			int codigo= listUser.get(listUser.size()-1).getCodigoUsuario()+1;
		
			txtCodigoUsuario.setText("" + codigo);
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTable(MouseEvent e) {
		cargarUsuario();
	}
	
	
	private void cargarUsuario() {
		
		int indice = table.getSelectedRow();
		
		int codigo = Integer.parseInt(table.getValueAt(indice, 0).toString());
		
		Usuario user = usuarioDao.buscarXIdUSuario(codigo);
		
		txtCodigoUsuario.setText("" + user.getCodigoUsuario());
		txtNombreUsuario.setText(user.getNombreUsuario());
		txtApellidoUsuario.setText(user.getApellidoUsuario());
		try {
			dcFechaNac.setDate(Tool.sdf.parse(user.getFechaNacUsuario()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cboTipoUsuario.setSelectedIndex(user.getTipoUsuario());
		txtUsuario.setText(user.getUserUsuario());
		txtClave.setText(user.getClaveUsuario());
		txtEstado.setText(user.getEstadoUsario());
	}
}
