package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import clases.Participante;
import clases.Pedido;
import clases.Propuesta;
import mantenimiento.ParticipanteDAO;
import mantenimiento.PedidoDAO;
import mantenimiento.PropuestaDAO;
import utils.Tool;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class FrmPropuesta extends JInternalFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JButton btnActualizar;
	private JLabel lblPropuestaTecnica;
	private JLabel lblPropuestaEcono;
	private JLabel lblPedido;
	private JLabel lblNumeroPostulacion;
	private JTextField txtPropuesta;
	private JTextArea txtPropTecnica;
	private JTextArea txtPropEconomica;
	private JDateChooser dcFechaProp;
	private JLabel lblFechaProp;

	private PropuestaDAO gProp = new PropuestaDAO();
	private PedidoDAO gPed = new PedidoDAO();
	private ParticipanteDAO gPart = new ParticipanteDAO();
	private JButton btnRegistrar;
	private JPanel panelParticipante;
	private JTextField txtEntidadParti;
	private JLabel lblEntidad;
	private JLabel lblRuc;
	private JTextField txtRucParti;
	private JLabel lblIdPedido;
	private JTextField txtEstado;
	private JLabel lblEstado_1;
	private JPanel panelPedido;
	private JTextField txtObjetoPedido;
	private JLabel lblObjetoPedido;
	private JPanel panelPropuesta;
	private JButton btnNuevo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField txtIdPedido;
	private JComboBox<Object> cboParticipante;

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
		setTitle("Registro de Propuestas");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		lblPropuestaTecnica = new JLabel("Propuesta Tecnica:");
		lblPropuestaTecnica.setBounds(10, 214, 125, 14);
		contentPane.add(lblPropuestaTecnica);

		lblPropuestaEcono = new JLabel("Propuesta Economica:");
		lblPropuestaEcono.setBounds(361, 214, 128, 14);
		contentPane.add(lblPropuestaEcono);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 338, 189);
		contentPane.add(scrollPane);

		txtPropTecnica = new JTextArea();
		scrollPane.setViewportView(txtPropTecnica);
		txtPropTecnica.setLineWrap(true);
		txtPropTecnica.setBorder(new EmptyBorder(8,8,8,8));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(358, 241, 351, 189);
		contentPane.add(scrollPane_1);

		txtPropEconomica = new JTextArea();
		scrollPane_1.setViewportView(txtPropEconomica);
		txtPropEconomica.setLineWrap(true);
		txtPropEconomica.setBorder(new EmptyBorder(8,8,8,8));

		panelParticipante = new JPanel();
		panelParticipante.setLayout(null);
		panelParticipante.setOpaque(false);
		panelParticipante.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"PARTICIPANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParticipante.setBackground(SystemColor.menu);
		panelParticipante.setBounds(13, 11, 306, 115);
		contentPane.add(panelParticipante);

		txtEntidadParti = new JTextField();
		txtEntidadParti.setText("");
		txtEntidadParti.setColumns(10);
		txtEntidadParti.setBounds(10, 81, 146, 20);
		panelParticipante.add(txtEntidadParti);

		lblEntidad = new JLabel("Nombre social:");
		lblEntidad.setBounds(11, 66, 92, 14);
		panelParticipante.add(lblEntidad);

		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(166, 66, 92, 14);
		panelParticipante.add(lblRuc);

		txtRucParti = new JTextField();
		txtRucParti.setText("");
		txtRucParti.setColumns(10);
		txtRucParti.setBounds(166, 81, 127, 20);
		panelParticipante.add(txtRucParti);

		lblIdPedido = new JLabel("ID. Participante :");
		lblIdPedido.setBounds(10, 21, 116, 14);
		panelParticipante.add(lblIdPedido);
		
		cboParticipante = new JComboBox<Object>();
		cboParticipante.addItemListener(this);
		cboParticipante.setBounds(11, 35, 115, 22);
		panelParticipante.add(cboParticipante);

		panelPedido = new JPanel();
		panelPedido.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PEDIDO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPedido.setOpaque(false);
		panelPedido.setBounds(323, 11, 386, 78);
		contentPane.add(panelPedido);
		panelPedido.setLayout(null);

		lblPedido = new JLabel("Nro de Pedido :");
		lblPedido.setBounds(10, 21, 119, 14);
		panelPedido.add(lblPedido);

		txtObjetoPedido = new JTextField();
		txtObjetoPedido.setColumns(10);
		txtObjetoPedido.setBounds(124, 46, 115, 20);
		panelPedido.add(txtObjetoPedido);

		lblObjetoPedido = new JLabel("Objeto de pedido :");
		lblObjetoPedido.setBounds(10, 46, 119, 14);
		panelPedido.add(lblObjetoPedido);
		
		txtIdPedido = new JTextField();
		txtIdPedido.setBounds(124, 18, 115, 20);
		panelPedido.add(txtIdPedido);
		txtIdPedido.setColumns(10);

		panelPropuesta = new JPanel();
		panelPropuesta.setOpaque(false);
		panelPropuesta.setBounds(323, 94, 389, 66);
		contentPane.add(panelPropuesta);
		panelPropuesta.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROPUESTA",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPropuesta.setLayout(null);

		lblNumeroPostulacion = new JLabel("ID Propuesta:");
		lblNumeroPostulacion.setBounds(10, 22, 106, 14);
		panelPropuesta.add(lblNumeroPostulacion);

		txtPropuesta = new JTextField();
		txtPropuesta.setBounds(10, 36, 106, 20);
		panelPropuesta.add(txtPropuesta);

		lblFechaProp = new JLabel("FECHA:");
		lblFechaProp.setBounds(138, 22, 53, 14);
		panelPropuesta.add(lblFechaProp);

		dcFechaProp = new JDateChooser();
		dcFechaProp.setBounds(138, 36, 124, 20);
		panelPropuesta.add(dcFechaProp);

		txtEstado = new JTextField();
		txtEstado.setBounds(272, 36, 106, 20);
		panelPropuesta.add(txtEstado);
		txtEstado.setColumns(10);

		lblEstado_1 = new JLabel("ESTADO");
		lblEstado_1.setBounds(272, 13, 67, 14);
		panelPropuesta.add(lblEstado_1);

		btnNuevo = new JButton("LIMPIAR");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(23, 137, 89, 23);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(388, 171, 101, 23);
		contentPane.add(btnRegistrar);
				
		btnActualizar = new JButton("MODIFICAR");
		btnActualizar.setBounds(515, 171, 108, 23);
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		btnRegistrar.addActionListener(this);

		limpiar();
	}

	private void correlativo() {

		ArrayList<Propuesta> list = gProp.listarPropuestas();

		@SuppressWarnings("resource")
		Formatter ft = new Formatter();

		if (list.size() == 0) {
			txtPropuesta.setText("PR001");
		} else {
			String idProp = list.get(list.size() - 1).getCodPropuesta();

			int correlativo = Integer.parseInt(idProp.substring(2)) + 1;

			txtPropuesta.setText("PR" + ft.format("%03d", correlativo));

		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
	}



	private void cargarcboParticipantes() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<Participante> list = gPart.listarParticipante();
		if (list.size() == 0) {
			// Tool.mensajeError(null, "Lista vac�a");
		} else {
			cboParticipante.addItem("Seleccione...");
			for (Participante par : list) {
				cboParticipante.addItem(par.getCodParticipante());
			}
		}

	}

	private void cargarPedido() {
		
		Participante p = gPart.buscarXIdParticipante(getCodigoParticipante());
		

		if (p != null) {
			txtIdPedido.setText(p.getCodPedido());
			ArrayList<Object[]> listPed = gPed.reportePedido();
			
			for (Object[] ped:listPed) {
				if (ped[0].equals(p.getCodPedido())) {
					txtObjetoPedido.setText(ped[2].toString());
				}
			}
		} else {
			txtIdPedido.setText("");
		}

	}

	private String getCodigo() {
		return txtPropuesta.getText();
	}

	private String getCodigoParticipante() {
		try {
			return cboParticipante.getSelectedItem().toString();
		} catch (NullPointerException e) {
			return null;
		}

	}

	private String getCodigoPedido() {
		
		String res = null;
		
		if (txtIdPedido.getText().trim().length()==0) {
			Tool.mensajeError(this,"PedidoVacio !");
		}else {
			res = txtIdPedido.getText().trim();
		}
		
		return res;
	}

	private String getEstado() {
		return txtEstado.getText().toString();
	}

	private String getFechaProp() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fecha = sdf.format(dcFechaProp.getDate());
		return fecha;
	}

	private String getDescTec() {
		return txtPropTecnica.getText();
	}

	private String getDescEco() {
		return txtPropEconomica.getText();
	}

	// Busca propuesta por su c�digo
	private void buscarPropuesta() {
		String codigo;
		// 1 obtener el codigo ingresado
		codigo = getCodigoParticipante();
		// Validar
		if (codigo == null || codigo == "Seleccione...") {
			txtPropuesta.setText("");
			txtEstado.setText("REGISTRADO");
			dcFechaProp.setDate( new Date());
			txtPropTecnica.setText("");
			txtPropEconomica.setText("");
			correlativo();
			return;
		} else {
			// llamar al proceso
			Propuesta prop = gProp.buscarPropuesta(codigo);
			// Validar el resultado del proceso
			if (prop == null) {
				Tool.mensajeError(this, "Participante no cuenta con propuesta");
				txtPropuesta.setText("");
				txtEstado.setText("REGISTRADO");
				dcFechaProp.setDate( new Date());
				txtPropTecnica.setText("");
				txtPropEconomica.setText("");
				correlativo();
			} else {
				txtPropuesta.setText(prop.getCodPedido());
				txtPropTecnica.setText(prop.getPropTecnica());
				txtPropEconomica.setText(prop.getPropEconomica());
				txtEstado.setText(prop.getEstado());

				try {
					dcFechaProp.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(prop.getFecha()));
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
				Tool.mensajeError(this, "Error en la actualizaci�n");
			} else {
				Tool.mensajeExito(this, "Usuario actualizado");
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
				Tool.mensajeError(this, "Error en el registro");
			} else {
				Tool.mensajeExito(this, "Propuesta registrada");
				correlativo();
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboParticipante) {
			itemStateChangedCboParticipante(e);
		}
	}

	/* REVISA RICARDO */
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();

	}

	private void limpiar() {

		txtEstado.setText("REGISTRADO");
		txtEstado.setEditable(false);
		dcFechaProp.setDate(new Date());
		txtObjetoPedido.setEditable(false);
		txtEntidadParti.setEditable(false);
		txtRucParti.setEditable(false);
		dcFechaProp.setDate(new Date());
		txtObjetoPedido.setText("");
		txtEntidadParti.setText("");
		txtRucParti.setText("");
		dcFechaProp.setDate(new Date());
		txtPropTecnica.setText("");
		txtPropEconomica.setText("");
		txtIdPedido.setEditable(false);
		cargarcboParticipantes();
		/* ESTOS METODOS ESTABAN EN EL CONSTRUCTOR */
		/*
		 * EL METODO LIMPIAR TENDRA LOS METODOS QUE SE INICIALIZAR Y TAMBIEN DENTRO DEL
		 * BOTON NUEVO
		 */

		correlativo();
	}

	private void buscarDatosParticipante() {
		Participante p = gPart.buscarXIdParticipante(getCodigoParticipante());
		if (p != null) {
			txtEntidadParti.setText(p.getEntidad());
			txtRucParti.setText(p.getRuc());
		} else {
			txtEntidadParti.setText("");
			txtRucParti.setText("");
		}
		
	}
	protected void itemStateChangedCboParticipante(ItemEvent e) {
		buscarDatosParticipante();
		buscarPropuesta();
		cargarPedido();
	}
}
