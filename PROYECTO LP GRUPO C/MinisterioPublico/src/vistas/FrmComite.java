package vistas;

import java.awt.EventQueue;
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
import clases.Participante;
import clases.Pedido;
import mantenimiento.ComiteDAO;
import mantenimiento.PedidoDAO;
import utils.Tool;

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
		setBounds(100, 100, 763, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		txtIdMiembro = new JTextField();
		txtIdMiembro.setBounds(144, 42, 75, 20);
		contentPane.add(txtIdMiembro);
		txtIdMiembro.setColumns(10);
		
		lblNroPedido = new JLabel("ID Pedido:");
		lblNroPedido.setBounds(10, 14, 124, 14);
		contentPane.add(lblNroPedido);
		
		lblIdMiembro = new JLabel("ID Miembro del Comite:");
		lblIdMiembro.setBounds(10, 45, 124, 14);
		contentPane.add(lblIdMiembro);
		
		lblNomMiembro = new JLabel("Nombre:");
		lblNomMiembro.setBounds(10, 76, 124, 14);
		contentPane.add(lblNomMiembro);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 111, 124, 14);
		contentPane.add(lblApellido);
		
		lblFuncion = new JLabel("Funcion/Cargo:");
		lblFuncion.setBounds(319, 42, 86, 20);
		contentPane.add(lblFuncion);
		
		lblDni = new JLabel("Dni: ");
		lblDni.setBounds(319, 14, 86, 14);
		contentPane.add(lblDni);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(this);
		scrollPane.setBounds(10, 154, 727, 198);
		contentPane.add(scrollPane);
		
		tbComite = new JTable();
		tbComite.addMouseListener(this);
		scrollPane.setViewportView(tbComite);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(478, 107, 117, 23);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(611, 107, 108, 23);
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
		txtNombre.setBounds(144, 73, 147, 20);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(144, 108, 147, 20);
		contentPane.add(txtApellido);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.setBounds(144, 9, 102, 22);
		contentPane.add(cboPedido);
		
		txtDni = new JTextField();
		txtDni.setBounds(415, 11, 117, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtFuncion = new JTextField();
		txtFuncion.setBounds(415, 42, 117, 20);
		contentPane.add(txtFuncion);
		txtFuncion.setColumns(10);
		
		lblDependencia = new JLabel("Dependencia:");
		lblDependencia.setBounds(319, 76, 86, 20);
		contentPane.add(lblDependencia);
		
		txtDependencia = new JTextField();
		txtDependencia.setColumns(10);
		txtDependencia.setBounds(415, 73, 117, 20);
		contentPane.add(txtDependencia);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(648, 10, 89, 23);
		contentPane.add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(648, 41, 89, 23);
		contentPane.add(btnNuevo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(229, 41, 68, 23);
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
		
		res = txtDependencia.getText().trim();
		
		return res ;
	}

	private String leerFuncion() {
	    String res = null;
		
		res = txtFuncion.getText().trim();
		
		return res ;
	}

	private String leerDni() {
        String res = null;
		
		res = txtDni.getText().trim();
		
		return res ;
	}

	private String leerApellido() {
        String res = null;
		
		res = txtApellido.getText().trim();
		
		return res ;
	}

	private String leerNombre() {
        String res = null;
		
		res = txtNombre.getText().trim();
		
		return res ;
	}

	private String leerIdMiembro() {
        String res = null;
		
		res = txtIdMiembro.getText().trim();
		
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
