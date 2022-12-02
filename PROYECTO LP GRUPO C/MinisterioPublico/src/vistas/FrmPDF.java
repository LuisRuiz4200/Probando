package vistas;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FrmPDF extends JInternalFrame{
	public static JPanel panelReporte;
	
	
	
	/*public static void main(String [] args) {
		
		FrmPDF form = new FrmPDF();
		form.setVisible(true);
		
	}*/
	
	public FrmPDF() {
		
		
		setTitle("PDF");
		setBounds(100,100,944,547);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "REPORTE EN PDF", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelReporte.setBounds(25, 11, 893, 486);
		panelReporte.setLayout(new BorderLayout(0,0));
		getContentPane().add(panelReporte);
		
	}
	
}
