package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Comite;
import clases.Pedido;
import mantenimiento.ComiteDAO;
import mantenimiento.PedidoDAO;
import utils.Tool;
import Validaciones.Reguex;
@SuppressWarnings("serial")
public class FrmComite extends JInternalFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtIdMiembro;
	private JLabel lblNroPedido;
	private JLabel lblIdMiembro;
	private JLabel lblNomMiembro;
	private JLabel lblApellido;
	private JLabel lblFuncion;
	private JLabel lblDni;
	private JTable tbComite;
	private JScrollPane scrollPane;
	private JButton btnGuardar;
	private JButton btnModificar;
	private DefaultTableModel model;
	
	private PedidoDAO pedDao;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JComboBox<Object> cboPedido;
	private JTextField txtDni;
	private JTextField txtFuncion;
	private JLabel lblDependencia;
	private JTextField txtDependencia;

	private ComiteDAO comiDao;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnBuscar;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmComite frame = new FrmComite();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmComite() {
		setTitle("Miembro del CEP");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		txtIdMiembro = new JTextField();
		txtIdMiembro.setBounds(294, 10, 110, 20);
		contentPane.add(txtIdMiembro);
		txtIdMiembro.setColumns(10);
		
		lblNroPedido = new JLabel("ID Pedido:");
		lblNroPedido.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNroPedido.setBounds(20, 14, 66, 14);
		contentPane.add(lblNroPedido);
		
		lblIdMiembro = new JLabel("ID Miembro :");
		lblIdMiembro.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblIdMiembro.setBounds(217, 14, 75, 14);
		contentPane.add(lblIdMiembro);
		
		lblNomMiembro = new JLabel("Nombres del Miembro:");
		lblNomMiembro.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomMiembro.setBounds(20, 55, 124, 14);
		contentPane.add(lblNomMiembro);
		
		lblApellido = new JLabel("Apellidos del Miembro:");
		lblApellido.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblApellido.setBounds(20, 104, 124, 14);
		contentPane.add(lblApellido);
		
		lblFuncion = new JLabel("Funcion/Cargo:");
		lblFuncion.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblFuncion.setBounds(217, 101, 86, 20);
		contentPane.add(lblFuncion);
		
		lblDni = new JLabel("Documento de Identidad : ");
		lblDni.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblDni.setBounds(217, 55, 147, 14);
		contentPane.add(lblDni);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(this);
		scrollPane.setBounds(10, 168, 727, 237);
		contentPane.add(scrollPane);
		
		tbComite = new JTable();
		tbComite.addMouseListener(this);
		scrollPane.setViewportView(tbComite);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(597, 28, 100, 23);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(597, 72, 100, 23);
		contentPane.add(btnModificar);
		
		// crear columnas de la tabla
	    // Instanciar un objeto para la estructura de la tabla
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ID MIEMBRO");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("DNI");
		model.addColumn("FUNCION");
		model.addColumn("DEPENDENCIA");
		tbComite.setModel(model);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(20, 73, 147, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(20, 125, 147, 20);
		contentPane.add(txtApellido);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.setBounds(85, 9, 117, 22);
		contentPane.add(cboPedido);
		
		txtDni = new JTextField();
		txtDni.setBounds(217, 73, 137, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtFuncion = new JTextField();
		txtFuncion.setBounds(217, 125, 137, 20);
		contentPane.add(txtFuncion);
		txtFuncion.setColumns(10);
		
		lblDependencia = new JLabel("Dependencia:");
		lblDependencia.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblDependencia.setBounds(404, 52, 86, 20);
		contentPane.add(lblDependencia);
		
		txtDependencia = new JTextField();
		txtDependencia.setColumns(10);
		txtDependencia.setBounds(404, 73, 117, 20);
		contentPane.add(txtDependencia);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(597, 110, 100, 23);
		contentPane.add(btnEliminar);
		
		btnNuevo = new JButton("LIMPIAR");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(416, 122, 89, 23);
		contentPane.add(btnNuevo);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(435, 9, 86, 23);
		contentPane.add(btnBuscar);
		
		pedDao = new PedidoDAO();
		comiDao = new ComiteDAO();
		
		arranque();
	}

	private void arranque() {
		cargarCboPedido();
		correlativo();
		cargarTabla();
		limpiar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		String idPedido = leerIdPedido();
		String idMiembro = leerIdMiembro();
		String nombre = leerNombre();
		String apellido = leerApellido();
		String dni = leerDni();
		String funcion = leerFuncion();
		String depen = leerDependencia();
		
		if (idPedido == null || idMiembro == null || nombre == null || 
			apellido == null || dni == null || funcion == null ||
			depen == null ) {
			
			return;
			
		} else {
			
			Comite com = new Comite (
					
					idPedido, idMiembro, nombre, apellido, dni, funcion, depen
					);
			
			int ok  = comiDao.registrarComite(com);
			
			if (ok == 0) {
				Tool.mensajeError(this, "Error de registro");
			}else {
				Tool.mensajeExito(this, "Registro exitoso");
				cargarTabla();
				limpiar();
				correlativo();
			}
		}
		
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
	
	String idPedido = leerIdPedido();
	String idMiembro = leerIdMiembro();
	String nombre = leerNombre();
	String apellido = leerApellido();
	String dni = leerDni();
	String funcion = leerFuncion();
	String depen = leerDependencia();
	
	if (idPedido == null || idMiembro == null || nombre == null || 
		apellido == null || dni == null || funcion == null ||
		depen == null ) {
		
		return;
		
	} else {
		
		Comite com = new Comite (
				
				idPedido, idMiembro, nombre, apellido, dni, funcion, depen
				);
		
		int ok  = comiDao.actualizarComite(com);
		
		if (ok == 0) {
			Tool.mensajeError(this, "Error de Update");
		}else {
			Tool.mensajeExito(this, "Registro actualizado");
			cargarTabla();
			limpiar();
			correlativo();
		}
	  }
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		String idPedido =  leerIdPedido();
		String idMiembro = leerIdMiembro();
		
		int ok = comiDao.eliminarMiembro (idPedido, idMiembro);
		
		if(ok == 0) {
			Tool.mensajeError(this, "Error en eliminar!");
		}else {
			Tool.mensajeExito(this, "Se eliminó un participante");
			cargarTabla();
		}
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		ArrayList <Comite> list = comiDao.buscarXIdMiembro(leerIdMiembro());
		
		if (list.size()==0) {
			Tool.mensajeError(this, "El ID ingresado no se encuentra registrado");
		}else {
			
			for (Comite com : list ) {
				cboPedido.setSelectedItem(com.getCodPedido());
				txtIdMiembro.setText(com.getCodMiembro());
				txtNombre.setText(com.getNombMiembro());
				txtApellido.setText(com.getApeMiembro());
				txtDni.setText(com.getDni());
				txtFuncion.setText(com.getFuncion() + "");
				txtDependencia.setText(com.getDependencia());
			}
			
		}
			
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
	     arranque();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbComite) {
			mouseClickedTbComite(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	private void mouseClickedTbComite(MouseEvent e) {
		cargarDatos();
	}

	//METODOS DE ENTRADA
	private String leerDependencia() {
		String res = null;
    	if(txtDependencia.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar la dependencia del miembro ");
			txtDependencia.requestFocus();
		}else if (txtDependencia.getText().trim().matches(Reguex.DEPENDENCIA_CEP)) {
			res = txtDependencia.getText().trim();
		}else {
			Tool.mensajeError(this," Dependencia del miembro no valida ");
			txtDependencia.setText("");
			txtDependencia.requestFocus();
		}
		return res ;
	}

	private String leerFuncion() {
		String res = null;
    	if(txtFuncion.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar la funcion del Miembro ");
			txtFuncion.requestFocus();
		}else if (txtFuncion.getText().trim().matches(Reguex.FUNCION_CEP)) {
			res = txtFuncion.getText().trim();
		}else {
			Tool.mensajeError(this," Funcion del miembro no valida ");
			txtFuncion.setText("");
			txtFuncion.requestFocus();
		}
		return res ;
	}

	private String leerDni() {
		 String res = null;
	    	if(txtDni.getText().trim().length() == 0) {
				Tool.mensajeError(this," Ingresar el DNI ");
				txtDni.requestFocus();
			}else if (txtDni.getText().trim().matches(Reguex.DNI_CEP)) {
				res = txtDni.getText().trim();
			}else {
				Tool.mensajeError(this," Ingresar DNI correctamente ");
				txtDni.setText("");
				txtDni.requestFocus();
			}
			return res ;
	}

	private String leerApellido() {
	    String res = null;
    	if(txtApellido.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar el Nombre del miembro del Comite");
			txtApellido.requestFocus();
		}else if (txtApellido.getText().trim().matches(Reguex.APELLIDO_CEP)) {
			res = txtApellido.getText().trim();
		}else {
			Tool.mensajeError(this," Ingresar su Apellido correctamente ");
			txtApellido.setText("");
			txtApellido.requestFocus();
		}
		return res ;
	}

	private String leerNombre() {
        String res = null;
    	if(txtNombre.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar el Nombre del miembro del Comite");
			txtNombre.requestFocus();
		}else if (txtNombre.getText().trim().matches(Reguex.NOMBRE_CEP)) {
			res = txtNombre.getText().trim();
		}else {
			Tool.mensajeError(this," Ingresar su Nombre correctamente ");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
		
		return res ;
	}

	private String leerIdMiembro() {
        String res = null;
		if(txtIdMiembro.getText().trim().length() == 0) {
			Tool.mensajeError(this," Ingresar el Id Miembro de Comite");
			txtIdMiembro.requestFocus();
		}else if (txtIdMiembro.getText().trim().matches(Reguex.ID_CEP)) {
			res = txtIdMiembro.getText().trim();
		}else {
			Tool.mensajeError(this," Ingresar Id Miembro Valido Ej: MC001 ");
			txtIdMiembro.setText("");
			txtIdMiembro.requestFocus();
		}
		
		return res ;
	}

	private String leerIdPedido() {
        String res = null;
		
		res = cboPedido.getSelectedItem().toString();
		
		return res ;
	}
	
	//METODOS ADICIONALES 
	
	private void cargarTabla() {
        ArrayList<Comite> list = comiDao.listarComite();
		
		model.setRowCount(0);
		
		for (Comite com: list) {
			
			Object [] x = {
					com.getCodPedido(),
					com.getCodMiembro(),
					com.getNombMiembro(),
					com.getApeMiembro(),
					com.getDni(),
					com.getFuncion(),
					com.getDependencia()
			};
			
			model.addRow(x);
		}
	}

	private void cargarCboPedido() {
        ArrayList<Pedido> list = pedDao.listarPedido();
		
		cboPedido.removeAllItems();
		cboPedido.addItem("SELECCIONE...");
		
		for (Pedido ped : list) {
			
			cboPedido.addItem(ped.getCodigo());
			
		}
		
	}
	
	private void cargarDatos() {
		
        int indice = tbComite.getSelectedRow();
		
		String idPedido = tbComite.getValueAt(indice, 0).toString();
		String idMiembro = tbComite.getValueAt(indice, 1).toString();
		String nombMiembro = tbComite.getValueAt(indice, 2).toString();
		String apeMiembro = tbComite.getValueAt(indice, 3).toString();
		String dni  = tbComite.getValueAt(indice, 4).toString();
		String funcion = tbComite.getValueAt(indice, 5).toString();
		String dependencia = tbComite.getValueAt(indice, 6).toString();
		
		cboPedido.setSelectedItem(idPedido);
		txtIdMiembro.setText(idMiembro);
		txtNombre.setText(nombMiembro);
		txtApellido.setText(apeMiembro);
		txtDni.setText(dni);
		txtFuncion.setText(funcion);
		txtDependencia.setText(dependencia);
		
		;
		
	}
	
	private void correlativo() {
	    
		@SuppressWarnings("resource")
	    Formatter ft = new Formatter();
	    
	    ArrayList <Comite> list = comiDao.listarComite();
		if (list.size()==0) {
			txtIdMiembro.setText("MC001");
		}else {
			String idComite = list.get(list.size()-1).getCodMiembro();
			
			int n =Integer.parseInt(idComite.substring(2))+1;
			
			txtIdMiembro.setText("");
			txtIdMiembro.setText("MC"+ft.format("%03d", n));
		}
		
	}
	
	private void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtFuncion.setText("");
		txtDependencia.setText("");
		cboPedido.setSelectedIndex(0);
	
		
	}

}
