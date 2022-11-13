package vistas;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.awt.event.ActionEvent;

import mantenimiento.*;
import utils.Tool;
import clases.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmParticipante extends JInternalFrame implements ActionListener, MouseListener{
	private JTextField txtEntidad;
	private JLabel lblEntidad;
	private JTextField txtRuc;
	private JLabel lblRuc;
	private JTextField txtTelefono;
	private JLabel lblTelefono;
	private JTextField txtCorreo;
	private JLabel lblCorreo;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JComboBox <Object> cboPedido;
	private JLabel lblPedido;
	private JTextField txtIdParticipante;
	private JLabel lblIdPedido;
	private JComboBox<Object> cboEstado;
	private JLabel lblEstado;
	private JButton btnBuscar;
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	
	
	
	public static void main (String[] args) {
		FrmParticipante parti = new FrmParticipante();
		parti.setVisible(true);
	}
	
	public FrmParticipante() {
		
		setTitle("Participantes");
		setBounds(100,100,773,422);
		
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.lightGray);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		txtEntidad = new JTextField();
		txtEntidad.setColumns(10);
		txtEntidad.setBounds(21, 69, 177, 20);
		getContentPane().add(txtEntidad);
		
		lblEntidad = new JLabel("Entidad");
		lblEntidad.setBounds(22, 54, 67, 14);
		getContentPane().add(lblEntidad);
		
		txtRuc = new JTextField();
		txtRuc.setColumns(10);
		txtRuc.setBounds(223, 69, 114, 20);
		getContentPane().add(txtRuc);
		
		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(224, 54, 92, 14);
		getContentPane().add(lblRuc);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(21, 115, 114, 20);
		getContentPane().add(txtTelefono);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(21, 100, 92, 14);
		getContentPane().add(lblTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(181, 115, 204, 20);
		getContentPane().add(txtCorreo);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(182, 100, 92, 14);
		getContentPane().add(lblCorreo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(422, 114, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(626, 114, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(527, 114, 89, 23);
		getContentPane().add(btnModificar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 726, 219);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID PEDIDO");
		modelo.addColumn("ID PARTICIPANTE");
		modelo.addColumn("ENTIDAD");
		modelo.addColumn("RUC");
		modelo.addColumn("CORREO");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("ESTADO");
		table.setModel(modelo);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.setBounds(21, 26, 106, 22);
		getContentPane().add(cboPedido);
		
		lblPedido = new JLabel("ID. Pedido");
		lblPedido.setBounds(22, 11, 139, 14);
		getContentPane().add(lblPedido);
		
		txtIdParticipante = new JTextField();
		txtIdParticipante.setColumns(10);
		txtIdParticipante.setBounds(158, 26, 114, 20);
		getContentPane().add(txtIdParticipante);
		
		lblIdPedido = new JLabel("ID. Participante");
		lblIdPedido.setBounds(158, 11, 116, 14);
		getContentPane().add(lblIdPedido);
		
		cboEstado = new JComboBox<Object>(new Object[]{});
		cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"REGISTRADO", "PROCESO", "DISCONFORME", "CONCLUIDO"}));
		cboEstado.setBounds(422, 26, 106, 20);
		getContentPane().add(cboEstado);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(423, 11, 67, 14);
		getContentPane().add(lblEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(278, 26, 86, 23);
		getContentPane().add(btnBuscar);
		
		pedDao = new PedidoDAO();
		partDao = new ParticipanteDAO();
		
		
		arranque();
		
	}
	private void arranque() {
		cargarCboPedido();
		cargarTabla();
		correlativo();
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		String idPedido = leerIdPedido();
		String idParticipante = leerIdParticipante();
		String entidad = leerEntidad ();
		int ruc = leerRuc();
		String correo = leerCorreo();
		int telefono = leerTelefono ();
		String estado = leerEstado();
		
		
		if (idPedido==null||idParticipante==null||entidad==null||
				ruc==-1||correo==null||
				telefono==-1||estado==null) {
			
			return;
			
		}else {
			
			Participante part = new Participante (
					
					idPedido, idParticipante, entidad, ruc, correo,telefono,estado
					);
			
			int ok =partDao.registrarParticipante(part);
			
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
		String idParticipante = leerIdParticipante();
		String entidad = leerEntidad ();
		int ruc = leerRuc();
		String correo = leerCorreo();
		int telefono = leerTelefono ();
		String estado = leerEstado();
		
		
		if (idPedido==null||idParticipante==null||entidad==null||
				ruc==-1||correo==null||
				telefono==-1||estado==null) {
			
			return;
			
		}else {
			
			Participante part = new Participante (
					
					idPedido, idParticipante, entidad, ruc, correo,telefono,estado
					);
			
			int ok =partDao.actualizarPartcipante(part);
			
			if (ok == 0) {
				Tool.mensajeError(this, "Error de update");
			}else {
				Tool.mensajeExito(this, "Actualizacion exitosa");
				correlativo();
				cargarTabla();
			}
			
		}
		
	}
		
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		String idPedido =  leerIdPedido();
		String idParticipante = leerIdParticipante();
		
		int ok = partDao.eliminarParticipante(idPedido, idParticipante);
		
		if(ok == 0) {
			Tool.mensajeError(this, "Error en eliminar!");
		}else {
			Tool.mensajeExito(this, "Se elimin� un participante");
			cargarTabla();
		}
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
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
		cargarCajas();
	}
	
	//METODOS DE ENTRADA 
	
	private String leerIdPedido() {
		String res = null;
		
		res = cboPedido.getSelectedItem().toString();
		
		return res ;
	}

	private String leerIdParticipante() {
		String res = null;
		
		res = txtIdParticipante.getText().trim();
		
		return res ;
	}

	private String leerEntidad() {
		String res = null;
		
		res = txtEntidad.getText().trim();
		
		return res ;
	}

	private int leerRuc() {
		int res = -1;
		
		res = Integer.parseInt(txtRuc.getText().trim());
		
		return res ;
	}

	private String leerCorreo() {
		String res = null;
		
		res = txtCorreo.getText().trim();
		
		return res ;
	}

	private int leerTelefono() {
		int res = -1;
		
		res = Integer.parseInt(txtTelefono.getText().trim());
		
		return res ;
	}

	private String leerEstado() {
		String res = null;
		
		res = cboEstado.getSelectedItem().toString();
		
		return res ;
	}
	
	
	//METODOS ADICIONALES
	
	private void cargarCboPedido() {
		ArrayList<Pedido> list = pedDao.listarPedido();
		
		cboPedido.removeAllItems();
		cboPedido.addItem("SELECCIONE...");
		
		for (Pedido ped : list) {
			
			cboPedido.addItem(ped.getCodigo());
			
		}
		
	}
	
	private void cargarTabla () {
		
		ArrayList<Participante> list = partDao.listarParticipante();
		
		modelo.setRowCount(0);
		
		for (Participante part: list) {
			
			Object [] x = {
					part.getCodPedido(),
					part.getCodParticipante(),
					part.getEntidad(),
					part.getRuc(),
					part.getCorreo(),
					part.getTelefono(),
					part.getEstado()
			};
			
			modelo.addRow(x);
		}
		
	}
	
	private void cargarCajas() {
		
		int indice = table.getSelectedRow();
		
		String idPedido = table.getValueAt(indice, 0).toString();
		String idParticipante = table.getValueAt(indice, 1).toString();
		String entidad = table.getValueAt(indice, 2).toString();
		String ruc = table.getValueAt(indice, 3).toString();
		String correo = table.getValueAt(indice, 4).toString();
		String telefono = table.getValueAt(indice, 5).toString();
		String estado = table.getValueAt(indice, 6).toString();
		
		
		cboPedido.setSelectedItem(idPedido);
		txtIdParticipante.setText(idParticipante);
		txtEntidad.setText(entidad);
		txtRuc.setText(ruc);
		txtCorreo.setText(correo);
		txtTelefono.setText(telefono);
		cboEstado.setSelectedItem(estado);
		
	}
	private void correlativo () {
		
		Formatter ft = new Formatter();
		
		ArrayList <Participante> list = partDao.listarParticipante();
		
		if (list.size()==0) {
			txtIdParticipante.setText("PA001");
		}else {
			String idParticipante = list.get(list.size()-1).getCodParticipante();
			
			int n =Integer.parseInt(idParticipante.substring(3))+1;
			
			txtIdParticipante.setText("");
			txtIdParticipante.setText("PA"+ft.format("%03d", n));
		}
		
	}
	
	
}
