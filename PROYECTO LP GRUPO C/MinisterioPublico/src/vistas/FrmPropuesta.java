package vistas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import clases.Propuesta;
import mantenimiento.PropuestaDAO;
import utils.Tool;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmPropuesta extends JInternalFrame implements ActionListener {

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
	private JTextField txtParticipante;
	private JTextField txtPedido;
	
	PropuestaDAO gProp = new PropuestaDAO();
	
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Admitido", "No admitido"}));
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
		btnBuscar.setBounds(446, 70, 102, 22);
		contentPane.add(btnBuscar);
		
		fechaProp = new JDateChooser();
		fechaProp.setBounds(482, 37, 126, 20);
		fechaProp.setEnabled(false);
		contentPane.add(fechaProp);
		
		lblFechaProp = new JLabel("FECHA:");
		lblFechaProp.setBounds(388, 39, 53, 14);
		contentPane.add(lblFechaProp);
		
		txtParticipante = new JTextField();
		txtParticipante.setEnabled(false);
		txtParticipante.setBounds(145, 36, 115, 20);
		contentPane.add(txtParticipante);
		
		txtPedido = new JTextField();
		txtPedido.setEnabled(false);
		txtPedido.setBounds(145, 8, 115, 20);
		contentPane.add(txtPedido);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarPropuesta();
	}
	
	private String getCodigo() {
		return txtPropuesta.getText();
	}
	
	private String getEstado() {
		return cboEstado.getSelectedItem().toString();
	}
	
	// Busca propuesta por su cÛdigo
	private void buscarPropuesta() {
		String codigo;
		// 1 obtener el codigo ingresado
		codigo = getCodigo();
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
				txtPedido.setText(prop.getCodPedido());
				txtParticipante.setText(prop.getCodParticipante());
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
}
