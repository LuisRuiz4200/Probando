package vistas;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmLogin extends JFrame implements ActionListener{
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JLabel lblPassword;
	private JButton btnIngresar;
	private JButton btnCancelar;
	
	
	
	public static void main(String [] args) {
		
		FrmLogin form = new FrmLogin();
		form.setVisible(true);
		
	}
	
	public FrmLogin() {
		
		setTitle("LOGIN");
		setBounds(100,100,269,287);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(10, 24, 106, 14);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 49, 171, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(10, 106, 171, 20);
		getContentPane().add(txtPassword);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 81, 106, 14);
		getContentPane().add(lblPassword);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(10, 156, 89, 23);
		getContentPane().add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(122, 156, 89, 23);
		getContentPane().add(btnCancelar);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		
		String usuario = txtUsuario.getText();
		
		String password = txtPassword.getSelectedText();
		
		StringBuilder [] users = {"luis","francisco"};
		
		
		
		if (usuario.equals(users)) {
			FrmPrincipal form = new FrmPrincipal();
			form.setVisible(true);
			form.setLocationRelativeTo(this);
			this.dispose();
		}
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
	}
}
