package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Cliente;

public class ArregloClientes {
	// Atributo privado
	private ArrayList<Cliente> clientes;
	private String archivo;
	
	// Constructor
	public ArregloClientes(String archivo) {
		clientes = new ArrayList<Cliente>();
		this.archivo = archivo;
		cargarClientes(); // Lectura en el archivo de texto de Clientes
		// Clientes de ejemplo
		/*clientes.add(new Cliente(10001, "Julia", "Mendoza", "Ortega", 
				"Jr Los Ópalos 2052", "San Juan de Lurigancho", "25/11/1970", 1, 
				"3751245", "08754242", "julia", "mendoza", "15/07/2004"));
		
		clientes.add(new Cliente(10002, "María", "Ayala", "Apaza", 
				"Calle Las Amatistas 1411", "San Isidro", "25/11/1970", 2, 
				"3751245", "08754242", "maria", "ayala", "15/07/2004"));
		
		clientes.add(new Cliente(10003, "Pedro", "Fernandez", "Marquez", 
				"Av Cabo 111", "Los Olivos", "25/11/1970", 3, 
				"3751245", "08754242", "pedro", "fernandez", "15/07/2004"));*/
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
		return clientes.size();
	}
	
	public Cliente obtener(int indice) {
		return clientes.get(indice);
	}
	
	public void adicionar(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void eliminarAlFinal() {
		clientes.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		clientes.clear();
	}
	
	// Operaciones públicas complementarias
	public Cliente buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Cliente cliente) {
		clientes.remove(cliente);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
	
	// Se lee del archivo de texto de Clientes
	public void cargarClientes() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, estadoCivil;
			String nombres, apellidoPaterno, apellidoMaterno, direccion, distrito, fechaNacimiento,
					telefono, dni, usuario, contraseña, fechaAfiliacion;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				nombres 		= s[1].trim();
				apellidoPaterno = s[2].trim();
				apellidoMaterno = s[3].trim();
				direccion 		= s[4].trim();
				distrito		= s[5].trim();
				fechaNacimiento = s[6].trim();
				fechaAfiliacion = s[7].trim();
				estadoCivil		= Integer.parseInt(s[8].trim());
				telefono 		= s[9].trim();
				dni		 		= s[10].trim();
				usuario 		= s[11].trim();
				contraseña 		= s[12].trim();
				adicionar(new Cliente(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, distrito,
						fechaNacimiento, estadoCivil, telefono, dni, usuario, contraseña, fechaAfiliacion));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Clientes
	public void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Cliente cliente : clientes) {
				linea = cliente.getCodigo() + ";" +
						cliente.getNombres() + ";" + 
						cliente.getApellidoPaterno() + ";" + 
						cliente.getApellidoMaterno() + ";" +
						cliente.getDireccion() + ";" +
						cliente.getDistrito() + ";" +
						cliente.getFechaNacimiento() + ";" +
						cliente.getFechaAfiliacion() + ";" +
						cliente.getEstadoCivil() + ";" +
						cliente.getTelefono() + ";" +
						cliente.getDni() + ";" +
						cliente.getUsuario() + ";" +
						cliente.getContraseña();
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
