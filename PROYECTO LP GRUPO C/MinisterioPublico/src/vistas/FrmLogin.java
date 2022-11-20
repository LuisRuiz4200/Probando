package vistas;

import javax.swing.*;

import clases.Usuario;
import mantenimiento.UsuarioDAO;
import utils.Tool;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class FrmLogin extends JFrame implements ActionListener{
	private JLabel lblUsuario;
	private static JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JLabel lblPassword;
	private JButton btnIngresar;
	private JButton btnCancelar;
	public static Usuario user = new Usuario();
	private UsuarioDAO usuarioDao;
	private JLabel lblNewLabel;
	
	
	public static void main(String [] args) {
		
		FrmLogin form = new FrmLogin();
		form.setVisible(true);
		
	}
	
	public FrmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/imagenes/logo3.jpg")));
		
		setTitle("LOGIN");
		setBounds(100,100,468,300);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setIcon(new ImageIcon(FrmLogin.class.getResource("/imagenes/login/iconoLoginUsuario32x32.png")));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(10, 11, 136, 32);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 49, 171, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(10, 117, 171, 20);
		getContentPane().add(txtPassword);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setIcon(new ImageIcon(FrmLogin.class.getResource("/imagenes/login/iconoLoginPassword32x32.png")));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 80, 192, 32);
		getContentPane().add(lblPassword);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(10, 156, 89, 23);
		getContentPane().add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(122, 156, 89, 23);
		getContentPane().add(btnCancelar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/imagenes/login/fondoLogin.jpeg")));
		lblNewLabel.setBounds(0, 0, 452, 261);
		getContentPane().add(lblNewLabel);
		
		
		usuarioDao = new UsuarioDAO();
		
		
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
		
	
		
		@SuppressWarnings("deprecation")
		String password = txtPassword.getText();
		String usuario = txtUsuario.getText();	
	
		
		user =  usuarioDao.validarAcceso(usuario, password);
		
		if (user == null) {
			Tool.mensajeError(this,"Usuario y/o contraseña incorrecta");
			return ;
		}else {
			Tool.mensajeExito(this,"Bienvenido " + user.getNombreUsuario());
			FrmPrincipal form = new FrmPrincipal();
			form.setVisible(true);
			form.setLocationRelativeTo(this);
			this.dispose();
		}
		
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		limpiar();
	}
	
	private void limpiar () {
		txtUsuario.setText("");
		txtPassword.setText("");
	}
}
