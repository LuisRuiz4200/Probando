package vistas;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Validaciones.Reguex;
import clases.EvaluacionPropuesta;
import clases.Participante;
import clases.Pedido;
import clases.Propuesta;
import mantenimiento.EvaluacionPropuestaDAO;
import mantenimiento.ParticipanteDAO;
import mantenimiento.PedidoDAO;
import mantenimiento.PropuestaDAO;
import utils.Tool;

import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmPuntajePropuesta extends JInternalFrame implements ActionListener {
	private JComboBox <Object> cboPropuesta;
	private JTextField txtPuntTecnico;
	private JLabel lblPuntTecnico;
	private JDateChooser dcFecha;
	private JLabel lblFecha;
	private JTextField txtPuntEconomico;
	private JLabel lblPuntEconomico;
	private JTable table;
	private JButton btnRegistrar;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JTextField txtEvaluacion;
	private JLabel lblEvaluacion;
	private JPanel panelPedido;
	private JTextField txtRucPedido;
	private JLabel lblRucPedido;
	private JPanel panelParticipante;
	private JTextField txtEntidadParti;
	private JLabel lblEntidad;
	private JLabel lblRuc;
	private JTextField txtRucParti;
	private JButton btnBuscar;
	private JPanel panelPropuesta;
	private JLabel lblNumeroPostulacion;
	private JTextField txtEstado;
	private JLabel lblEstado;
	private JTextField txtEntidadPedido;
	private JLabel lblEntidadPedido;
	private EvaluacionPropuestaDAO evaPropDao;
	private PropuestaDAO propDao;
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private JButton btnNuevo;
	
	
	public static void main (String [] args) {
		FrmPuntajePropuesta pro = new FrmPuntajePropuesta ();
		pro.setVisible(true);
	}
	
	public FrmPuntajePropuesta () {
		
		setTitle("Puntos de la evaluaci\u00F3n de propuestas");
		setBounds(100,100,686,483);
		
	
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.lightGray);
		
		txtPuntTecnico = new JTextField();
		txtPuntTecnico.setColumns(10);
		txtPuntTecnico.setBounds(379, 170, 98, 20);
		getContentPane().add(txtPuntTecnico);
		
		lblPuntTecnico = new JLabel("Pun. T\u00E9cnica");
		lblPuntTecnico.setBounds(379, 151, 98, 14);
		getContentPane().add(lblPuntTecnico);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(172, 31, 129, 20);
		getContentPane().add(dcFecha);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(172, 12, 46, 14);
		getContentPane().add(lblFecha);
		
		txtPuntEconomico = new JTextField();
		txtPuntEconomico.setColumns(10);
		txtPuntEconomico.setBounds(487, 170, 98, 20);
		getContentPane().add(txtPuntEconomico);
		
		lblPuntEconomico = new JLabel("Punt. Econ\u00F3mica");
		lblPuntEconomico.setBounds(487, 151, 98, 14);
		getContentPane().add(lblPuntEconomico);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 649, 197);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(525, 201, 89, 23);
		getContentPane().add(btnRegistrar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID PROPUESTA");
		modelo.addColumn("ID EVALUACION");
		modelo.addColumn("PUNT. TECNICO");
		modelo.addColumn("PUNT. ECONOMICO");
		modelo.addColumn("FECHA");
		modelo.addColumn("ESTADO");
		table.setModel(modelo);
		
		txtEvaluacion = new JTextField();
		txtEvaluacion.setEditable(false);
		txtEvaluacion.setColumns(10);
		txtEvaluacion.setBounds(22, 31, 98, 20);
		getContentPane().add(txtEvaluacion);
		
		lblEvaluacion = new JLabel("ID evaluacion");
		lblEvaluacion.setBounds(25, 11, 98, 14);
		getContentPane().add(lblEvaluacion);
		
		panelPedido = new JPanel();
		panelPedido.setLayout(null);
		panelPedido.setOpaque(false);
		panelPedido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PEDIDO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPedido.setBounds(10, 151, 356, 87);
		getContentPane().add(panelPedido);
		
		txtRucPedido = new JTextField();
		txtRucPedido.setEditable(false);
		txtRucPedido.setColumns(10);
		txtRucPedido.setBounds(198, 45, 146, 20);
		panelPedido.add(txtRucPedido);
		
		lblRucPedido = new JLabel("RUC pedido");
		lblRucPedido.setBounds(198, 27, 119, 14);
		panelPedido.add(lblRucPedido);
		
		txtEntidadPedido = new JTextField();
		txtEntidadPedido.setEditable(false);
		txtEntidadPedido.setColumns(10);
		txtEntidadPedido.setBounds(10, 45, 178, 20);
		panelPedido.add(txtEntidadPedido);
		
		lblEntidadPedido = new JLabel("ENTIDAD PEDIDO");
		lblEntidadPedido.setBounds(10, 27, 119, 14);
		panelPedido.add(lblEntidadPedido);
		
		panelParticipante = new JPanel();
		panelParticipante.setLayout(null);
		panelParticipante.setOpaque(false);
		panelParticipante.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParticipante.setBackground(SystemColor.menu);
		panelParticipante.setBounds(251, 62, 363, 78);
		getContentPane().add(panelParticipante);
		
		txtEntidadParti = new JTextField();
		txtEntidadParti.setText("");
		txtEntidadParti.setEditable(false);
		txtEntidadParti.setColumns(10);
		txtEntidadParti.setBounds(10, 37, 177, 20);
		panelParticipante.add(txtEntidadParti);
		
		lblEntidad = new JLabel("Entidad");
		lblEntidad.setBounds(11, 22, 67, 14);
		panelParticipante.add(lblEntidad);
		
		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(197, 22, 92, 14);
		panelParticipante.add(lblRuc);
		
		txtRucParti = new JTextField();
		txtRucParti.setText("");
		txtRucParti.setEditable(false);
		txtRucParti.setColumns(10);
		txtRucParti.setBounds(197, 37, 154, 20);
		panelParticipante.add(txtRucParti);
		
		panelPropuesta = new JPanel();
		panelPropuesta.setOpaque(false);
		panelPropuesta.setLayout(null);
		panelPropuesta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROPUESTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPropuesta.setBounds(10, 62, 231, 78);
		getContentPane().add(panelPropuesta);
		
		cboPropuesta = new JComboBox <Object>();
		cboPropuesta.setEditable(true);
		cboPropuesta.setBounds(10, 42, 107, 22);
		panelPropuesta.add(cboPropuesta);
		
		lblNumeroPostulacion = new JLabel("ID Propuesta:");
		lblNumeroPostulacion.setBounds(10, 25, 106, 14);
		panelPropuesta.add(lblNumeroPostulacion);
		
		btnBuscar = new JButton("Buscar ");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(126, 35, 80, 29);
		panelPropuesta.add(btnBuscar);
		
		txtEstado = new JTextField();
		txtEstado.setText("REGISTRADO");
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(392, 26, 106, 29);
		getContentPane().add(txtEstado);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(392, 12, 67, 14);
		getContentPane().add(lblEstado);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(542, 28, 89, 23);
		getContentPane().add(btnNuevo);
		
		evaPropDao = new EvaluacionPropuestaDAO();
		propDao = new PropuestaDAO ();
		pedDao = new PedidoDAO();
		partDao = new ParticipanteDAO();
		
		
		arranque();
		
	}
	
	private void arranque() {
		
		limpiar();
		cargarTablaEvaluacionPropuesta();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		
		if(cboPropuesta.getSelectedIndex()==0) {
			Tool.mensajeError(this,"Eliga el ID de una propuesta para iniciar la busqueda");
		}else {
			String idPropuesta = leerIdPropuesta();
			
			Propuesta prop = propDao.buscarXIdPropuesta(idPropuesta);
			
			String idParticipante = prop.getCodParticipante();
			
			Participante part = partDao.buscarXIdParticipante(idParticipante);
			
			String idPedido = part.getCodPedido();
			
			Pedido ped = pedDao.buscarXIdPedido(idPedido);
			
			//LLENAR PANEL PARTICIPANTE
			
			txtEntidadParti.setText(part.getEntidad());
			txtRucParti.setText(part.getRuc());
			
			//LLENAR PALEN PEDIDO
			
			txtEntidadPedido.setText(ped.getEntidad());
			txtRucPedido.setText(ped.getRuc());
			
		}
		
		
		
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
		String idEvaluacion = leerIdEvaluacion();
		String fecha = leerFecha();
		String estado = leerEstado();
		String idPropuesta = leerIdPropuesta();
		double puntTecnico = leerPuntTecnico();
		double puntEconomico = leerPuntEconomico();
		
		EvaluacionPropuesta evProp = null;
		
		if (idEvaluacion == null || fecha == null || estado == null ||
				idPropuesta == null || puntTecnico == -1 ||
				puntEconomico == -1 ) {
			Tool.mensajeError(this, "Error durante el registro");
		}else {
			
			evProp = new EvaluacionPropuesta(
					idPropuesta,idEvaluacion,
					puntTecnico, puntEconomico,
					fecha,estado
					);
			
			int ok = evaPropDao.registrarEvaluacionPropuesta(evProp);
			
			if (ok == 0) {
				Tool.mensajeError(this, "Error al registrar puntajes");
			}else {
				Tool.mensajeExito(this,"Puntajes registrados !");
				cargarTablaEvaluacionPropuesta();
			}
			
		}
		
	}
	
	//METODOS DE ENTRADA
	
	private String leerIdEvaluacion() {
		String res = null;
		
		if (txtEvaluacion.getText().trim().length()==0) {
			Tool.mensajeError(this, "El campo del ID de la evaluación está vacía !");
			txtEvaluacion.requestFocus();
		}else if (txtEvaluacion.getText().trim().matches(Reguex.ID_EVALUACION)) {
			res = txtEvaluacion.getText().trim();
		}else {
			Tool.mensajeError(this, "ID de la evaluación inválida. Ejemp. (EVPR002)");
			txtEvaluacion.requestFocus();
		}
		
		return res;
	}

	private String leerFecha() {
		String res = null;
		
		if (dcFecha.getDate()==null) {
			Tool.mensajeError(this, "Campo de la fecha está vacío !");
			dcFecha.requestFocus();
		}else {
			res = Tool.sdf.format(dcFecha.getDate());
		}
		
		return res;
	}

	private String leerEstado() {
		String res = null;
		
		if (txtEstado.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo del Estado está vacío !");
		}else {
			res = txtEstado.getText().trim();
		}
		
		return res;
	}

	private String leerIdPropuesta() {
		String res = null;
		
		if (cboPropuesta.getSelectedIndex()==0) {
			Tool.mensajeError(this, "Eliga una ID de propuesta !");
		}else {
			res = cboPropuesta.getSelectedItem().toString();
		}
		
		return res;
	}

	private double leerPuntTecnico() {
		double res = -1;
		
		if (txtPuntTecnico.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo del Puntaje Técnico está vacío !");
			txtPuntTecnico.requestFocus();
		}else if(txtPuntTecnico.getText().trim().matches(Reguex.PUNTTECNICO_EVALUACION)&&Integer.parseInt(txtPuntTecnico.getText())<=100){
			res = Double.parseDouble(txtPuntTecnico.getText().trim());
		}else {
			Tool.mensajeError(this, "Puntaje técnico inválido. Ejemp.  (XXX) entre 1 y 3 digitos numéricos no mayor a 100");
		}
		
		return res;
	}

	private double leerPuntEconomico() {
		double res = -1;
		
		if (txtPuntEconomico.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo del Puntaje Económico está vacío !");
			txtPuntEconomico.requestFocus();
		}else if(txtPuntEconomico.getText().trim().matches(Reguex.PUNTECONOMICO_EVALUACION)&&Integer.parseInt(txtPuntEconomico.getText())<=100){
			res = Double.parseDouble(txtPuntEconomico.getText().trim());
		}else {
			Tool.mensajeError(this, "Puntaje económico inválido. Ejemp.  (XXX) entre 1 y 3 digitos numéricos no mayor 100");
		}		
		return res;
	}
	
	//METODOS ADICIONALES
	
	private void correlativo () {
		
		@SuppressWarnings("resource")
		Formatter ft = new Formatter();
		
		ArrayList <EvaluacionPropuesta> list = evaPropDao.listarEvaluacionPropuesta();
		
		if (list.size()==0) {
			txtEvaluacion.setText("EVPR001");
		}else {
			String idEvaProp = list.get(list.size()-1).getIdEvapropuesta();
			
			int n =Integer.parseInt(idEvaProp.substring(4))+1;
			
			txtEvaluacion.setText("");
			txtEvaluacion.setText("EVPR"+ft.format("%03d", n));
		}
		
	}
	
	private void limpiar () {
		
		dcFecha.setDate(new Date());
		
		correlativo();
		cargarCboPropuesta();
		txtEntidadParti.setText("");
		txtRucParti.setText("");
		txtEntidadPedido.setText("");
		txtRucPedido.setText("");
		txtPuntTecnico.setText("");
		txtPuntEconomico.setText("");
		txtEstado.setText("REGISTRADO");
	}

	private void cargarCboPropuesta() {
		ArrayList<Propuesta> listProp = propDao.listarPropuestas();
		
		cboPropuesta.removeAllItems();
		cboPropuesta.addItem("SELECCIONE..");
		
		for (Propuesta prop : listProp) {
			
			if (prop.getEstado().equals("REGISTRADO")) {
				cboPropuesta.addItem(prop.getCodPropuesta());
			}
			
		}
		
	}
	private void cargarTablaEvaluacionPropuesta() {
		
		ArrayList<EvaluacionPropuesta>  listEvaProp = evaPropDao.listarEvaluacionPropuesta();
		
		modelo.setRowCount(0);
		
		for (EvaluacionPropuesta evaProp : listEvaProp) {
			
			Object [] x = {
					evaProp.getIdPropuesta(),
					evaProp.getIdEvapropuesta(),
					evaProp.getPuntTecnica(),
					evaProp.getPuntEconomica(),
					evaProp.getFecha(),
					evaProp.getEstadoPropuesta()		
			};
			
			modelo.addRow(x);
		}
		
	}
	
}
