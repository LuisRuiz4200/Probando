package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Validaciones.Reguex;
import clases.Comite;
import clases.ObjetoPedido;
import clases.Participante;
import clases.Pedido;
import clases.TipoPedido;
import mantenimiento.ComiteDAO;
import mantenimiento.ObjetoPedidoDAO;
import mantenimiento.ParticipanteDAO;
import mantenimiento.PedidoDAO;
import mantenimiento.TipoPedidoDAO;
import utils.Tool;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class FrmPedido extends JInternalFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtIdPedido;
	private JTextField txtEntidad;
	private JLabel lblNroPedido;
	private JLabel lblEntidad;
	private JLabel lblTipo;
	private JLabel lblObjeto;
	private JComboBox<Object> cboTipo;
	private JTextArea txtDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JTable tbPedidos;
	private JScrollPane scrollPane;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JDateChooser dcFecha; 
	private DefaultTableModel model;
	private JComboBox <Object>cboObjeto;
	
	private TipoPedidoDAO tipPedDao;
	private ObjetoPedidoDAO objPedDao;
	private ComiteDAO cepDao;
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private JButton btnNuevo;
	private JTextField txtEstado;
	private JLabel lblEstado;
	private JLabel lblRuc;
	private JTextField txtRuc;
	private JLabel lblNewLabel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPedido frame = new FrmPedido();
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
	public FrmPedido() {
		setTitle("Registro de Pedido");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		
		txtIdPedido = new JTextField();
		txtIdPedido.setEditable(false);
		txtIdPedido.setBounds(339, 33, 122, 20);
		contentPane.add(txtIdPedido);
		txtIdPedido.setColumns(10);
		
		lblNroPedido = new JLabel("ID Pedido :");
		lblNroPedido.setBounds(339, 14, 147, 14);
		contentPane.add(lblNroPedido);
		
		lblTipo = new JLabel("Tipo de Contratacion :");
		lblTipo.setBounds(20, 141, 147, 14);
		contentPane.add(lblTipo);
		
		lblObjeto = new JLabel("Objeto de Contratacion :");
		lblObjeto.setBounds(20, 92, 147, 14);
		contentPane.add(lblObjeto);
		
		cboTipo = new JComboBox<Object>();
		cboTipo.setBounds(20, 158, 220, 22);
		contentPane.add(cboTipo);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(458, 81, 279, 88);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.add(txtDescripcion);
		
		lblDescripcion = new JLabel("Descripcion de \r\nRequrimiento:");
		lblDescripcion.setBounds(458, 64, 175, 20);
		contentPane.add(lblDescripcion);
		
		lblFecha = new JLabel("Fecha Inicio : ");
		lblFecha.setBounds(177, 92, 89, 14);
		contentPane.add(lblFecha);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 727, 229);
		contentPane.add(scrollPane);
		
		tbPedidos = new JTable();
		tbPedidos.addMouseListener(this);
		scrollPane.setViewportView(tbPedidos);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(494, 183, 117, 23);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(621, 183, 108, 23);
		contentPane.add(btnModificar);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(177, 108, 108, 20);
		contentPane.add(dcFecha);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ENTIDAD");
		model.addColumn("TIPO");
		model.addColumn("OBJETO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
		model.addColumn("ESTADO");
	
		tbPedidos.setModel(model);
		
		cboObjeto = new JComboBox<Object>();
		cboObjeto.setBounds(20, 108, 122, 22);
		contentPane.add(cboObjeto);
		
		btnNuevo = new JButton("LIMPIAR");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(352, 109, 89, 23);
		contentPane.add(btnNuevo);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(610, 33, 106, 20);
		contentPane.add(txtEstado);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(610, 14, 67, 14);
		contentPane.add(lblEstado);
		
		lblNewLabel = new JLabel("TABLA DE PEDIDOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 186, 727, 20);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ENTIDAD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 319, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(167, 39, 117, 20);
		panel.add(txtRuc);
		txtRuc.setText("");
		txtRuc.setColumns(10);
		
		txtEntidad = new JTextField();
		txtEntidad.setBounds(10, 39, 147, 20);
		panel.add(txtEntidad);
		txtEntidad.setColumns(10);
		
		lblEntidad = new JLabel("Entidad Solicitante :");
		lblEntidad.setBounds(10, 22, 147, 14);
		panel.add(lblEntidad);
		
		lblRuc = new JLabel("RUC :");
		lblRuc.setBounds(167, 20, 147, 14);
		panel.add(lblRuc);
		
		tipPedDao = new TipoPedidoDAO();
		objPedDao = new ObjetoPedidoDAO();
		pedDao = new PedidoDAO();
		partDao = new ParticipanteDAO();
		cepDao = new ComiteDAO();
		
		arranque();
		
	}
	
	
	
	private void arranque() {
		estado();
		cargarTipoPedido();
		cargarObjetoPedido();
		correlativo();
		cargarTabla();
		limpiar();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		arranque();
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		String idPedido = leerIdPedido();
		String entidad = leerEntidad();
		String ruc = leerRuc();
		int idTipoPedido = leerTipo();
		int idObjetoPedido = leerObjeto();
		String descripcion  = leerDescripcion();
		String fecha = leerFecha();
		String estado = leerEstado();
		
		
		
		if (idPedido==null ||entidad==null||ruc==null  ||idTipoPedido==-1 ||
				idObjetoPedido==-1 ||descripcion==null 
				||fecha==null || estado ==null) {
			return;
		}else {
				Pedido ped = new Pedido(idPedido,entidad,ruc,
						idTipoPedido,idObjetoPedido,descripcion,
						fecha,estado);
				
				int ok = pedDao.registrarPedido(ped);
			
				if(ok == 0){
					Tool.mensajeError(this, "Error de registro");
				}else {
					Tool.mensajeExito(this, "Pedido registrado!");
					correlativo();
					cargarTabla();
				}
		}
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		String idPedido = leerIdPedido();
		String entidad = leerEntidad();
		String ruc = leerRuc();
		int idTipoPedido = leerTipo();
		int idObjetoPedido = leerObjeto();
		String descripcion  = leerDescripcion();
		String fecha = leerFecha();
		String estado = leerEstado();
		
		if (idPedido==null ||entidad==null ||ruc==null ||idTipoPedido==-1 ||
				idObjetoPedido==-1 ||descripcion==null 
				||fecha==null || estado ==null) {
			return;
		}else {
			
			Pedido ped = new Pedido(idPedido,entidad,ruc,
					idTipoPedido,idObjetoPedido,descripcion,
					fecha,estado);
			
			int ok = pedDao.actualizarPedido(ped);
		
			if(ok == 0){
				Tool.mensajeError(this, "Error de update");
			}else {
				Tool.mensajeExito(this, "Pedido actualizado!");
				cargarTabla();
			}
		}
		
		
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbPedidos) {
			mouseClickedTbContratacion(e);
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
	protected void mouseClickedTbContratacion(MouseEvent e) {
		cargarCajas();
	}
	
	//METODOS DE ENTRADA 
	
	private String leerIdPedido() {
		String res=null;
		
		if (txtIdPedido.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo del id pedido esta vacï¿½o !");
			txtIdPedido.requestFocus();
		}else if (txtIdPedido.getText().trim().matches(Reguex.ID_PEDIDO)) {
			res = txtIdPedido.getText().trim();
		}else {
			Tool.mensajeError(this,"ID pedido invï¿½lido. Ejemp (PD002)");
			txtIdPedido.requestFocus();
		}
		
		return res;
	}

	private String leerEntidad() {
		String res=null;
		
		if (txtEntidad.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo entidad esta vacï¿½o !");
			txtEntidad.requestFocus();
		}else if (txtEntidad.getText().trim().matches(Reguex.ENTIDAD_PEDIDO)) {
			res = txtEntidad.getText().trim();
		}else {
			Tool.mensajeError(this, "Entidad invï¿½lida. Cantidad de caracteres (3 y 20)");
			txtEntidad.requestFocus();
		}
		
		
		return res;
	}


	private String leerRuc() {
		String res=null;
		
		if (txtRuc.getText().trim().length()==0) {
			Tool.mensajeError(this,"Campo del RUC estï¿½ vacï¿½o !");
			txtRuc.requestFocus();
		}else if (txtRuc.getText().trim().matches(Reguex.RUC_PEDIDO)) {
			res= txtRuc.getText();
		}else {
			Tool.mensajeError(this,"Ruc invï¿½lido. Ejemp (XXXXXXXXXXX, 11 digitos)");
			txtRuc.requestFocus();
		}
		
		
		return res;
	}
	
	private int leerTipo() {
		int res=-1;
		
		if(cboTipo.getSelectedIndex()==0) {
			Tool.mensajeError(this,"Elige un tipo de pedido");
		}else {
			res = cboTipo.getSelectedIndex();
		}
		
		return res;
	}

	private int leerObjeto() {
		int res=-1;
		
		if (cboObjeto.getSelectedIndex()==0) {
			Tool.mensajeError(this,"Elige un objeto de contrataciï¿½n");
		}else {
			res = cboObjeto.getSelectedIndex();
		}
		
		
		return res;
	}

	private String leerDescripcion() {
		String res=null;
		
		if (txtDescripcion.getText().trim().length()==0) {
			Tool.mensajeError(this, "El registro necesita un descripcion");
			txtDescripcion.requestFocus();
		}else {
			res = txtDescripcion.getText().trim();
		}
		return res;
	}

	private String leerFecha() {
		String res=null;
		
		if (dcFecha.getDate()==null) {
			Tool.mensajeError(this, "El campo fecha estï¿½ vacï¿½o !");
			dcFecha.requestFocus();
		}else {
			res = Tool.sdf.format(dcFecha.getDate()).toString();
		}
		
		return res;
	}

	private String leerEstado() {
		String res=null;
		
		if (txtEstado.getText().trim().length()==0) {
			Tool.mensajeError(this,"El campo estado estï¿½ vacï¿½o !");
			txtEstado.requestFocus();
		}else {
			res = txtEstado.getText().toString();
		}
		
		return res;
	}
	
	//METODOS ADICIONALES
	
	private void cargarTipoPedido() {
		
		ArrayList<TipoPedido> list = tipPedDao.listarTipoPedido();
		
		cboTipo.removeAllItems();
		cboTipo.addItem("SELECCIONE..");
		
		for (TipoPedido tipPed : list) {
			
			cboTipo.addItem(tipPed.getIdTipoPedido() + ". " + tipPed.getDesTipoPedido());
			
		}
		
	}
	private void cargarObjetoPedido() {
		
		ArrayList<ObjetoPedido> list = objPedDao.listarObjetoPedido();
		
		cboObjeto.removeAllItems();
		cboObjeto.addItem("SELECCIONE..");
		
		for (ObjetoPedido objPed : list) {
			
			cboObjeto.addItem(objPed.getIdObjetoPedido() + ". " + objPed.getDesObjetoPedido());
			
		}
		
	}
	
	private void correlativo () {
		
		@SuppressWarnings("resource")
		Formatter ft = new Formatter ();
		
		ArrayList<Pedido> list = pedDao.listarPedido();
		
		if (list.size() == 0) {
			txtIdPedido.setText("PD001");
		}else {
			String idPedido=list.get(list.size()-1).getCodigo();
			
			int correlativo = Integer.parseInt(idPedido.substring(2))+1;
			
			txtIdPedido.setText("PD" + ft.format("%03d",correlativo));
			
		}
		
	}
	
	private void cargarTabla() {
		
		ArrayList<Pedido>list =pedDao.listarPedido();
		
		model.setRowCount(0);
		
		for (Pedido p : list) {

			Object [] ped = {
				p.getCodigo(),
				p.getEntidad(),
				p.getTipo(),
				p.getObjeto(),
				p.getDescripcion(),
				p.getFecha(),
				p.getEstado()
			};
			
			model.addRow(ped);
			
		}
		
	}
	
	private void cargarCajas() {
		
		int indice = tbPedidos.getSelectedRow();
		
		String idPedido = tbPedidos.getValueAt(indice, 0).toString();
		
		Pedido ped =pedDao.buscarXIdPedido(idPedido);
		
		txtIdPedido.setText(ped.getCodigo());
		txtEntidad.setText(ped.getEntidad());
		cboTipo.setSelectedIndex(ped.getTipo());
		cboObjeto.setSelectedIndex(ped.getObjeto());
		txtDescripcion.setText(ped.getDescripcion());
		txtRuc.setText(ped.getRuc());
		try {
			dcFecha.setDate(Tool.sdf.parse(ped.getFecha()));
		} catch (ParseException e) {
			Tool.mensajeError(this,"Error de formato en fecha");
		}
		txtEstado.setText(ped.getEstado());

		
	}
	
	private void estado () {
		ArrayList<Participante> listPart = partDao.listarParticipante();
		ArrayList<Pedido> listPed = pedDao.listarPedido();
		
		for (Participante part : listPart) {
			
			for (Pedido ped : listPed) {
				if (part.getCodPedido().equals(ped.getCodigo())) {
					ped.setEstado("EN PROCESO");
					pedDao.actualizarPedido(ped);
				}
			}
		}
		
	}
	
	private void limpiar () {
		txtEntidad.setEditable(false);
		txtRuc.setEditable(false);
		txtEntidad.setText("MINISTERIO PÚBLICO");
		txtRuc.setText("20131370301");
		dcFecha.setDate(new Date());
		txtDescripcion.setText("");
		txtEstado.setText("REGISTRADO");
	}
}
