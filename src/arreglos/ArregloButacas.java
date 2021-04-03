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
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return butacas.size();
	}
	
	public Butaca obtener(int indice) {
		return butacas.get(indice);
	}
	
	public void adicionar(Butaca butaca) {
		butacas.add(butaca);
	}
	
	public void eliminarAlFinal() {
		butacas.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		butacas.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Butaca buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
