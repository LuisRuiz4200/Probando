package vistas;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class FrmActaPropuesta extends JInternalFrame {
	private JLabel lblCodigo;
	private JComboBox<Object> cboIdPropuesta;
	private JTextField txtIdActa;
	private JDateChooser dcFechaActa;
	private JLabel lblFecha;
	private JLabel lblCircunstancia;
	private JEditorPane txtDocumento;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JComboBox<Object> cboEstadoActa;
	private JLabel lblEstado;

	private JPanel panelPropuesta;
	private JLabel lblNumeroPostulacion;
	private JLabel lblFechaPropuesta;
	private JDateChooser dcFechaProp;
	private JTextField txtEstadoProp;
	private JLabel lblEstado_1;
	private JLabel lblIdPedido;
	private JTextField txtIdPedido;
	private JPanel panelPropuesta_1;
	private JLabel lblTipo;
	private JComboBox<Object> cboTipoActa;

	public static void main(String[] args) {

		FrmActaPropuesta form = new FrmActaPropuesta();
		form.setVisible(true);

	}

	public FrmActaPropuesta() {
		getContentPane().setBackground(new Color(192, 192, 192));

		setTitle("Acta de propuesta");
		setBounds(100, 100, 640, 358);
		this.getContentPane().setLayout(null);

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		lblCircunstancia = new JLabel("Motivo / Circunstancia");
		lblCircunstancia.setBounds(17, 136, 137, 14);
		getContentPane().add(lblCircunstancia);

		txtDocumento = new JEditorPane();
		txtDocumento.setBounds(17, 161, 591, 120);
		getContentPane().add(txtDocumento);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(171, 292, 115, 23);
		getContentPane().add(btnRegistrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(348, 292, 115, 23);
		getContentPane().add(btnModificar);

		panelPropuesta = new JPanel();
		panelPropuesta.setLayout(null);
		panelPropuesta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PROPUESTA",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPropuesta.setBounds(17, 11, 291, 114);
		getContentPane().add(panelPropuesta);

		lblNumeroPostulacion = new JLabel("ID Propuesta:");
		lblNumeroPostulacion.setBounds(10, 21, 106, 14);
		panelPropuesta.add(lblNumeroPostulacion);
		
		cboIdPropuesta = new JComboBox<Object>();
		cboIdPropuesta.setBounds(10, 34, 106, 22);
		panelPropuesta.add(cboIdPropuesta);
				
		lblFechaPropuesta = new JLabel("Fecha:");
		lblFechaPropuesta.setBounds(150, 21, 95, 14);
		panelPropuesta.add(lblFechaPropuesta);
						
		dcFechaProp = new JDateChooser();
		dcFechaProp.setBounds(150, 34, 124, 22);
		panelPropuesta.add(dcFechaProp);
								
		lblIdPedido = new JLabel("ID Pedido:");
		lblIdPedido.setBounds(10, 65, 106, 14);
		panelPropuesta.add(lblIdPedido);
										
		txtIdPedido = new JTextField();
		txtIdPedido.setBounds(10, 81, 106, 22);
		panelPropuesta.add(txtIdPedido);
		txtIdPedido.setEditable(false);
		txtIdPedido.setColumns(10);
												
		lblEstado_1 = new JLabel("Estado:");
		lblEstado_1.setBounds(150, 65, 67, 14);
		panelPropuesta.add(lblEstado_1);
														
		txtEstadoProp = new JTextField();
		txtEstadoProp.setBounds(150, 81, 124, 22);
		panelPropuesta.add(txtEstadoProp);
		txtEstadoProp.setText("REGISTRADO");
		txtEstadoProp.setEditable(false);
		txtEstadoProp.setColumns(10);

		panelPropuesta_1 = new JPanel();
		panelPropuesta_1.setLayout(null);
		panelPropuesta_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ACTA",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPropuesta_1.setBounds(317, 11, 291, 114);
		getContentPane().add(panelPropuesta_1);
		
		txtIdActa = new JTextField();
		txtIdActa.setBounds(10, 34, 106, 20);
		panelPropuesta_1.add(txtIdActa);
		txtIdActa.setColumns(10);
				
		lblCodigo = new JLabel("ID Acta:");
		lblCodigo.setBounds(10, 21, 46, 14);
		panelPropuesta_1.add(lblCodigo);
						
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(154, 21, 46, 14);
		panelPropuesta_1.add(lblFecha);
								
		dcFechaActa = new JDateChooser();
		dcFechaActa.setBounds(154, 34, 124, 20);
		panelPropuesta_1.add(dcFechaActa);
										
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 65, 65, 14);
		panelPropuesta_1.add(lblEstado);
												
		cboEstadoActa = new JComboBox<Object>();
		cboEstadoActa.setBounds(10, 81, 106, 22);
		panelPropuesta_1.add(cboEstadoActa);
														
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(154, 65, 65, 14);
		panelPropuesta_1.add(lblTipo);
														
		cboTipoActa = new JComboBox<Object>();
		cboTipoActa.setBounds(154, 81, 124, 22);
		panelPropuesta_1.add(cboTipoActa);

	}
}
