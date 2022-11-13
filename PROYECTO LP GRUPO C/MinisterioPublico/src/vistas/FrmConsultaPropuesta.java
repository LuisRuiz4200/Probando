package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import clases.*;

import mantenimiento.*;
import utils.Tool;

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaPropuesta extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnExportar;
	private JButton btnBuscar;
	private JLabel lblNumeroPedido;
	private JComboBox<Object> cboPedido;
	private JTable tblPropuestas;
	private JScrollPane scrollPane;

	private PropuestaDAO gProp = new PropuestaDAO();
	private PedidoDAO gPed = new PedidoDAO();

	// estructura de la tabla
	private DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaPropuesta frame = new FrmConsultaPropuesta();
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
	public FrmConsultaPropuesta() {
		setTitle("Consulta de propuestas");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnExportar = new JButton("Exportar");
		btnExportar.setBounds(518, 24, 89, 31);
		contentPane.add(btnExportar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(381, 24, 89, 31);
		contentPane.add(btnBuscar);

		lblNumeroPedido = new JLabel("Numero de Pedido:");
		lblNumeroPedido.setBounds(10, 32, 138, 14);
		contentPane.add(lblNumeroPedido);

		cboPedido = new JComboBox<Object>();
		cboPedido.setBounds(141, 28, 138, 22);
		contentPane.add(cboPedido);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 654, 287);
		contentPane.add(scrollPane);

		tblPropuestas = new JTable();
		tblPropuestas.setFillsViewportHeight(true);
		tblPropuestas.setModel(model);
		scrollPane.setViewportView(tblPropuestas);

		// crear collumnas para la tabla
		model.addColumn("ID Pedido");
		model.addColumn("ID Propuesta");
		model.addColumn("ID Participante");
		model.addColumn("Fecha Propuesta");
		model.addColumn("Desc. T�cnica");
		model.addColumn("Desc. Econ�mica");
		model.addColumn("Estado");
		// Asociar table con objeto model
		tblPropuestas.setModel(model);

		arranque();

	}

	private void arranque() {
		cargarcboPedidos();
		cargarDataPropuestas();
	}

	private void cargarcboPedidos() {
		// 1. Obtener el resultado del proceso -- listar
		ArrayList<Pedido> list = gPed.listarPedido();
		// 2. Validar el resultado del proceso
		if (list.size() == 0) {
			Tool.mensajeError(null, "Lista vac�a");
		} else {
			cboPedido.addItem("Seleccione ... ");
			for (Pedido ped : list) {
				cboPedido.addItem(ped.getCodigo());
			}
		}

	}
	
	private void cargarTabla(ArrayList<Propuesta> list) {
		model.setRowCount(0);
		for (Propuesta prop : list) {
			Object fila[] = { prop.getCodPedido(), prop.getCodPropuesta(), prop.getCodParticipante(), prop.getFecha(), prop.getPropTecnica(), prop.getPropEconomica(), prop.getEstado() };
			// a�adir fila a la tabla
			model.addRow(fila);
		}
	}

	// m�todo encargado de cargar los datos desde la BD a la tabla
	private void cargarDataPropuestas() {
		ArrayList<Propuesta> list = gProp.listarPropuestas();
		cargarTabla(list);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarPropuestasXPedido();
	}
	
	private String getCodPedido() {
		return cboPedido.getSelectedItem().toString();
	}
	
	private void buscarPropuestasXPedido() {
		String codPedido = getCodPedido();
		
		ArrayList<Propuesta> list = gProp.buscarXPedido(codPedido);
		cargarTabla(list);
	}
	
}
