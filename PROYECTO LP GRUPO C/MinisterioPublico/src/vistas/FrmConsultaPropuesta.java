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
import javax.swing.JEditorPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaPropuesta extends JInternalFrame implements ActionListener, MouseListener {

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
	private JEditorPane txtPropTecnica;
	private JEditorPane txtPropEconomica;
	private JLabel lblPropEconomica;
	private JLabel lblPropTecnica;

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
		setBounds(100, 100, 744, 409);
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
		scrollPane.setBounds(10, 81, 446, 287);
		contentPane.add(scrollPane);

		tblPropuestas = new JTable();
		tblPropuestas.addMouseListener(this);
		tblPropuestas.setFillsViewportHeight(true);
		tblPropuestas.setModel(model);
		scrollPane.setViewportView(tblPropuestas);

		// crear collumnas para la tabla
		model.addColumn("ID Pedido");
		model.addColumn("ID Propuesta");
		model.addColumn("ID Participante");
		model.addColumn("Fecha");
		model.addColumn("Estado");
		// Asociar table con objeto model
		tblPropuestas.setModel(model);
		
		txtPropTecnica = new JEditorPane();
		txtPropTecnica.setBounds(466, 88, 252, 128);
		contentPane.add(txtPropTecnica);
		
		txtPropEconomica = new JEditorPane();
		txtPropEconomica.setBounds(466, 240, 252, 128);
		contentPane.add(txtPropEconomica);
		
		lblPropEconomica = new JLabel("Propuesta economica");
		lblPropEconomica.setBounds(466, 227, 172, 14);
		contentPane.add(lblPropEconomica);
		
		lblPropTecnica = new JLabel("Propuesta tecnica");
		lblPropTecnica.setBounds(466, 73, 172, 14);
		contentPane.add(lblPropTecnica);

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
			Tool.mensajeError(null, "Lista vacía");
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
			Object fila[] = { prop.getCodPedido(),
					prop.getCodPropuesta(),
					prop.getCodParticipante(),
					prop.getFecha(),
					prop.getEstado() };
			
			
			
			// añadir fila a la tabla
			model.addRow(fila);
		}
	}

	// método encargado de cargar los datos desde la BD a la tabla
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
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblPropuestas) {
			mouseClickedTblPropuestas(e);
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
	protected void mouseClickedTblPropuestas(MouseEvent e) {
		int indice = tblPropuestas.getSelectedRow();
		
		String idProp = tblPropuestas.getValueAt(indice,1).toString();
		
		ArrayList<Propuesta> list = gProp.listarPropuestas();
		
		for(Propuesta prop : list) {
			if(prop.getCodPropuesta().equals(idProp)) {
				txtPropTecnica.setText(prop.getPropTecnica());
				txtPropEconomica.setText(prop.getPropEconomica());
			}
		}
	}
}
