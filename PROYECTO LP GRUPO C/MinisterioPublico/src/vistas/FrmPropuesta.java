package vistas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import clases.Participante;
import clases.Pedido;
import clases.Propuesta;
import mantenimiento.ParticipanteDAO;
import mantenimiento.PedidoDAO;
import mantenimiento.PropuestaDAO;
import utils.Tool;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class FrmPropuesta extends JInternalFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JLabel lblParticipante;
	private JButton btnActualizar;
	private JLabel lblPropuestaTecnica;
	private JLabel lblPropuestaEcono;
	private JLabel lblPedido;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JLabel lblNumeroPostulacion;
	private JTextField txtPropuesta;
	private JLabel lblEstado;
	private JComboBox<Object> cboEstado;
	private DefaultTableModel model;
	private JEditorPane txtPropTecnica;
	private JEditorPane txtPropEconomica;
	private JButton btnBuscar;
	private JDateChooser fechaProp;
	private JLabel lblFechaProp;
	private final ButtonGroup buttonGroupPT = new ButtonGroup();
	private final ButtonGroup buttonGroupPE = new ButtonGroup();

	PropuestaDAO gProp = new PropuestaDAO();
	PedidoDAO gPed = new PedidoDAO();
	ParticipanteDAO gPart = new ParticipanteDAO();

	private JComboBox cboPedido;
	private JComboBox cboParticipante;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPropuesta frame = new FrmPropuesta();
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
	public FrmPropuesta() {
		setTitle("Propuesta");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		lblParticipante = new JLabel("ID participante:");
		lblParticipante.setBounds(10, 39, 125, 14);
		contentPane.add(lblParticipante);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(562, 70, 102, 22);
		contentPane.add(btnActualizar);

		lblPropuestaTecnica = new JLabel("Propuesta Tecnica:");
		lblPropuestaTecnica.setBounds(10, 105, 125, 14);
		contentPane.add(lblPropuestaTecnica);

		lblPropuestaEcono = new JLabel("Propuesta Economica:");
		lblPropuestaEcono.setBounds(358, 103, 128, 14);
		contentPane.add(lblPropuestaEcono);

		// crear columnas de la tabla
		// Instanciar un objeto para la estructura de la tabla
		model = new DefaultTableModel();
		model.addColumn("Nombre Postor");
		model.addColumn("Compa√±ia");
		model.addColumn("Distrito");
		model.addColumn("RUC");
		model.addColumn("Prop. T√©cnica");
		model.addColumn("Prop. Econ√≥mica");
		model.addColumn("Estado");

		lblPedido = new JLabel("Nro de Pedido");
		lblPedido.setBounds(10, 11, 119, 14);
		contentPane.add(lblPedido);

		rdbtnNewRadioButton = new JRadioButton("SI");
		buttonGroupPT.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(155, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("NO");
		buttonGroupPT.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(214, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("SI");
		buttonGroupPE.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(503, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("NO");
		buttonGroupPE.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(562, 99, 46, 23);
		contentPane.add(rdbtnNewRadioButton_3);

		lblNumeroPostulacion = new JLabel("ID Propuesta:");
		lblNumeroPostulacion.setBounds(10, 67, 135, 14);
		contentPane.add(lblNumeroPostulacion);

		txtPropuesta = new JTextField();
		txtPropuesta.setBounds(145, 64, 115, 20);
		contentPane.add(txtPropuesta);

		lblEstado = new JLabel("ESTADO:");
		lblEstado.setBounds(388, 11, 80, 14);
		contentPane.add(lblEstado);

		cboEstado = new JComboBox<Object>();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Admitido", "No admitido" }));
		cboEstado.setBounds(482, 7, 126, 22);
		contentPane.add(cboEstado);

		txtPropTecnica = new JEditorPane();
		txtPropTecnica.setBounds(10, 130, 306, 221);
		contentPane.add(txtPropTecnica);

		txtPropEconomica = new JEditorPane();
		txtPropEconomica.setBounds(358, 128, 306, 221);
		contentPane.add(txtPropEconomica);

		btnBuscar = new JButton("Buscar ");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(450, 70, 102, 22);
		contentPane.add(btnBuscar);

		fechaProp = new JDateChooser();
		fechaProp.setBounds(482, 37, 126, 20);
		// fechaProp.setEnabled(false);
		contentPane.add(fechaProp);

		lblFechaProp = new JLabel("FECHA:");
		lblFechaProp.setBounds(388, 39, 53, 14);
		contentPane.add(lblFechaProp);

		cboPedido = new JComboBox();
		cboPedido.addItemListener(this);
		cboPedido.setBounds(145, 7, 115, 22);
		contentPane.add(cboPedido);

		cboParticipante = new JComboBox();
		cboParticipante.setBounds(145, 35, 115, 22);
		contentPane.add(cboParticipante);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(337, 70, 102, 22);
		contentPane.add(btnRegistrar);

		cargarcboPedidos();
		correlativo();
	}

	private void correlativo() {

		ArrayList<Propuesta> list = gProp.listarPropuestas();

		if (list.size() == 0) {
			txtPropuesta.setText("PR001");
		} else {
			String idProp = list.get(list.size() - 1).getCodPropuesta();

			int correlativo = Integer.parseInt(idProp.substring(2)) + 1;

			txtPropuesta.setText("PD" + Tool.ft.format("%03d", correlativo));

		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}

	private void cargarcboPedidos() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<Pedido> list = gPed.listarPedido();
		// 2. Validar el resultado del proceso
		if (list.size() == 0) {
			Tool.mensajeError(null, "Lista vacÌa");
		} else {
			cboPedido.addItem("Seleccione ... ");
			for (Pedido ped : list) {
				cboPedido.addItem(ped.getCodigo());
			}
		}

	}

	private void cargarcboParticipantes() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<Participante> list = gPart.buscarXPedido(getCodigoPedido());
		// 2. Validar el resultado del proceso
		cboParticipante.removeAllItems();
		if (list.size() == 0) {
			// Tool.mensajeError(null, "Lista vacÌa");
		} else {
			cboParticipante.addItem("Seleccione ... ");
			for (Participante par : list) {
				cboParticipante.addItem(par.getCodParticipante());
			}
		}

	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarPropuesta();
	}

	private String getCodigo() {
		return txtPropuesta.getText();
	}

	private String getCodigoParticipante() {
		return cboParticipante.getSelectedItem().toString();
	}

	private String getCodigoPedido() {
		return cboPedido.getSelectedItem().toString();
	}

	private String getEstado() {
		return cboEstado.getSelectedItem().toString();
	}

	private String getFechaProp() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fecha = sdf.format(fechaProp.getDate());
		return fecha;
	}

	private String getDescTec() {
		return txtPropTecnica.getText();
	}

	private String getDescEco() {
		return txtPropEconomica.getText();
	}

	// Busca propuesta por su cÛdigo
	private void buscarPropuesta() {
		String codigo;
		// 1 obtener el codigo ingresado
		codigo = getCodigoParticipante();
		// Validar
		if (codigo == null) {
			return;
		} else {
			// llamar al proceso
			Propuesta prop = gProp.buscarPropuesta(codigo);
			// Validar el resultado del proceso
			if (prop == null) {
				Tool.mensajeError(null, "cÛdigo no existe");
			} else {
				cboPedido.setSelectedItem(prop.getCodPedido());
				cboParticipante.setSelectedItem(prop.getCodParticipante());
				txtPropTecnica.setText(prop.getPropTecnica());
				txtPropEconomica.setText(prop.getPropEconomica());
				cboEstado.setSelectedItem(prop.getEstado());

				try {
					fechaProp.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(prop.getFecha()));
				} catch (ParseException e) {
					System.out.println("Error en el formato de la fecha");
				}
			}
		}

	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarPropuesta();
	}

	// Actualiza la propuesta
	private void actualizarPropuesta() {
		// variables
		String estado, codigo;
		// entradas
		codigo = getCodigo();
		estado = getEstado();

		// validar
		if (estado == null || codigo == null) {
			return;
		} else {
			// Crear un objeto de la clse Usuario
			Propuesta prop = new Propuesta();
			// setear --> asignar los valores obtenidos de la GUI a los atributos privados
			prop.setCodPropuesta(codigo);
			prop.setEstado(estado);

			// LLamar al proceso de actualizar
			int res = gProp.actualizarPropuesta(prop);
			// validar el resultado del proceso de actualizar
			if (res == 0) {
				Tool.mensajeError(null, "Error en la actualizaciÛn");
			} else {
				Tool.mensajeExito(null, "Usuario actualizado");
			}
		}

	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		registrarPropuesta();
	}

	private void registrarPropuesta() {
		// variables
		String codPed, codProp, codParti, fechaProp, descTec, descEco, estado;

		codPed = getCodigoPedido();
		codProp = getCodigo();
		codParti = getCodigoParticipante();
		fechaProp = getFechaProp();
		descTec = getDescTec();
		descEco = getDescEco();
		estado = getEstado();

		if (codPed == null || codProp == null || codParti == null || fechaProp == null || descTec == null
				|| descEco == null || estado == null) {
			return;
		} else {
			// Crear un objeto de la clse Usuario
			Propuesta prop = new Propuesta();
			// setear --> asignar los valores obtenidos de la GUI a los atributos privados
			prop.setCodPedido(codPed);
			prop.setCodPropuesta(codProp);
			prop.setCodParticipante(codParti);
			prop.setFecha(fechaProp);
			prop.setPropTecnica(descTec);
			prop.setPropEconomica(descEco);
			prop.setEstado(estado);

			// LLamar al proceso de registro
			int res = gProp.registrarPropuesta(prop);
			// validar el resultado del proceso de registro
			if (res == 0) {
				Tool.mensajeError(null, "Error en el registro");
			} else {
				Tool.mensajeExito(null, "Propuesta registrada");
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboPedido) {
			itemStateChangedCboPedido(e);
		}
	}

	protected void itemStateChangedCboPedido(ItemEvent e) {
		cargarcboParticipantes();
	}
}
