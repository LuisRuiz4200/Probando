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
public class FrmBuscarPropuesta extends JDialog implements MouseListener, KeyListener, ActionListener{
	private JTable tbPropuestas;
	private JButton btnSeleccionar;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private PropuestaDAO propDao;
	private ApelacionDAO apelDao;
	public static int indice ;
	
	public static void main(String [] args) {
		
		FrmBuscarPedido form = new FrmBuscarPedido();
		form.setVisible(true);

	}
	
	public FrmBuscarPropuesta() {
		
		
		setTitle("Buscar propuesta");
		setBounds(100,100,541,278);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ID PROPUESTA");
		model.addColumn("ID PARTICIPANTE");
		model.addColumn("FECHA");
		model.addColumn("ESTADO");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 497, 172);
		getContentPane().add(scrollPane);
		
		tbPropuestas = new JTable();
		tbPropuestas.addKeyListener(this);
		tbPropuestas.addMouseListener(this);
		scrollPane.setViewportView(tbPropuestas);
		
		tbPropuestas.setModel(model);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(386, 19, 122, 23);
		getContentPane().add(btnSeleccionar);
		
		propDao= new PropuestaDAO();
		apelDao = new ApelacionDAO();
		
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
		if (e.getSource() == tbPropuestas) {
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

	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tbPropuestas) {
			keyReleasedTbPedidos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTbPedidos(KeyEvent e) {
		
	}
	
	//METODOS ADICIONALES
	
	private void arranque() {
		cargarTabla();
	}
	
	private void cargarTabla() {
		ArrayList<Propuesta> listProp = propDao.listarPropuestas();
		ArrayList<Apelacion> listApel = apelDao.listarApelacion();
		int bandera = 0; 
		
		model.setRowCount(0);
		
		for(Propuesta prop : listProp) {
			
			int existe = 0;
			
			for (Apelacion apel : listApel) {
				if (prop.getCodPropuesta().equals(apel.getCodPropuesta())) {
					existe = 2;
				}
			}
			
			
			if (existe !=2) {
				if(prop.getEstado().matches("[O][B][S].+")) {
					Object [] x = {
							prop.getCodPedido(),
							prop.getCodPropuesta(),
							prop.getCodParticipante(),
							prop.getFecha(),
							prop.getEstado()
					};
					
					model.addRow(x);
					bandera = 1;
				}
			}

		}
		
		
		if (bandera == 0) {
			Tool.mensajeError(this, "No hay propuestas pendientes para presentar apelacion");
			btnSeleccionar.setEnabled(false);
		}
	}
	
	private void exportarDatos() {
		
		String idPropuesta = tbPropuestas.getValueAt(tbPropuestas.getSelectedRow(),1).toString();
		String estadoPropuesta =  tbPropuestas.getValueAt(tbPropuestas.getSelectedRow(),4).toString();
		
		FrmApelacion.txtIdPropuesta.setText(idPropuesta);
		FrmApelacion.txtEstadoPropuesta.setText(estadoPropuesta);
	}
	



}
