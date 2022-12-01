package vistas;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import mantenimiento.*;
import clases.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmBuscarPedido extends JFrame implements MouseListener, KeyListener{
	private JTable tbPedidos;
	private JTextArea txtDescripcion;
	private JLabel lblDescripcion;
	private JButton btnSeleccionar;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private PedidoDAO pedDao;
	
	
	public static void main(String [] args) {
		
		FrmBuscarPedido form = new FrmBuscarPedido();
		form.setVisible(true);
		
	}
	
	public FrmBuscarPedido() {
		
		setTitle("Buscar pedido");
		setBounds(100,100,579,278);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		model = new DefaultTableModel();
		model.addColumn("ID PEDIDO");
		model.addColumn("ENTIDAD");
		model.addColumn("TIPO");
		model.addColumn("OBJETO");
		model.addColumn("DESCRIPCION");
		model.addColumn("FECHA");
		model.addColumn("ESTADO");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 332, 210);
		getContentPane().add(scrollPane);
		
		tbPedidos = new JTable();
		tbPedidos.addKeyListener(this);
		tbPedidos.addMouseListener(this);
		scrollPane.setViewportView(tbPedidos);
		
		tbPedidos.setModel(model);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBorder(new EmptyBorder(8,8,8,8));
		txtDescripcion.setBounds(352, 78, 201, 147);
		getContentPane().add(txtDescripcion);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(352, 53, 88, 14);
		getContentPane().add(lblDescripcion);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(400, 19, 122, 23);
		getContentPane().add(btnSeleccionar);
		
		pedDao= new PedidoDAO();
		
		arranque();
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbPedidos) {
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
		if (e.getSource() == tbPedidos) {
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
		ArrayList<Pedido> listPed = pedDao.listarPedido();
		
		model.setRowCount(0);
		
		for(Pedido ped : listPed) {
			
			Object [] x = {
				ped.getCodigo(),
				ped.getEntidad()
			};
			
			model.addRow(x);
		}
	}
	
	private void cargarDescripcion() {
		String idPedido = tbPedidos.getValueAt(tbPedidos.getSelectedRow(),0).toString();
		
		Pedido ped = pedDao.buscarXIdPedido(idPedido);
		
		txtDescripcion.setText(ped.getDescripcion());
	}
	


}
