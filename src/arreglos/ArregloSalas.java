package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Sala;

public class ArregloSalas {
	// Atributo privado
	private ArrayList<Sala> salas;
	private String archivo;
	
	// Método de acceso público: set/get
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	// Constructor
	public ArregloSalas(String archivo) {
		salas = new ArrayList<Sala>();
		this.archivo = archivo;
		cargarSalas(); // Lectura en el archivo de texto de Salas
	}
	
	// Operaciones públicas básicas
	public int tamaño() {
		return salas.size();
	}
	
	public Sala obtener(int indice) {
		return salas.get(indice);
	}
	
	public void adicionar(Sala sala) {
		salas.add(sala);
	}
	
	public void eliminarAlFinal() {
		salas.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		salas.clear();
	}
	
	// Operaciones públicas complementarias
	public Sala buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	// Determina si ya existe el número de sala en un mismo cine
	public boolean existeSala(int codigoCine, int numeroSala) {
		for (Sala sala : salas) {
			if (sala.getCodigoCine() == codigoCine) {
				if (sala.getNumeroSala() == numeroSala) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	// Retorna el código de la sala cuyo número de sala y código de cine se le pasa como parámetro
	public int obtenerCodigoSala(int numeroSala, int codigoCine) {		
		for (Sala sala : salas) {
			if (sala.getCodigoCine() == codigoCine && sala.getNumeroSala() == numeroSala) {
				return sala.getCodigo();
			}
		}
		return -1;
	}
	
	public void eliminar(Sala sala) {
		salas.remove(sala);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
	
	// Se lee del archivo de texto de Salas
	public void cargarSalas() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, codigoCine, numeroSala, filas, butacas;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				codigoCine 		= Integer.parseInt(s[1].trim());
				numeroSala 		= Integer.parseInt(s[2].trim());
				filas 			= Integer.parseInt(s[3].trim());
				butacas			= Integer.parseInt(s[4].trim());
				
				adicionar(new Sala(codigo, codigoCine, numeroSala, filas, butacas));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Salas
	public void grabarSalas() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Sala sala : salas) {
				linea = sala.getCodigo() + ";" +
						sala.getCodigoCine() + ";" +
						sala.getNumeroSala() + ";" +
						sala.getFilas() + ";" +
						sala.getButacas();
						
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
