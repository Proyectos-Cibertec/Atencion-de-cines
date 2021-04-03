package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.DetalleReserva;

public class ArregloDetalleReservas {
	// Atributo privado
	private ArrayList<DetalleReserva> detalleReservas;
	private String archivo;
	
	// Constructor
	public ArregloDetalleReservas(String archivo) {
		detalleReservas = new ArrayList<DetalleReserva>();
		this.archivo = archivo;
		cargarDetalleReservas(); // Lectura en el archivo de DetalleReserva
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
		return detalleReservas.size();
	}
	
	public DetalleReserva obtener(int indice) {
		return detalleReservas.get(indice);
	}
	
	public void adicionar(DetalleReserva detalleReserva) {
		detalleReservas.add(detalleReserva);
	}
	
	public void eliminarAlFinal() {
		detalleReservas.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		detalleReservas.clear();
	}
	
	// Operaciones públicas complementarias
	public DetalleReserva buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(DetalleReserva detalleReserva) {
		detalleReservas.remove(detalleReserva);
	}
	
	public void eliminarPorButacaOcupada() {
		
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
	
	// Se lee del archivo de texto de DetalleReservas
	public void cargarDetalleReservas() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, codigoButaca, codigoReserva, tipoEntrada;
			double precioEntrada;

			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				codigoButaca 	= Integer.parseInt(s[1].trim());
				codigoReserva 	= Integer.parseInt(s[2].trim());
				tipoEntrada 	= Integer.parseInt(s[3].trim());
				precioEntrada 	= Double.parseDouble(s[4].trim());


				adicionar(new DetalleReserva(codigo, codigoButaca, codigoReserva, tipoEntrada, precioEntrada));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de DetalleReservas
	public void grabarDetalleReservas() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (DetalleReserva detalleReserva : detalleReservas) {
				linea = detalleReserva.getCodigo() + ";" +
						detalleReserva.getCodigoButaca() + ";" + 
						detalleReserva.getCodigoReserva() + ";" + 
						detalleReserva.getTipoEntrada() + ";" +
						detalleReserva.getPrecioEntrada();
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
