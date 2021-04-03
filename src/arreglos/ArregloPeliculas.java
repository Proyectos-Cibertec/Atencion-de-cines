package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Pelicula;

public class ArregloPeliculas {
	// Atributo privado
	private ArrayList<Pelicula> peliculas;
	private String archivo;

	// Constructor
	public ArregloPeliculas(String archivo) {
		peliculas = new ArrayList<Pelicula>();
		this.archivo = archivo;
		cargarPeliculas(); // Lectura en el archivo de texto de Pel�culas
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
		return peliculas.size();
	}
	
	public Pelicula obtener(int indice) {
		return peliculas.get(indice);
	}
	
	public void adicionar(Pelicula pelicula) {
		peliculas.add(pelicula);
	}
	
	public void eliminarAlFinal() {
		peliculas.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		peliculas.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Pelicula buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	// Retorna el c�digo de la pel�cula cuyo nombre (t�tulo de distribuci�n) se le pasa como argumento
	public int obtenerCodigoPelicula(String nombrePelicula) {		
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getTituloDistribucion().equalsIgnoreCase(nombrePelicula)) {
				return pelicula.getCodigo();
			}
		}
		return -1;
	}
	
	// Retorna el nombre de la pel�cula (t�tulo de distribuci�n) cuyo c�digo se le pasa como argumento
	public String obtenerNombrePelicula(int codigoPelicula) {		
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getCodigo() == codigoPelicula) {
				return pelicula.getTituloDistribucion();
			}
		}
		return null;
	}
	
	public void eliminar(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}
	
	public int codigoCorrelativo() {
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
	
	// Se lee del archivo de texto de Pel�culas
	public void cargarPeliculas() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, tipoProyeccion, duracion, tipoCensura, estadoProyeccion;
			String tituloDistribucion, tituloOriginal, fechaEstreno, genero, paisOrigen, sinopsis;
			double recaudacion;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 				= Integer.parseInt(s[0].trim());
				tituloDistribucion 	= s[1].trim();
				tituloOriginal 		= s[2].trim();
				fechaEstreno 		= s[3].trim();
				tipoProyeccion 		= Integer.parseInt(s[4].trim());
				genero 				= s[5].trim();
				paisOrigen 			= s[6].trim();
				sinopsis 			= s[7].trim();
				duracion 			= Integer.parseInt(s[8].trim());
				tipoCensura 		= Integer.parseInt(s[9].trim());
				estadoProyeccion 	= Integer.parseInt(s[10].trim());
				recaudacion 		= Double.parseDouble(s[11].trim());
				
				adicionar(new Pelicula(codigo, tituloDistribucion, tituloOriginal, fechaEstreno, tipoProyeccion, genero, 
						paisOrigen, sinopsis, duracion, tipoCensura, estadoProyeccion, recaudacion));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Pel�culas
	public void grabarPeliculas() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Pelicula pelicula : peliculas) {
				linea = pelicula.getCodigo() + ";" +
						pelicula.getTituloDistribucion() + ";" + 
						pelicula.getTituloOriginal() + ";" + 
						pelicula.getFechaEstreno() + ";" +
						pelicula.getTipoProyeccion() + ";" +
						pelicula.getGenero() + ";" +
						pelicula.getPaisOrigen() + ";" +
						pelicula.getSinopsis() + ";" +
						pelicula.getDuracion() + ";" +
						pelicula.getTipoCensura() + ";" +
						pelicula.getEstadoProyeccion() + ";" +
						pelicula.getRecaudacion();
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
