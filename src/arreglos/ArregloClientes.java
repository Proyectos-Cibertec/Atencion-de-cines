package arreglos;

import java.util.ArrayList;

import clases.Cliente;

public class ArregloClientes {
	// Atributo privado
	private ArrayList<Cliente> clientes;
	
	// Constructor
	public ArregloClientes() {
		clientes = new ArrayList<Cliente>();
		
		// Clientes de ejemplo
		clientes.add(new Cliente(10001, "Julia", "Mendoza", "Ortega", 
				"Jr Los Ópalos 2052", "25/11/1970", "15/07/2004", 1, 
				"3751245", "08754242", "julia", "mendoza"));
		
		clientes.add(new Cliente(10002, "María", "Ayala", "Apaza", 
				"Calle Las Amatistas 1411", "25/11/1970", "15/07/2004", 2, 
				"3751245", "08754242", "maria", "ayala"));
		
		clientes.add(new Cliente(10003, "Pedro", "Fernandez", "Marquez", 
				"Av Cabo 111", "25/11/1970", "15/07/2004", 3, 
				"3751245", "08754242", "pedro", "fernandez"));
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
}
