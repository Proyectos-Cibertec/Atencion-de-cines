package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Reserva;

public class ArregloReservas {
	// Atributo privado
	private ArrayList<Reserva> reservas;
	private String archivo;
	
	// Constructor
	public ArregloReservas(String archivo) {
		reservas = new ArrayList<Reserva>();
		this.archivo = archivo;
		cargarReservas(); // Lectura en el archivo de texto de Reservas
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
		return reservas.size();
	}
	
	public Reserva obtener(int indice) {
		return reservas.get(indice);
	}
	
	public void adicionar(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void eliminarAlFinal() {
		reservas.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		reservas.clear();
	}
	
	// Operaciones públicas complementarias
	public Reserva buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Reserva reserva) {
		reservas.remove(reserva);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
	
	// Se lee del archivo de texto de Reservas
	public void cargarReservas() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, codigoCliente, codigoEmpleado, codigoFuncion, numeroEntradas, estado;
			String fechaReserva, horaReserva;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				codigoCliente 	= Integer.parseInt(s[1].trim());
				codigoEmpleado 	= Integer.parseInt(s[2].trim());
				codigoFuncion 	= Integer.parseInt(s[3].trim());
				numeroEntradas 	= Integer.parseInt(s[4].trim());
				fechaReserva 	= s[5].trim();
				horaReserva		= s[6].trim();
				estado			= Integer.parseInt(s[7].trim());

				adicionar(new Reserva(codigo, codigoCliente, codigoEmpleado, codigoFuncion, numeroEntradas, fechaReserva,
						horaReserva, estado));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Reservas
	public void grabarReservas() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Reserva reserva : reservas) {
				linea = reserva.getCodigo() + ";" +
						reserva.getCodigoCliente() + ";" + 
						reserva.getCodigoEmpleado() + ";" + 
						reserva.getCodigoFuncion() + ";" +
						reserva.getNumeroEntradas() + ";" +
						reserva.getFechaReserva() + ";" +
						reserva.getHoraReserva() + ";" +
						reserva.getEstado();
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
