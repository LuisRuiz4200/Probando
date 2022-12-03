package vistas;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import clases.ActaPropuesta;
import clases.Pedido;
import clases.Propuesta;
import mantenimiento.ActaPropuestaDAO;
import mantenimiento.PropuestaDAO;
import utils.Tool;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmActaPropuesta extends JInternalFrame implements ItemListener, ActionListener {
	private JLabel lblCodigo;
	private JComboBox<Object> cboIdPropuesta;
	private JTextField txtIdActa;
	private JDateChooser dcFechaActa;
	private JLabel lblFecha;
	private JLabel lblCircunstancia;
	private JEditorPane txtDocumento;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JLabel lblEstado;

	private JPanel panelPropuesta;
	private JLabel lblNumeroPostulacion;
	private JLabel lblFechaPropuesta;
	private JTextField dcFechaProp;
	private JTextField txtEstadoProp;
	private JLabel lblEstado_1;
	private JLabel lblIdPedido;
	private JTextField txtIdPedido;
	private JPanel panelPropuesta_1;
	private JLabel lblTipo;
	private JComboBox<Object> cboTipoActa;
	private JTextField txtEstadoActa;

	private PropuestaDAO gProp = new PropuestaDAO();
	private ActaPropuestaDAO gAProp = new ActaPropuestaDAO();

	public static void main(String[] args) {

		FrmActaPropuesta form = new FrmActaPropuesta();
		form.setVisible(true);

	}

	public FrmActaPropuesta() {
		getContentPane().setBackground(new Color(192, 192, 192));

		setTitle("Acta de propuesta");
		setBounds(100, 100, 640, 358);
		this.getContentPane().setLayout(null);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		lblCircunstancia = new JLabel("Motivo / Circunstancia");
		lblCircunstancia.setBounds(17, 136, 137, 14);
		getContentPane().add(lblCircunstancia);

		txtDocumento = new JEditorPane();
		txtDocumento.setBounds(17, 161, 591, 120);
		getContentPane().add(txtDocumento);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(171, 292, 115, 23);
		getContentPane().add(btnRegistrar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(348, 292, 115, 23);
		getContentPane().add(btnModificar);

		panelPropuesta = new JPanel();
		panelPropuesta.setOpaque(false);
		panelPropuesta.setLayout(null);
		panelPropuesta.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROPUESTA",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPropuesta.setBounds(17, 11, 291, 114);
		getContentPane().add(panelPropuesta);

		lblNumeroPostulacion = new JLabel("ID Propuesta:");
		lblNumeroPostulacion.setBounds(10, 21, 106, 14);
		panelPropuesta.add(lblNumeroPostulacion);

		cboIdPropuesta = new JComboBox<Object>();
		cboIdPropuesta.addItemListener(this);
		cboIdPropuesta.setBounds(10, 34, 106, 22);
		panelPropuesta.add(cboIdPropuesta);

		lblFechaPropuesta = new JLabel("Fecha:");
		lblFechaPropuesta.setBounds(150, 21, 95, 14);
		panelPropuesta.add(lblFechaPropuesta);

		dcFechaProp = new JTextField();
		dcFechaProp.setBounds(150, 34, 124, 22);
		dcFechaProp.setEditable(false);

		panelPropuesta.add(dcFechaProp);

		lblIdPedido = new JLabel("ID Pedido:");
		lblIdPedido.setBounds(10, 65, 106, 14);
		panelPropuesta.add(lblIdPedido);

		txtIdPedido = new JTextField();
		txtIdPedido.setBounds(10, 81, 106, 22);
		panelPropuesta.add(txtIdPedido);
		txtIdPedido.setEditable(false);
		txtIdPedido.setColumns(10);

		lblEstado_1 = new JLabel("Estado:");
		lblEstado_1.setBounds(150, 65, 67, 14);
		panelPropuesta.add(lblEstado_1);

		txtEstadoProp = new JTextField();
		txtEstadoProp.setBounds(150, 81, 124, 22);
		panelPropuesta.add(txtEstadoProp);
		txtEstadoProp.setText("REGISTRADO");
		txtEstadoProp.setEditable(false);
		txtEstadoProp.setColumns(10);

		panelPropuesta_1 = new JPanel();
		panelPropuesta_1.setOpaque(false);
		panelPropuesta_1.setLayout(null);
		panelPropuesta_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ACTA",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPropuesta_1.setBounds(317, 11, 291, 114);
		getContentPane().add(panelPropuesta_1);

		txtIdActa = new JTextField();
		txtIdActa.setBounds(10, 34, 106, 20);
		panelPropuesta_1.add(txtIdActa);
		txtIdActa.setColumns(10);

		lblCodigo = new JLabel("ID Acta:");
		lblCodigo.setBounds(10, 21, 46, 14);
		panelPropuesta_1.add(lblCodigo);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(154, 21, 46, 14);
		panelPropuesta_1.add(lblFecha);

		dcFechaActa = new JDateChooser();
		dcFechaActa.setBounds(154, 34, 124, 20);
		panelPropuesta_1.add(dcFechaActa);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 65, 65, 14);
		panelPropuesta_1.add(lblEstado);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(154, 65, 65, 14);
		panelPropuesta_1.add(lblTipo);

		cboTipoActa = new JComboBox<Object>();
		cboTipoActa.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "Seleccione...", "Resultados", "Observaciones" }));
		cboTipoActa.setBounds(154, 81, 124, 22);
		panelPropuesta_1.add(cboTipoActa);

		txtEstadoActa = new JTextField();
		txtEstadoActa.setEditable(false);
		txtEstadoActa.setBounds(10, 81, 106, 22);
		panelPropuesta_1.add(txtEstadoActa);
		txtEstadoActa.setColumns(10);

		limpiar();
		cargarcboPropuesta();
		correlativo();

	}

	private void cargarcboPropuesta() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<Propuesta> list = gProp.listarPropuestas();
		// 2 Limpiar el cbo
		cboIdPropuesta.removeAllItems();
		;

		if (list.size() == 0) {
			Tool.mensajeError(this, "Lista vacía");
		} else {
			cboIdPropuesta.addItem("Seleccione...");
			for (Propuesta prop : list) {
				if(prop.getEstado().equals("REGISTRADO")) {
					cboIdPropuesta.addItem(prop.getCodPropuesta());
				}
			}
		}
	}

	private String getCodigoPropuesta() {
		try {
			return cboIdPropuesta.getSelectedItem().toString();
		} catch (NullPointerException e) {
			return null;
		}
	}

	private void cargarDataPropuesta() {
		Propuesta prop = gProp.buscarXIdPropuesta(getCodigoPropuesta());

		if (prop != null) {
			txtIdPedido.setText(prop.getCodPedido());
			txtEstadoProp.setText(prop.getEstado());
			dcFechaProp.setText(prop.getFecha());
		} else {
			limpiar();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboIdPropuesta) {
			itemStateChangedCboIdPropuesta(e);
		}
	}

	protected void itemStateChangedCboIdPropuesta(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			cargarDataPropuesta();
			cargarDataActa();
		}
	}

	private void limpiar() {
		txtIdPedido.setText("");
		txtEstadoProp.setText("");
		dcFechaProp.setText("");
		cboIdPropuesta.setSelectedIndex(-1);

		limpiarActa();
	}

	private void limpiarActa() {
		txtIdActa.setText("");
		txtEstadoActa.setText("");
		txtDocumento.setText("");
		dcFechaActa.setDate(new Date());
		cboTipoActa.setSelectedIndex(-1);
	}

	private String getCodActa() {
		return txtIdActa.getText();
	}

	private void correlativo() {
		ArrayList<ActaPropuesta> list = gAProp.listarActasPropuestas();

		@SuppressWarnings("resource")
		Formatter ft = new Formatter();

		if (list.size() == 0) {
			txtIdActa.setText("AC001");
		} else {
			String idProp = list.get(list.size() - 1).getIdActaPropuesta();
			int correlativo = Integer.parseInt(idProp.substring(2)) + 1;
			txtIdActa.setText("AC" + ft.format("%03d", correlativo));
		}
	}

	private void cargarDataActa() {
		ActaPropuesta acta = gAProp.buscarActaPropuestaxProp(getCodigoPropuesta());

		if (acta != null) {
			txtIdActa.setText(acta.getIdActaPropuesta());
			txtEstadoActa.setText(acta.getEstadoActa());
			cboTipoActa.setSelectedItem(acta.getTipoActa());
			txtDocumento.setText(acta.getDesActaPropuesta());
			try {
				dcFechaActa.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(acta.getFecha()));
			} catch (ParseException e) {
				System.out.println("Error en el formato de la fecha");
			}
		} else {
			limpiarActa();
			correlativo();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	private String getFechaActa() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fecha = sdf.format(dcFechaActa.getDate());
		return fecha;
	}

	private String getDescActa() {
		return txtDocumento.getText();
	}

	private String getTipoActa() {
		try {
			return cboTipoActa.getSelectedItem().toString();
		} catch (NullPointerException e) {
			return null;
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarActa();
	}

	private void registrarActa() {
		// variables
		String codActa, codProp, fechaActa, descActa, tipoActa, estado;

		codActa = getCodActa();
		codProp = getCodigoPropuesta();
		fechaActa = getFechaActa();
		descActa = getDescActa();
		tipoActa = getTipoActa();
		estado = "REGISTRADO";

		if (codActa == null || codProp == null || fechaActa == null || descActa == null || tipoActa == null
				|| estado == null) {
			return;
		} else {
			// Crear un objeto de la clse Usuario
			ActaPropuesta aprop = new ActaPropuesta();
			// setear --> asignar los valores obtenidos de la GUI a los atributos privados
			aprop.setIdActaPropuesta(codActa);
			aprop.setIdPropuesta(codProp);
			aprop.setFecha(fechaActa);
			aprop.setDesActaPropuesta(descActa);
			aprop.setTipoActa(tipoActa);
			aprop.setEstadoActa(estado);

			// LLamar al proceso de registro
			int res = gAProp.registrarActaPropuesta(aprop);
			// validar el resultado del proceso de registro
			if (res == 0) {
				Tool.mensajeError(this, "Error en el registro");
			} else {
				Tool.mensajeExito(this, "Propuesta registrada");
				txtEstadoActa.setText(estado);
//				if (aprop.getTipoActa().equals("Observaciones")) {
//					prop = gProp.buscarXIdPropuesta(aprop.getIdPropuesta());
//					prop.setEstado("OBSERVADO");
//					gProp.actualizarPropuesta(prop);
//				}else if (aprop.getTipoActa().equals("Resultados")) {
//					prop = gProp.buscarXIdPropuesta(aprop.getIdPropuesta());
//					prop.setEstado("NO ADMITIDA");
//					gProp.actualizarPropuesta(prop);
//				}
			}
		}
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		actualizarActa();
	}

	private void actualizarActa() {
		// variables
		String idActa, fecha, desc, tipo, codProp;
		// entradas
		idActa = getCodActa();
		codProp = getCodigoPropuesta();
		fecha = getFechaActa();
		desc = getDescActa();
		tipo = getTipoActa();

		// validar
		if (idActa == null || fecha == null || desc == null || tipo == null || codProp == null) {
			return;
		} else {
			// Crear un objeto
			ActaPropuesta aprop = new ActaPropuesta();
			// setear --> asignar los valores obtenidos de la GUI a los atributos privados
			aprop.setIdActaPropuesta(idActa);
			aprop.setIdPropuesta(codProp);
			aprop.setFecha(fecha);
			aprop.setDesActaPropuesta(desc);
			aprop.setTipoActa(tipo);

			// LLamar al proceso de actualizar
			int res = gAProp.actualizarPropuesta(aprop);
			// validar el resultado del proceso de actualizar
			if (res == 0) {
				Tool.mensajeError(this, "Error en la actualización");
			} else {
				Tool.mensajeExito(this, "Acta actualizada");
			}
		}
	}
}
