package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Empleado;

public class ArregloEmpleados {
	// Atributo privado
	private ArrayList<Empleado> empleados;
	private String archivo;

	// Constructor
	public ArregloEmpleados(String archivo) {
		empleados = new ArrayList<Empleado>();
		this.archivo = archivo;
		cargarEmpleados(); // Lectura en el archivo de texto de Empleados
		
		// Empleados de ejemplo
		/*
		empleados.add(new Empleado(10001, "Luis", "Guisado", "Mena", 0, "luis", "guisado"));
		empleados.add(new Empleado(10002, "Brian", "Cruz", "Rodriguez", 1, "brian", "cruz"));
		empleados.add(new Empleado(10003, "Eduardo", "Vite", "Mayaute", 2, "eduardo", "vite"));
		empleados.add(new Empleado(10004, "Jaime", "Paredes", "Trejo", 2, "jaime", "paredes"));
		empleados.add(new Empleado(10005, "Walter", "Napan", "Tarmeño", 2, "walter", "napan"));*/
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
		return empleados.size();
	}
	
	public Empleado obtener(int indice) {
		return empleados.get(indice);
	}
	
	public void adicionar(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public void eliminarAlFinal() {
		empleados.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		empleados.clear();
	}
	
	// Operaciones públicas complementarias
	public Empleado buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Empleado empleado) {
		empleados.remove(empleado);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
	
	// Se lee del archivo de texto de Empleados
	public void cargarEmpleados() {
		try {
			BufferedReader br;
			String linea, s[];
			int codigo, tipo;
			String nombres, apellidoPaterno, apellidoMaterno, usuario, contraseña;
			br = new BufferedReader(new FileReader(archivo));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo 			= Integer.parseInt(s[0].trim());
				nombres 		= s[1].trim();
				apellidoPaterno = s[2].trim();
				apellidoMaterno = s[3].trim();
				tipo 			= Integer.parseInt(s[4].trim());
				usuario 		= s[5].trim();
				contraseña 		= s[6].trim();
				adicionar(new Empleado(codigo, nombres, apellidoPaterno, apellidoMaterno, tipo, usuario, contraseña));
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	
	// Se escribe en el archivo de texto de Empleados
	public void grabarEmpleados() {
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter(archivo));
			
			for (Empleado empleado : empleados) {
				linea = empleado.getCodigo() + ";" +
						empleado.getNombres() + ";" + 
						empleado.getApellidoPaterno() + ";" + 
						empleado.getApellidoMaterno() + ";" + 
						empleado.getTipo() + ";" +
						empleado.getUsuario() + ";" +
						empleado.getContraseña();
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
