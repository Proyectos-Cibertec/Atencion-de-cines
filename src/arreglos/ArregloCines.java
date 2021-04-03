package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Cine;

public class ArregloCines {
	// Atributo privado
	private ArrayList<Cine> cines;
	private String archivo;
	
	// Constructor
	public ArregloCines(String archivo) {
		cines = new ArrayList<Cine>();
		this.archivo = archivo;
		cargarCines(); // Lectura en el archivo de texto de Cines
		
		// Cines de ejemplo
		/*cines.add(new Cine(10001, "Cine Star", "Lima", "Lima", "SJL", "20/10/2003", 0));
		cines.add(new Cine(10002, "Cineplanet", "Lima", "Lima", "Miraflores", "10/02/2014", 1));
		cines.add(new Cine(10003, "Cinemark", "Lima", "Lima", "San Isidro", "01/01/2016", 0));
		cines.add(new Cine(10004, "UVK", "Lima", "Lima", "Jesús María", "01/03/2015", 1));
		cines.add(new Cine(10005, "Cinépolis", "Lima", "Lima", "Breña", "15/08/2009", 0));
		cines.add(new Cine(10006, "Cines Plaza", "Lima", "Lima", "Santa Anita", "13/01/207", 1));
		cines.add(new Cine(10007, "Movietime", "Lima", "Lima", "La Molina", "01/01/2016", 0));*/
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
		return cines.size();
	}
	
	public Cine obtener(int indice) {
		return cines.get(indice);
	}
	
	public void adicionar(Cine cine) {
		cines.add(cine);
	}
	
	public void eliminarAlFinal() {
		cines.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		cines.clear();
	}
	
	// Operaciones públicas complementarias
	public Cine buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	// Retorna el código del cine cuyo nombre se le pasa como argumento
	public int obtenerCodigoCine(String nombreCine) {		
		for (Cine cine : cines) {
			if (cine.getNombre().equalsIgnoreCase(nombreCine)) {
				return cine.getCodigo();
			}
		}
		return -1;
	}
	
	public void eliminar(Cine cine) {
		cines.remove(cine);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
	
	// Se lee del archivo de texto de Cines
	public void cargarCines() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, tipo;
			String nombre, departamento, provincia, distrito, fechaInicio;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				nombre	 		= s[1].trim();
				departamento 	= s[2].trim();
				provincia 		= s[3].trim();
				distrito 		= s[4].trim();
				fechaInicio 	= s[5].trim();
				tipo			= Integer.parseInt(s[6].trim());
				
				adicionar(new Cine(codigo, nombre, departamento, provincia, distrito, fechaInicio, tipo));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Cines
	public void grabarCines() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Cine cine : cines) {
				linea = cine.getCodigo() + ";" +
						cine.getNombre() + ";" + 
						cine.getDepartamento() + ";" + 
						cine.getProvincia() + ";" +
						cine.getDistrito() + ";" +
						cine.getFechaInicio() + ";" +
						cine.getTipo();
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
