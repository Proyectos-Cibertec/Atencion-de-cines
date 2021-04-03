package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Butaca;

public class ArregloButacas {
	// Atributo privado
	private ArrayList<Butaca> butacas;
	private String archivo;
	
	// Método de acceso público: set/get
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	// Constructor
	public ArregloButacas(String archivo) {
		butacas = new ArrayList<Butaca>();
		this.archivo = archivo;
		cargarButacas(); // Lectura en el archivo de texto de Butacas
	}
	
	// Operaciones públicas básicas
	public int tamaño() {
		return butacas.size();
	}
	
	public Butaca obtener(int indice) {
		return butacas.get(indice);
	}
	
	public void adicionar(Butaca butaca) {
		butacas.add(butaca);
	}
	
	public void eliminarAlFinal() {
		butacas.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		butacas.clear();
	}
	
	// Operaciones públicas complementarias
	public Butaca buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Butaca butaca) {
		butacas.remove(butaca);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}

	// Se lee del archivo de texto de Butacas
	public void cargarButacas() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, codigoSala, numeroFila, numeroColumna, estado;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				codigoSala 		= Integer.parseInt(s[1].trim());
				numeroFila 		= Integer.parseInt(s[2].trim());
				numeroColumna 	= Integer.parseInt(s[3].trim());
				estado			= Integer.parseInt(s[4].trim());
				
				adicionar(new Butaca(codigo, codigoSala, numeroFila, numeroColumna, estado));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Butacas
	public void grabarButacas() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Butaca butaca : butacas) {
				linea = butaca.getCodigo() + ";" +
						butaca.getCodigoSala() + ";" +
						butaca.getNumeroFila() + ";" +
						butaca.getNumeroColumna() + ";" +
						butaca.getEstado();
						
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
