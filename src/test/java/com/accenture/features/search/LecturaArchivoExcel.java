package com.accenture.features.search;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LecturaArchivoExcel {
	
	
	static String nombreArchivo = "datosExcel.xlsx";
	static String rutaArchivo = "C:\\Users\\ricardo.diaz\\Documents\\" + nombreArchivo;
	String hoja = "Hoja1";

	
	
public  ArrayList<Dato> leer() {

	 ArrayList<Dato> dato  = new ArrayList<>();
	
	
	try  {
		FileInputStream file = new FileInputStream(new File(rutaArchivo));
		// leer archivo excel
		XSSFWorkbook worbook = new XSSFWorkbook(file);
		//obtener la hoja que se va leer
		XSSFSheet sheet = worbook.getSheetAt(0);
		//obtener todas las filas de la hoja excel 
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		 Dato informacion=null;
		// se recorre cada fila hasta el final
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			//se obtiene las celdas por fila
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell;
			//se recorre cada celda
		     int contador = 0;
		     
		  informacion  = new  Dato();
			while (cellIterator.hasNext()) {
				// se obtiene la celda en específico y se la imprime
				cell = cellIterator.next();
            
				switch (contador) {
				case 0:
					informacion.setCorreo(cell.getStringCellValue());
					System.out.println(contador+1 +" Correo ---"+ informacion.getCorreo());
					
					break;
				case 1:
					informacion.setAsunto(cell.getStringCellValue());
					System.out.println(contador+1 +" asunto--- "+ informacion.getAsunto());
					break;
				case 2:
					informacion.setDescripcion(cell.getStringCellValue());
					System.out.println(contador+1 +" descripcion ----"+ informacion.getDescripcion());
					break;
			
				}
		
				contador++;
			}
			System.out.println();
			dato.add(informacion);
		}
		
		
	} catch (Exception e) {
		e.getMessage();
	}
	return dato;
}
	

}
