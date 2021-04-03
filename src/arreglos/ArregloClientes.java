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
				"Jr Los �palos 2052", "25/11/1970", "15/07/2004", 1, 
				"3751245", "08754242", "julia", "mendoza"));
		
		clientes.add(new Cliente(10002, "Mar�a", "Ayala", "Apaza", 
				"Calle Las Amatistas 1411", "25/11/1970", "15/07/2004", 2, 
				"3751245", "08754242", "maria", "ayala"));
		
		clientes.add(new Cliente(10003, "Pedro", "Fernandez", "Marquez", 
				"Av Cabo 111", "25/11/1970", "15/07/2004", 3, 
				"3751245", "08754242", "pedro", "fernandez"));
	}
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return clientes.size();
	}
	
	public Cliente obtener(int indice) {
		return clientes.get(indice);
	}
	
	public void adicionar(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void eliminarAlFinal() {
		clientes.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		clientes.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Cliente buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
