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
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return funciones.size();
	}
	
	public Funcion obtener(int indice) {
		return funciones.get(indice);
	}
	
	public void adicionar(Funcion funcion) {
		funciones.add(funcion);
	}
	
	public void eliminarAlFinal() {
		funciones.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		funciones.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Funcion buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
