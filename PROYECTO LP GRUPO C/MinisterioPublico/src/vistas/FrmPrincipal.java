package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener  {

	private JDesktopPane escritorio;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnConsulta;
	private JMenu mnTransaccion;
	private JMenu mnReporte;
	private JMenu mnAyuda;
	private JMenuItem mniSalir;
	private JMenuItem mniSolucionApelacion;
	private JMenuItem mniResultadoPostulacion;
	private JLabel lblImgFonfo;
	private JMenuItem mniParticipante;
	private JMenuItem mniPropuesta;
	private JMenuItem mniApelacion;
	private JMenuItem mniPedido;
	private JMenuItem mniConsultaParticipante;
	private JMenuItem mniQuienesSomos;
	private JMenuItem mniActasPropuestas;
	private JMenuItem mntmComite;
	private JMenuItem mniConsultaPropusta;
	private JMenuItem mniReportePropuesta;
	private JMenuItem mniUsuario;
	private JMenuItem mntmConsultaApelacion;
	
	
	public static void main (String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal prin = new FrmPrincipal();
					prin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrmPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/imagenes/logo3.jpg")));
		setTitle("FrmPrincipal " + FrmLogin.user.getNombreUsuario());
		setBounds(100,100,877,586);
		setLocationRelativeTo(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.gray);
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		lblImgFonfo = new JLabel("");
		lblImgFonfo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/banner5.jpg")));
		lblImgFonfo.setBounds(0, 0, 861, 517);
		escritorio.add(lblImgFonfo);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/carpeta.png")));
		menuBar.add(mnArchivo);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/personal-de-mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/buscando.png")));
		menuBar.add(mnConsulta);
		
		mnTransaccion = new JMenu("Transacci\u00F3n");
		mnTransaccion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/transaccion.png")));
		menuBar.add(mnTransaccion);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/reporte (1).png")));
		menuBar.add(mnReporte);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagenes/iconos_24x24/mano-amiga.png")));
		menuBar.add(mnAyuda);
		
		mniSalir = new JMenuItem("Salir");
		mniSalir.addActionListener(this);
		
		mniUsuario = new JMenuItem("Gestion de usuarios");
		mniUsuario.addActionListener(this);
		mnArchivo.add(mniUsuario);
		mnArchivo.add(mniSalir);
		
		mniResultadoPostulacion = new JMenuItem("Puntaje en la evaluacion de propuestas");
		mniResultadoPostulacion.addActionListener(this);
		mnTransaccion.add(mniResultadoPostulacion);
		
		mniActasPropuestas = new JMenuItem("Actas de propuestas");
		mniActasPropuestas.addActionListener(this);
		mnTransaccion.add(mniActasPropuestas);
		
		mniSolucionApelacion = new JMenuItem("Solucion de apelaciones");
		mniSolucionApelacion.addActionListener(this);
		mnTransaccion.add(mniSolucionApelacion);
		
		
		mniPedido = new JMenuItem ("Pedidos");
		mniPedido.addActionListener(this);
		mnMantenimiento.add(mniPedido);
		
		mniParticipante = new JMenuItem ("Pariticipantes");
		mniParticipante.addActionListener(this);
		
		mntmComite = new JMenuItem("Comite de Seleccion");
		mntmComite.addActionListener(this);
		mnMantenimiento.add(mntmComite);
		mnMantenimiento.add(mniParticipante);
		
		mniPropuesta = new JMenuItem("Propuestas");
		mniPropuesta.addActionListener(this);
		mnMantenimiento.add(mniPropuesta);
		
		mniApelacion = new JMenuItem("Apelaciones");
		mniApelacion.addActionListener(this);
		mnMantenimiento.add(mniApelacion);
		
		
		mniConsultaParticipante = new JMenuItem("Consulta de participantes");
		mniConsultaParticipante.addActionListener(this);
		mnConsulta.add(mniConsultaParticipante);
		
		mniConsultaPropusta = new JMenuItem("Consulta de propuestas");
		mniConsultaPropusta.addActionListener(this);
		mnConsulta.add(mniConsultaPropusta);
		
		mntmConsultaApelacion = new JMenuItem("Consulta Apelacion");
		mntmConsultaApelacion.addActionListener(this);
		mnConsulta.add(mntmConsultaApelacion);
		
		mniReportePropuesta = new JMenuItem("Reporte de propuestas");
		mniReportePropuesta.addActionListener(this);
		mnReporte.add(mniReportePropuesta);
		
		mniQuienesSomos = new JMenuItem("Quienes somos");
		mniQuienesSomos.addActionListener(this);
		mnAyuda.add(mniQuienesSomos);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmConsultaApelacion) {
			actionPerformedMntmConsultaApelacion(e);
		}
		if (e.getSource() == mniUsuario) {
			actionPerformedMniUsuario(e);
		}
		if (e.getSource() == mniReportePropuesta) {
			actionPerformedMniReportePropuesta(e);
		}
		if (e.getSource() == mniConsultaPropusta) {
			actionPerformedMniConsultaPropusta(e);
		}
		if (e.getSource() == mntmComite) {
			actionPerformedMntmComite(e);
		}
		if (e.getSource() == mniActasPropuestas) {
			actionPerformedMniActasPropuestas(e);
		}
		if (e.getSource() == mniResultadoPostulacion) {
			actionPerformedMniResultadoPostulacion(e);
		}
		if(e.getSource() == mniSolucionApelacion) {
			actionPerformedMniSolucionApelacion(e);
		}
		if(e.getSource() == mniSalir) {
			actionPerformedMniSalir(e);
		}
		if(e.getSource()==mniParticipante) {
			actionPerformedMniParticipante(e);
		}
		if(e.getSource()==mniPropuesta) {
			actionPerformedMniPostulacion(e);
		}
		if(e.getSource()==mniApelacion) {
			actionPerformedMniApelacion(e);
		}
		if(e.getSource()==mniPedido) {
			actionPerformedMniPedido(e);
		}
		if(e.getSource()==mniConsultaParticipante) {
			actionPerformedMniConsultaParticipante(e);
		}
		
		if(e.getSource()==mniQuienesSomos) {
			actionPerformedMniQuienesSomos(e);
		}
	}
	
	//ARCHIVO
	
	protected void actionPerformedMniSalir(ActionEvent e) {
		
		FileDialog fd = new FileDialog(new Frame(),"SELECCIONA UN ARCHIVO",FileDialog.LOAD);
		fd.setVisible(true);
		
		
		fd.setFilenameFilter(null);
		String file = fd.getFile();
		
		System.out.println(file);
		/**int dialog = (int) JOptionPane.showConfirmDialog(this,"Seguro quiere salir ?", "CERRANDO", JOptionPane.YES_NO_OPTION,2);
		if(dialog == 0) {
			System.exit(0);
		}*/
	}
	

	protected void actionPerformedMniUsuario(ActionEvent e) {
		FrmUsuario user = new FrmUsuario();
		user.setVisible(true);
		escritorio.add(user).setLocation(0,0);
		user.toFront();
	}
	
	//MANTENIMIENTO
	
	protected void actionPerformedMniPostulacion(ActionEvent e) {
		FrmPropuesta post= new FrmPropuesta ();
		post.setVisible(true);
		escritorio.add(post).setLocation(0,0);
		post.toFront();
	}
	
	protected void actionPerformedMniParticipante(ActionEvent e) {
		FrmParticipante parti= new FrmParticipante ();
		parti.setVisible(true);
		escritorio.add(parti).setLocation(0,0);
		parti.toFront();
		
	}
	
	protected void actionPerformedMniApelacion(ActionEvent e) {
		FrmApelacion apel= new FrmApelacion ();
		apel.setVisible(true);
		escritorio.add(apel).setLocation(0,0);
		apel.toFront();
	}
	
	protected void actionPerformedMniPedido(ActionEvent e) {
		FrmPedido pedido=new FrmPedido ();
		pedido.setVisible(true);
		escritorio.add(pedido).setLocation(0,0);
		pedido.toFront();
	}

	
	//CONSULTA
	
	protected void actionPerformedMniConsultaParticipante(ActionEvent e) {
		FrmConsultaParticipante conParti= new FrmConsultaParticipante();
		conParti.setVisible(true);
		escritorio.add(conParti).setLocation(0,0);
		conParti.toFront();
	}	
	
	protected void actionPerformedMniConsultaPropusta(ActionEvent e) {
		
		FrmConsultaPropuesta conProp = new FrmConsultaPropuesta();
		conProp.setVisible(true);
		escritorio.add(conProp).setLocation(0,0);
		conProp.toFront();
		
	}
	
	protected void actionPerformedMntmConsultaApelacion(ActionEvent e) {
		FrmConsultaApelacion conApe = new FrmConsultaApelacion();
		conApe.setVisible(true);
		escritorio.add(conApe).setLocation(0,0);
		conApe.toFront();
	}
	
	//TRANSACCION
	
	
	protected void actionPerformedMniResultadoPostulacion(ActionEvent e) {	
		FrmPuntajePropuesta resPos= new FrmPuntajePropuesta();
		resPos.setVisible(true);
		escritorio.add(resPos).setLocation(0,0);
		resPos.toFront();
		
	}
	protected void actionPerformedMniSolucionApelacion(ActionEvent e) {
		FrmProyectoPronunciamientoApelacion solApel= new FrmProyectoPronunciamientoApelacion();
		solApel.setVisible(true);
		escritorio.add(solApel).setLocation(0,0);;
		solApel.toFront();
	}
	
	protected void actionPerformedMniActasPropuestas(ActionEvent e) {
		FrmActaPropuesta form = new FrmActaPropuesta();
		form.setVisible(true);
		escritorio.add(form).setLocation(0,0);
		form.toFront();
	}
	
	
	//REPORTE
	
	
	protected void actionPerformedMniReportePropuesta(ActionEvent e) {
		FrmReportePropuesta reporProp = new FrmReportePropuesta();
		reporProp.setVisible(true);
		escritorio.add(reporProp).setLocation(0,0);
		reporProp.toFront();
	}
	
	//AYUDA 
	
	protected void actionPerformedMniQuienesSomos(ActionEvent e) {
		FrmAyuda ayuda= new FrmAyuda();
		ayuda.setVisible(true);
		ayuda.setLocationRelativeTo(this);
	}
	
	//COMITE
	
	protected void actionPerformedMntmComite(ActionEvent e) {
		FrmComite reporContra = new FrmComite ();
		reporContra.setVisible(true);
		escritorio.add(reporContra).setLocation(0,0);
		reporContra.toFront();
	}

}
