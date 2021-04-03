package arreglos;

import java.util.ArrayList;

import clases.Empleado;

public class ArregloEmpleados {
	// Atributo privado
	private ArrayList<Empleado> empleados;
	private String archivo;
	
	// Constructor
	public ArregloEmpleados() {
		// Se inicializa el ArrayList de Empleados
		empleados = new ArrayList<Empleado>();
		
		// Empleados de ejemplo
		empleados.add(new Empleado(10001, "Luis", "Guisado", "Mena", 0, "luis", "guisado"));
		empleados.add(new Empleado(10002, "Brian", "Cruz", "Rodriguez", 1, "brian", "cruz"));
		empleados.add(new Empleado(10003, "Eduardo", "Vite", "Mayaute", 2, "eduardo", "vite"));
		empleados.add(new Empleado(10004, "Jaime", "Paredes", "Trejo", 2, "jaime", "paredes"));
		empleados.add(new Empleado(10005, "Walter", "Napan", "Tarme�o", 2, "walter", "napan"));
	}
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return empleados.size();
	}
	
	public Empleado obtener(int indice) {
		return empleados.get(indice);
	}
	
	public void adicionar(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public void eliminarAlFinal() {
		empleados.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		empleados.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Empleado buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
