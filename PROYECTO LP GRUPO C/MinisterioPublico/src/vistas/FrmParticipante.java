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
	private JLabel lblPedido;
	private  JTextField txtIdParticipante;
	private JLabel lblIdPedido;
	private JLabel lblEstado;
	private JButton btnBuscar;
	private ComiteDAO cepDao;
	private ParticipanteDAO partDao;
	private PropuestaDAO propDao;
	private JButton btnNuevo;
	private JTextField txtEstado;
	private JPanel panleParticipante;
	private JLabel lblNewLabel;
	private JButton btnBuscarPedido;
	public static JTextField txtIdPedido;
	
	
	
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
		panleParticipante.setBounds(159, 11, 588, 114);
		getContentPane().add(panleParticipante);
		panleParticipante.setLayout(null);
		
		txtEntidad = new JTextField();
		txtEntidad.setBounds(10, 81, 177, 20);
		panleParticipante.add(txtEntidad);
		txtEntidad.setColumns(10);
		
		lblEntidad = new JLabel("Nombre o Razon  social :");
		lblEntidad.setBounds(10, 66, 176, 14);
		panleParticipante.add(lblEntidad);
		
		lblRuc = new JLabel("RUC :");
		lblRuc.setBounds(212, 66, 92, 14);
		panleParticipante.add(lblRuc);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(384, 81, 139, 20);
		panleParticipante.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(384, 66, 92, 14);
		panleParticipante.add(lblTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(384, 35, 194, 20);
		panleParticipante.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblCorreo = new JLabel("Correo :");
		lblCorreo.setBounds(384, 21, 92, 14);
		panleParticipante.add(lblCorreo);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(212, 81, 154, 20);
		panleParticipante.add(txtRuc);
		txtRuc.setColumns(10);
		
		txtIdParticipante = new JTextField();
		txtIdParticipante.setBounds(10, 35, 114, 20);
		panleParticipante.add(txtIdParticipante);
		txtIdParticipante.setColumns(10);
		
		lblIdPedido = new JLabel("ID. Participante :");
		lblIdPedido.setBounds(10, 21, 116, 14);
		panleParticipante.add(lblIdPedido);
		
		btnBuscar = new JButton("");
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.setIcon(new ImageIcon(FrmParticipante.class.getResource("/imagenes/iconos_24x24/lupa.png")));
		btnBuscar.setBounds(149, 21, 40, 34);
		panleParticipante.add(btnBuscar);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(212, 35, 106, 20);
		panleParticipante.add(txtEstado);
		txtEstado.setColumns(10);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(212, 21, 67, 14);
		panleParticipante.add(lblEstado);
		btnBuscar.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 192, 737, 227);
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
		
		lblPedido = new JLabel("ID. Pedido :");
		lblPedido.setBounds(10, 20, 89, 14);
		getContentPane().add(lblPedido);
		
		btnNuevo = new JButton("");
		btnNuevo.setBackground(Color.LIGHT_GRAY);
		btnNuevo.setIcon(new ImageIcon(FrmParticipante.class.getResource("/imagenes/iconos_24x24/limpiar.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 89, 38, 33);
		getContentPane().add(btnNuevo);
		
		lblNewLabel = new JLabel("TABLA DE REGISTROS\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 170, 726, 23);
		getContentPane().add(lblNewLabel);
		
		btnBuscarPedido = new JButton("");
		btnBuscarPedido.setBackground(Color.LIGHT_GRAY);
		btnBuscarPedido.setIcon(new ImageIcon(FrmParticipante.class.getResource("/imagenes/iconos_24x24/lupa.png")));
		btnBuscarPedido.addActionListener(this);
		btnBuscarPedido.setBounds(111, 32, 38, 33);
		getContentPane().add(btnBuscarPedido);
		
		txtIdPedido = new JTextField();
		txtIdPedido.setBounds(10, 45, 89, 20);
		getContentPane().add(txtIdPedido);
		txtIdPedido.setColumns(10);
		
		btnAgregar = new JButton("REGISTRAR");
		btnAgregar.setBounds(198, 136, 99, 23);
		getContentPane().add(btnAgregar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(327, 136, 99, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(461, 136, 99, 23);
		getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnAgregar.addActionListener(this);
		
		new PedidoDAO();
		partDao = new ParticipanteDAO();
		propDao = new PropuestaDAO();
		cepDao = new ComiteDAO();
		
		arranque();
		
	}
	private void arranque() {
		
		estado();
		cargarTabla();
		correlativo();
		limpiar();
		
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarPedido) {
			actionPerformedBtnBuscarPedido(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
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
			ArrayList<Comite> listCep = cepDao.listarComiteXPedido(idPedido);
			
			if (listCep.size() == 3) {
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
			}else {
				Tool.mensajeError(this,"Pedido no cuenta con la cantidad de Miembros del Comité necesarios");
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
			
			txtIdPedido.setText(part.getCodPedido());
			txtIdParticipante.setText(part.getCodParticipante());
			txtEntidad.setText(part.getEntidad());
			txtRuc.setText(part.getRuc());
			txtCorreo.setText(part.getCorreo());
			txtTelefono.setText(part.getTelefono() + "");
			txtEstado.setText((part.getEstado()));
			
		}
				
	}
	protected void actionPerformedBtnBuscarPedido(ActionEvent e) {
		
		FrmBuscarPedido buscarPedido = new FrmBuscarPedido();
		FrmBuscarPedido.indice=1;
		buscarPedido.setVisible(true);
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
		
		if (txtIdPedido.getText().trim().length()==0) {
			Tool.mensajeError(this,"Eliga el ID del algún pedido. Presione la opcion buscar !");
		}
		res = txtIdPedido.getText();
		
		return res;
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
		
		if (txtRuc.getText().trim().length()==0) {
			Tool.mensajeError(this, "El campo de RUC está vacío !");
			txtRuc.requestFocus();
		}else if (txtRuc.getText().trim().matches(Reguex.RUC_PARTICIPANTE)){
			res = txtRuc.getText().trim();
		}else {
			Tool.mensajeError(this,"RUC inválido. Ejemp (XXXXXXXXXXX, 11 digitos)");
		}
		
		
		return res ;
	}

	private String leerCorreo() {
		String res = null;
		
		if(txtCorreo.getText().trim().length()==0) {
			Tool.mensajeError(this,"El campo del Correo está vacío !");
			txtCorreo.requestFocus();
		}else if (txtCorreo.getText().trim().matches(Reguex.CORREO_PARTICIPANTE)) {
			res = txtCorreo.getText().trim();
		}else {
			Tool.mensajeError(this,"Correo inválido. Ejemp. (estoesuncorreo@hotmail.com)");
			txtCorreo.requestFocus();
		}
		
		return res ;
	}

	private int leerTelefono() {
		int res = -1;
		
		if(txtTelefono.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo del Teléfono está vacío !");
			txtTelefono.requestFocus();
		}else if(txtTelefono.getText().trim().matches(Reguex.TELEFONO_PARTICIPANTE)){
			res = Integer.parseInt(txtTelefono.getText().trim());
		}else {
			Tool.mensajeError(this, "Telefono inválido. Ejemp. (999 999 999), 9 dígitos");
			txtTelefono.requestFocus();
		}
		
		return res ;
	}

	private String leerEstado() {
		String res = null;
		
		if(txtEstado.getText().trim().length()==0) {
			Tool.mensajeError(this,"Campo de Estado está vacío !");
			txtEstado.requestFocus();
		}else {
			res = txtEstado.getText().toString();
		}
		
		return res ;
	}
	
	
	//METODOS ADICIONALES
	
	
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
			
			txtIdPedido.setText(idPedido);
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
		txtIdPedido.setEditable(false);
		txtEstado.setText("REGISTRADO");
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
