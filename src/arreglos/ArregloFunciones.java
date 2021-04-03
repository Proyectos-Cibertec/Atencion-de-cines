package arreglos;

import java.util.ArrayList;

import clases.Funcion;

public class ArregloFunciones {
	// Atributo privado
	private ArrayList<Funcion> funciones;
	
	// Constructor
	public ArregloFunciones() {
		funciones = new ArrayList<Funcion>();
	}
	
	// Operaciones públicas básicas
	public int tamaño() {
		return funciones.size();
	}
	
	public Funcion obtener(int indice) {
		return funciones.get(indice);
	}
	
	public void adicionar(Funcion funcion) {
		funciones.add(funcion);
	}
	
	public void eliminarAlFinal() {
		funciones.remove(tamaño() - 1);
	}
	
	public void eliminarTodo() {
		funciones.clear();
	}
	
	// Operaciones públicas complementarias
	public Funcion buscar(int codigo) {
		for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodigo() == codigo) {
				return obtener(i);
			}
		}
		
		return null;
	}
	
	public void eliminar(Funcion funcion) {
		funciones.remove(funcion);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10001;
		} else {
			return obtener(tamaño() - 1).getCodigo() + 1;
		}
	}
}
