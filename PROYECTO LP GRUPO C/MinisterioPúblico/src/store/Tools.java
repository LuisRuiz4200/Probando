package store;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Tools {

	
	public static void mensajeError(Component pos,String msj) {
		JOptionPane.showMessageDialog(pos, msj, "ERROR!",0);
	}

	
	public static void mensajeExito(Component pos, String msj) {
		JOptionPane.showMessageDialog(pos, msj, "EXITO!",1);
	}

	
	public static void imprimir(JTextArea txtS, String cad) {
		txtS.append( cad + "\n");	
	}
	
	

}
