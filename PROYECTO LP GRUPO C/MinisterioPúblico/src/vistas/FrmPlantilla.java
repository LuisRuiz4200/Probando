package vistas;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrmPlantilla extends JFrame{
	
	
	
	public static void main(String [] args) {
		
		FrmPlantilla form = new FrmPlantilla();
		form.setVisible(true);
		
	}
	
	public FrmPlantilla() {
		
		setTitle("");
		setBounds(100,100,500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
	}
	
}
