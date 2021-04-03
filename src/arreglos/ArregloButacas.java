package arreglos;

import java.util.ArrayList;

import clases.Butaca;

public class ArregloButacas {
	// Atributo privado
	private ArrayList<Butaca> butacas;
	
	// Constructor
	public ArregloButacas() {
		butacas = new ArrayList<Butaca>();
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
}
