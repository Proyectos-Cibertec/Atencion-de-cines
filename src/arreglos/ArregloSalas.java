package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import clases.Sala;

public class ArregloSalas {
	// Atributo privado
	private ArrayList<Sala> salas;
	private String archivo;
	
	// M�todo de acceso p�blico: set/get
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
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return salas.size();
	}
	
	public Sala obtener(int indice) {
		return salas.get(indice);
	}
	
	public void adicionar(Sala sala) {
		salas.add(sala);
	}
	
	public void eliminarAlFinal() {
		salas.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		salas.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Sala buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	// Determina si ya existe el n�mero de sala en un mismo cine
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
	
	// Retorna el c�digo de la sala cuyo n�mero de sala y c�digo de cine se le pasa como par�metro
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
	
	// Elimina todas las salas del cine cuyo c�digo se le pasa como argumento
	public void eliminarSalasDeCine(int codigoCine) {
		Iterator<Sala> itrSalas = salas.iterator();
		while (itrSalas.hasNext()) {
			Sala sala = itrSalas.next();
			if (sala.getCodigoCine() == codigoCine) {
				itrSalas.remove();
			}
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
