package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	
	// Método de acceso público: set/get
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	// Operaciones públicas básicas
	public int tamaño() {
		return funciones.size();
	}
	
	public Funcion obtener(int indice) {
		return funciones.get(indice);
	}
	
	public void adicionar(Funcion funcion) {
		funciones.add(funcion);
	}
	
	public void eliminarAlFinal() {
		funciones.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		funciones.clear();
	}
	
	// Operaciones públicas complementarias
	public Funcion buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
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
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
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
