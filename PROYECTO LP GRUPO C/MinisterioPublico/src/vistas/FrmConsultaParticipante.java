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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaParticipante extends JInternalFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JButton btnExportar;
	private JButton btnBuscar;
	private DefaultTableModel model; 
	private JLabel lblNumeroPedido;
	private JComboBox<Object> cboPedido;
	private JTable tbParticipantes;
	private JScrollPane scrollPane;
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private JLabel lblIdParticipante;
	private JTextField txtIdParticipante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaParticipante frame = new FrmConsultaParticipante();
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
	public FrmConsultaParticipante() {
		setTitle("Consulta de participantes");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(this);
		btnExportar.setBounds(518, 24, 89, 31);
		contentPane.add(btnExportar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(381, 24, 89, 31);
		contentPane.add(btnBuscar);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("ENTIDAD");
		model.addColumn("RUC");
		model.addColumn("CORREO");
		model.addColumn("TELEFONO");
		model.addColumn("ESTADO");
		
		lblNumeroPedido = new JLabel("Numero de Pedido:");
		lblNumeroPedido.setBounds(10, 32, 138, 14);
		contentPane.add(lblNumeroPedido);
		
		cboPedido = new JComboBox<Object>();
		cboPedido.setBounds(141, 28, 138, 22);
		contentPane.add(cboPedido);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 654, 249);
		contentPane.add(scrollPane);
		
		tbParticipantes = new JTable();
		tbParticipantes.setFillsViewportHeight(true);
		tbParticipantes.setModel(model);
		scrollPane.setViewportView(tbParticipantes);
		
		lblIdParticipante = new JLabel("ID Participante");
		lblIdParticipante.setBounds(10, 67, 101, 14);
		contentPane.add(lblIdParticipante);
		
		txtIdParticipante = new JTextField();
		txtIdParticipante.addKeyListener(this);
		txtIdParticipante.setBounds(141, 64, 138, 20);
		contentPane.add(txtIdParticipante);
		txtIdParticipante.setColumns(10);
		
		
		partDao= new ParticipanteDAO();
		pedDao = new PedidoDAO();
		
		
		arranque();
		
	}
	private void arranque() {
		
		cargarCboPedido();
		cargarTabla();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExportar) {
			actionPerformedBtnExportar(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		cargarTablaXPedido();
	}
	
	
	protected void actionPerformedBtnExportar(ActionEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtIdParticipante) {
			keyReleasedTxtIdParticipante(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtIdParticipante(KeyEvent e) {
	}
	
	
	private void cargarTablaXParticipante() {
		String idParticipante = txtIdParticipante.getText().trim();
		
		
		ArrayList <Participante> list = partDao.buscarXIdParticipante(String.valueOf(idParticipante.charAt(0)));
			
		model.setRowCount(0);
		
		for (Participante part : list) {
			Object [] x = {
					part.getCodPedido(),
					part.getCodParticipante(),
					part.getEntidad(),
					part.getRuc(),
					part.getCorreo(),
					part.getTelefono(),
					part.getEstado()
				};
				
				model.addRow(x);
		}
	}
	
	private void cargarTablaXPedido() {
		
		String idPedido= cboPedido.getSelectedItem().toString();
	
		ArrayList <Participante> list = partDao.buscarXPedido(idPedido);
			
		model.setRowCount(0);
		
		for (Participante part : list) {
			Object [] x = {
					part.getCodPedido(),
					part.getCodParticipante(),
					part.getEntidad(),
					part.getRuc(),
					part.getCorreo(),
					part.getTelefono(),
					part.getEstado()
				};
				
				model.addRow(x);
		}
		
	}
	
	private void cargarCboPedido() {
		
		ArrayList<Pedido> list = pedDao.listarPedido();
		
		cboPedido.removeAllItems();
		cboPedido.addItem("SELECCIONE..");
		
		for (Pedido ped: list) {
			
			cboPedido.addItem(ped.getCodigo());
			
		}
	}
	
	private void cargarTabla() {
		String idPedido= cboPedido.getSelectedItem().toString();
		
		ArrayList <Participante> list = partDao.listarParticipante();
			
		model.setRowCount(0);
		
		for (Participante part : list) {
			
			Object [] x = {
					part.getCodPedido(),
					part.getCodParticipante(),
					part.getEntidad(),
					part.getRuc(),
					part.getCorreo(),
					part.getTelefono(),
					part.getEstado()
				};
				
				model.addRow(x);
		}
	}
	
}
