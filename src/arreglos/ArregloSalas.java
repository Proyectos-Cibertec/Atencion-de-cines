package arreglos;

import java.util.ArrayList;

import clases.Sala;

public class ArregloSalas {
	// Atributo privado
	private ArrayList<Sala> salas;
	
	// Constructor
	public ArregloSalas() {
		salas = new ArrayList<Sala>();
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
}
