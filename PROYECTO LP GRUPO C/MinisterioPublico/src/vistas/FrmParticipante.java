package vistas;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Validaciones.Reguex;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.awt.event.ActionEvent;

import mantenimiento.*;
import utils.Tool;
import clases.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

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
	private JLabel lblEstado;
	private JButton btnBuscar;
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private PropuestaDAO propDao;
	private JButton btnNuevo;
	private JTextField txtEstado;
	private JPanel panleParticipante;
	private JLabel lblNewLabel;
	
	
	
	public static void main (String[] args) {
		FrmParticipante parti = new FrmParticipante();
		parti.setVisible(true);
	}
	
	public FrmParticipante() {
		
		setTitle("Registro de Participantes");
		setBounds(100,100,773,460);
		
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.lightGray);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		panleParticipante = new JPanel();
		panleParticipante.setOpaque(false);
		panleParticipante.setBackground(new Color(240, 240, 240));
		panleParticipante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panleParticipante.setBounds(137, 11, 599, 169);
		getContentPane().add(panleParticipante);
		panleParticipante.setLayout(null);
		
		txtEntidad = new JTextField();
		txtEntidad.setBounds(10, 81, 177, 20);
		panleParticipante.add(txtEntidad);
		txtEntidad.setColumns(10);
		
		lblEntidad = new JLabel("Nombre o Razon  social :");
		lblEntidad.setBounds(11, 66, 138, 14);
		panleParticipante.add(lblEntidad);
		
		lblRuc = new JLabel("RUC :");
		lblRuc.setBounds(219, 66, 92, 14);
		panleParticipante.add(lblRuc);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(10, 127, 139, 20);
		panleParticipante.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(10, 112, 92, 14);
		panleParticipante.add(lblTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(219, 127, 194, 20);
		panleParticipante.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(219, 112, 92, 14);
		panleParticipante.add(lblCorreo);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(219, 81, 154, 20);
		panleParticipante.add(txtRuc);
		txtRuc.setColumns(10);
		
		txtIdParticipante = new JTextField();
		txtIdParticipante.setBounds(10, 36, 114, 20);
		panleParticipante.add(txtIdParticipante);
		txtIdParticipante.setColumns(10);
		
		lblIdPedido = new JLabel("ID. Participante :");
		lblIdPedido.setBounds(10, 21, 116, 14);
		panleParticipante.add(lblIdPedido);
		
		btnBuscar = new JButton("BUSCAR PARTICIPANTE");
		btnBuscar.setBounds(134, 26, 162, 29);
		panleParticipante.add(btnBuscar);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(319, 36, 106, 20);
		panleParticipante.add(txtEstado);
		txtEstado.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(319, 21, 67, 14);
		panleParticipante.add(lblEstado);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(479, 80, 99, 23);
		panleParticipante.add(btnModificar);
		
		btnAgregar = new JButton("REGISTRAR");
		btnAgregar.setBounds(479, 35, 99, 23);
		panleParticipante.add(btnAgregar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(479, 126, 99, 23);
		panleParticipante.add(btnEliminar);
		btnEliminar.addActionListener(this);
		btnAgregar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnBuscar.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 205, 737, 214);
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
		cboPedido.addActionListener(this);
		cboPedido.setBounds(21, 26, 106, 22);
		getContentPane().add(cboPedido);
		
		lblPedido = new JLabel("ID. Pedido :");
		lblPedido.setBounds(22, 11, 139, 14);
		getContentPane().add(lblPedido);
		
		btnNuevo = new JButton("LIMPIAR");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(21, 59, 89, 23);
		getContentPane().add(btnNuevo);
		
		lblNewLabel = new JLabel("TABLA DE REGISTROS\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 184, 726, 23);
		getContentPane().add(lblNewLabel);
		
		pedDao = new PedidoDAO();
		partDao = new ParticipanteDAO();
		propDao = new PropuestaDAO();
		
		
		arranque();
		
	}
	private void arranque() {
		
		estado();
		cargarCboPedido();
		cargarTabla();
		correlativo();
		limpiar();
		
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == cboPedido) {
			actionPerformedCboPedido(e);
		}
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
	
	protected void actionPerformedCboPedido(ActionEvent e) {
		if (cboPedido.getSelectedIndex() != 0) {
			cboPedido.setEnabled(false);
		}
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		arranque();
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		String idPedido = leerIdPedido();
		String idParticipante = leerIdParticipante();
		String entidad = leerEntidad ();
		String ruc = leerRuc();
		String correo = leerCorreo();
		int telefono = leerTelefono ();
		String estado = leerEstado();
		
		
		if (idPedido==null||idParticipante==null||entidad==null||
				ruc==null||correo==null||
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
		String ruc = leerRuc();
		String correo = leerCorreo();
		int telefono = leerTelefono ();
		String estado = leerEstado();
		
		
		if (idPedido==null||idParticipante==null||entidad==null||
				ruc==null||correo==null||
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
		
		if (Tool.mensajeConfirmacion(this, "Seguro que quiere eliminar?")==0) {
			int ok = partDao.eliminarParticipante(idPedido, idParticipante);
			
			if(ok == 0) {
				Tool.mensajeError(this, "Error en eliminar!");
			}else {
				Tool.mensajeExito(this, "Se eliminó un participante");
				cargarTabla();
			}
			
		}else {
			Tool.mensajeError(this, "Operacion Cancelada");
		}
		
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		Participante part = partDao.buscarXIdParticipante(txtIdParticipante.getText().trim());
		
		if (part == null) {
			Tool.mensajeError(this, "El ID ingresado no se encuentra registrado");
		}else {
			
			cboPedido.setSelectedItem(part.getCodPedido());
			txtIdParticipante.setText(part.getCodParticipante());
			txtEntidad.setText(part.getEntidad());
			txtRuc.setText(part.getRuc());
			txtCorreo.setText(part.getCorreo());
			txtTelefono.setText(part.getTelefono() + "");
			txtEstado.setText((part.getEstado()));
			
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
		cargarCajas();
	}
	
	//METODOS DE ENTRADA 
	
	private String leerIdPedido() {
		String res = null;
		
		if (cboPedido.getSelectedIndex()==0) {
			Tool.mensajeError(this,"Eligo el ID del pedido en el cual se registrara al participante");
		}else {
			res = cboPedido.getSelectedItem().toString();
		}
		
		return res ;
	}

	private String leerIdParticipante() {
		String res = null;
		
		if (txtIdParticipante.getText().trim().length()==0) {
			Tool.mensajeError(this, "El campo del ID participante está vacío !");
			txtIdParticipante.requestFocus();
		}else if (txtIdParticipante.getText().trim().matches(Reguex.ID_PARTICIPANTE)){
			res = txtIdParticipante.getText().trim();
		}else {
			Tool.mensajeError(this, "ID inválido. Ejemp (PA002)");
		}
		
		return res ;
	}

	private String leerEntidad() {
		String res = null;
		
		if (txtEntidad.getText().trim().length()==0) {
			Tool.mensajeError(this, "El campo de entidad está vacío !");
			txtEntidad.requestFocus();
		}else if (txtEntidad.getText().trim().matches(Reguex.ENTIDAD_PARTICIPANTE)){
			res = txtEntidad.getText().trim();
		}else {
			Tool.mensajeError(this,"Entidad inválida. Ejemp (Entre 5 y 10 caracteres)");
		}
		
		return res ;
	}

	private String leerRuc() {
		String res = null;
		
		res = txtRuc.getText().trim();
		
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
		
		res = txtEstado.getText().toString();
		
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
		
		if (indice == -1) {
			Tool.mensajeError(this, "Posicionese dentro de la tabla");
		}else {
			
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
			txtEstado.setText((estado));
		}
		
		
	}
	private void correlativo () {
		
		@SuppressWarnings("resource")
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
	
	private void limpiar() {
		txtEstado.setEditable(false);
		txtEstado.setText("REGISTRADO");
		cboPedido.setEnabled(true);
		txtEntidad.setText("");
		txtRuc.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
	}
	
	private void estado() {
		
		ArrayList <Participante> listPart = partDao.listarParticipante();
		ArrayList <Propuesta> listProp = propDao.listarPropuestas();
		
		for (Propuesta prop : listProp) {
			
			for (Participante part : listPart) {
				
				if (prop.getCodParticipante().equals(part.getCodParticipante())) {
					
					part.setEstado("PROCESO");
					
					partDao.actualizarPartcipante(part);	
				}	
			}	
		}
	}
}
