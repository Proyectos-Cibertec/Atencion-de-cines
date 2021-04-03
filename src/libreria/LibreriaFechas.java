package libreria;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.*;

public class LibreriaFechas {
	
	public static void main(String[] args) {
	}
	
	// Obtiene la fecha actual formateada dd/MM/yyyy
	public static Date fechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaActual = new Date(); // Obtiene fecha actual
		return LibreriaFechas.stringToDate(sdf.format(fechaActual));
	}
	
	// Convierte un dato de tipo Date a String
	public static String dateToString(Date fecha) {
		if (fecha == null) {
			return null;
		}
		
		String strFecha = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		strFecha = sdf.format(fecha);
		
		return strFecha;
	}
	
	// Convierte un dato de tipo String cuyo format es: "dd/MM/yyyy" a Date
	public static Date stringToDate(String fecha) {
		Date dateFecha = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateFecha = sdf.parse(fecha);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		
		return dateFecha;
	}
	
	// Obtiene la cantidad de días entre dos fechas
	public static int diasEntreDosFechas(String fecha1, String fecha2) {
		int dias;
		
		String fechaInicial[] = fecha1.split("/");
		String fechaFinal[] = fecha2.split("/");
		int AÑO = 2;
		int MES = 1;
		int DIA = 0;
		
		DateTime inicio = new DateTime(Integer.parseInt(fechaInicial[AÑO]), 
				Integer.parseInt(fechaInicial[MES]), 
				Integer.parseInt(fechaInicial[DIA]), 0, 0, 0, 0);
		
		DateTime fin = new DateTime(Integer.parseInt(fechaFinal[AÑO]), 
				Integer.parseInt(fechaFinal[MES]), 
				Integer.parseInt(fechaFinal[DIA]), 0, 0, 0, 0);
		
		dias = Days.daysBetween(inicio.toLocalDate(), fin.toLocalDate()).getDays();
		
		return dias;
	}
	
	// Retorna verdadero si la primera fecha se encuentra entre las dos fechas siguientes
	public static boolean estaEntreFechas(String fecha, String fechaInicial, String fechaFinal) {
		
		if (LibreriaFechas.diasEntreDosFechas(fechaInicial, fecha) >= 0 && 
				LibreriaFechas.diasEntreDosFechas(fecha, fechaFinal) >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
