package vistas;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import mantenimiento.*;
import utils.Tool;
import clases.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmBuscarApelacion extends JDialog implements MouseListener, KeyListener, ActionListener{
	private JTable tbApelaciones;
	private JTextArea txtDescripcion;
	private JLabel lblDescripcion;
	private JButton btnSeleccionar;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private ApelacionDAO apelDao;
	
	
	public static void main(String [] args) {
		
		FrmBuscarPedido form = new FrmBuscarPedido();
		form.setVisible(true);

	}
	
	public FrmBuscarApelacion() {
		
		
		setTitle("Buscar apelacion");
		setBounds(100,100,579,278);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		model = new DefaultTableModel();
		model.addColumn("ID APELACION");
		model.addColumn("ID PROPUESTA");
		model.addColumn("FECHA");
		model.addColumn("ESTADO");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 332, 210);
		getContentPane().add(scrollPane);
		
		tbApelaciones = new JTable();
		tbApelaciones.addKeyListener(this);
		tbApelaciones.addMouseListener(this);
		scrollPane.setViewportView(tbApelaciones);
		
		tbApelaciones.setModel(model);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBorder(new EmptyBorder(8,8,8,8));
		txtDescripcion.setBounds(352, 78, 201, 147);
		getContentPane().add(txtDescripcion);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(352, 53, 88, 14);
		getContentPane().add(lblDescripcion);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(400, 19, 122, 23);
		getContentPane().add(btnSeleccionar);
		
		apelDao= new ApelacionDAO();
		
		arranque();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSeleccionar) {
			actionPerformedBtnSeleccionar(e);
		}
	}
	protected void actionPerformedBtnSeleccionar(ActionEvent e) {
		exportarDatos();
		this.dispose();
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbApelaciones) {
			mouseClickedTbPedidos(e);
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
	protected void mouseClickedTbPedidos(MouseEvent e) {
		cargarDescripcion();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tbApelaciones) {
			keyReleasedTbPedidos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTbPedidos(KeyEvent e) {
		cargarDescripcion();
	}
	
	//METODOS ADICIONALES
	
	private void arranque() {
		cargarTabla();
	}
	
	private void cargarTabla() {
		ArrayList<Apelacion> listPed = apelDao.listarApelacion();
		
		model.setRowCount(0);
		
		for(Apelacion apel : listPed) {
			
			if (apel.getEstado().equals("REGISTRADO")) {
				Object [] x = {
						apel.getCodApelacion(),
						apel.getCodPropuesta(),
						apel.getFecha(),
						apel.getEstado()
				};
				model.addRow(x);
			}else if(tbApelaciones.getRowCount()==0) {
				Tool.mensajeError(this, "No hay registro de apelacion pendientes");
				btnSeleccionar.setEnabled(false);
			}

		}
	}
	
	private void cargarDescripcion() {
		String idApelacion = tbApelaciones.getValueAt(tbApelaciones.getSelectedRow(),0).toString();
		
		Apelacion apel = apelDao.buscarXIdApelacion(idApelacion);
		
		txtDescripcion.setText(apel.getDescripcion());
	}
	
	private void exportarDatos() {
		
		String idApelacion = tbApelaciones.getValueAt(tbApelaciones.getSelectedRow(),0).toString();
		
		FrmProyectoPronunciamientoApelacion.txtIdApelacion.setText(idApelacion);
	}
	



}
