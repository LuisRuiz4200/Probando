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
import java.util.Date;
import java.awt.event.ActionEvent;

import clases.*;

import mantenimiento.*;
import utils.Tool;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings({ "serial", "unused" })
public class FrmReportePropuesta extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private DefaultTableModel model; 
	
	private PedidoDAO pedDao;
	private ParticipanteDAO partDao;
	private JDateChooser dcFechaInicio;
	private JDateChooser dcFechaFin;
	private JTable table;
	private JButton btnReporte;
	private JButton btnExportar;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFin;
	private PropuestaDAO propDao;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReportePropuesta frame = new FrmReportePropuesta();
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
	public FrmReportePropuesta() {
		setTitle("Reporte de propuestas");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dcFechaInicio = new JDateChooser();
		dcFechaInicio.setBounds(36, 33, 124, 20);
		contentPane.add(dcFechaInicio);
		
		dcFechaFin = new JDateChooser();
		dcFechaFin.setBounds(222, 33, 124, 20);
		contentPane.add(dcFechaFin);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 654, 275);
		contentPane.add(scrollPane);
		
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ID PROPUESTA");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("FECHA PROP");
		model.addColumn("ESTADO DE PROPUESTA");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(395, 59, 109, 23);
		contentPane.add(btnReporte);
		
		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(this);
		btnExportar.setBounds(524, 59, 109, 23);
		contentPane.add(btnExportar);
		
		lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setBounds(36, 16, 89, 14);
		contentPane.add(lblFechaInicio);
		
		lblFechaFin = new JLabel("FECHA FIN ");
		lblFechaFin.setBounds(222, 16, 98, 14);
		contentPane.add(lblFechaFin);
		
	
		
		
		partDao= new ParticipanteDAO();
		pedDao = new PedidoDAO();
		propDao = new PropuestaDAO();
		
		
		
	}
	private void arranque() {
	
		dcFechaInicio.setDate(new Date());
		dcFechaFin.setDate(new Date());
		
	}

	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExportar) {
			actionPerformedBtnExportar(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		
		String fechaInicio= leerFechaInicio();
		String fechaFin = leerFechaFin();
		
		if (fechaInicio == null || fechaFin == null) {
			return;
		}else {
			cargarTablaXFecha(fechaInicio, fechaFin);
			
			
		}
		
	}
	protected void actionPerformedBtnExportar(ActionEvent e) {
	}
	
	
	//METODOS DE ENTRADA 
	
	private String leerFechaInicio() {
		String res = null;
		
		res = Tool.sdf.format(dcFechaInicio.getDate()).toString();
		
		return res;
	}
	
	private String leerFechaFin() {
		String res = null;
		
		res = Tool.sdf.format(dcFechaFin.getDate()).toString();
		
		return res;
	}
	
	//METODOS ADICIONALES
	
	private void cargarTablaXFecha (String fechaIni, String fechaFin) {
		
		ArrayList<Propuesta> listProp = propDao.reporteXFecha(fechaIni, fechaFin);
		
		model.setRowCount(0);
		
		if (listProp.size()==0) {
			Tool.mensajeError(this, "No se econtraron registro dentro del rango de fechas");
			return;
		}else {
			
			for (Propuesta  prop : listProp) {
				Object [] x = {
						
						prop.getCodPedido(),
						prop.getCodPropuesta(),
						prop.getCodParticipante(),
						prop.getFecha(),
						prop.getEstado()
						
				};
				
				model.addRow(x);
			}
		}
		
		
		
	}
	
	}
