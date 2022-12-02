package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class GenerarReporte {
	public static JasperPrint generar(String fileName, JRBeanCollectionDataSource dataSource, HashMap<String, Object> parameters) {
		JasperPrint jasperPrint = null;
		try {
			
			//Generar el archivo
			
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bufInStr = new BufferedInputStream(fis);
			//cargar el reporte
			JasperReport jasRep =(JasperReport) JRLoader.loadObject(bufInStr);
			jasperPrint = JasperFillManager.fillReport(jasRep, parameters,dataSource);
			
			
		}catch (JRException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error al generar reporte");
		}
		
		return jasperPrint;
	}
}
