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
	
	// Operaciones p�blicas b�sicas
	public int tama�o() {
		return salas.size();
	}
	
	public Sala obtener(int indice) {
		return salas.get(indice);
	}
	
	public void adicionar(Sala sala) {
		salas.add(sala);
	}
	
	public void eliminarAlFinal() {
		salas.remove(tama�o() - 1);
	}
	
	public void eliminarTodo() {
		salas.clear();
	}
	
	// Operaciones p�blicas complementarias
	public Sala buscar(int codigo) {
		for (int i = 0; i < tama�o(); i++) {
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
		if (tama�o() == 0) {
			return 10001;
		} else {
			return obtener(tama�o() - 1).getCodigo() + 1;
		}
	}
}
