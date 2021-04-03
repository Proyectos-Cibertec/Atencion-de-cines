package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import clases.Funcion;

public class ArregloFunciones {
	// Atributo privado
	private ArrayList<Funcion> funciones;
	private String archivo;

	// Constructor
	public ArregloFunciones(String archivo) {
		funciones = new ArrayList<Funcion>();
		this.archivo = archivo;
		cargarFunciones(); // Lectura en el archivo de texto de Funciones
	}
	
	// M�todo de acceso p�blico: set/get
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return funciones.size();
	}
	
	public Funcion obtener(int indice) {
		return funciones.get(indice);
	}
	
	public void adicionar(Funcion funcion) {
		funciones.add(funcion);
	}
	
	public void eliminarAlFinal() {
		funciones.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		funciones.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Funcion buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Funcion funcion) {
		funciones.remove(funcion);
	}
	
	public int codigoCorrelativo() {
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
	
	// Elimina todas las funciones de la sala cuyo c�digo se le pasa como argumento
	public void eliminarFuncionesDeSala(int codigoSala) {
		Iterator<Funcion> itrFunciones = funciones.iterator();
		while (itrFunciones.hasNext()) {
			Funcion funcion= itrFunciones.next();
			if (funcion.getCodigoSala() == codigoSala) {
				itrFunciones.remove();
			}
		}
	}
	
	// Elimina todas las funciones del cine cuyo c�digo se le pasa como argumento
	public void eliminarFuncionesDeCine(int codigoCine) {
		Iterator<Funcion> itrFunciones = funciones.iterator();
		while (itrFunciones.hasNext()) {
			Funcion funcion= itrFunciones.next();
			if (funcion.getCodigoCine() == codigoCine) {
				itrFunciones.remove();
			}
		}
	}
	
	// Se lee del archivo de texto de Funciones
	public void cargarFunciones() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, codigoCine, codigoSala, codigoPelicula;
			String fechaFuncion, horaFuncion;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				codigoCine 		= Integer.parseInt(s[1].trim());
				codigoSala 		= Integer.parseInt(s[2].trim());
				codigoPelicula 	= Integer.parseInt(s[3].trim());
				fechaFuncion 	= s[4].trim();
				horaFuncion 	= s[5].trim();

				adicionar(new Funcion(codigo, codigoCine, codigoSala, codigoPelicula, fechaFuncion, horaFuncion));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Funciones
	public void grabarFunciones() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Funcion funcion : funciones) {
				linea = funcion.getCodigo() + ";" +
						funcion.getCodigoCine() + ";" + 
						funcion.getCodigoSala() + ";" + 
						funcion.getCodigoPelicula() + ";" +
						funcion.getFechaFuncion() + ";" +
						funcion.getHoraFuncion();
				pw.println(linea);
			}
			pw.close();
			
		} catch (Exception e) {

		}
	}
	
	// Se consulta la existencia del archivo
	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}
}
